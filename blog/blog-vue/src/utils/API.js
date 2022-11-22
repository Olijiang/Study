import axios from "axios";
import store from "../store";
import router from "@/router";

// 创建对象
const instance = axios.create({
  baseURL: (import.meta.env.MODE == 'development') ? window.developmentUrl : window.productionUrl,
  timeout: 3000,
});

console.log(import.meta.env.MODE);

// 添加请求拦截器
instance.interceptors.request.use(
  function (config) {
    if (store.state.author != undefined && store.state.author.password != "") {
      config.headers['token'] = store.state.author.password
    }
    return config;
  },
  function (error) {
    // 对请求错误做些什么
    return Promise.reject(error);
  }
);

// 添加响应拦截器
instance.interceptors.response.use(
  function (response) {
    // response.status 在 2xx 范围内的状态码都会触发该函数。服务器正确返回, 包括返回错误信息
    // 对响应数据做点什么
    console.log(response.data.message, response.data);
    if (response.data.code != 200) {
      switch (response.data.code) {
        case 401://token 过期
          ElMessage({
            showClose: true,
            message: response.data.message,
            type: 'warning',
          })
          store.commit("logout")
          router.replace({ path: "/" + 2020 })
          break;
        default:
          ElMessage({
            showClose: true,
            message: response.data.message,
            type: 'warning',
          })
          break;
      }
    }
    return response.data;
  },
  function (error) {
    // 超出 2xx 范围的状态码都会触发该函数。
    // 对响应错误做点什么
    console.log(error);
    switch (error.response.status) {
      case 500:
        ElMessage({
          showClose: true,
          message: "服务器未连接(500)",
          type: 'warning',
        })
        break
      case 404:
        ElMessage({
          showClose: true,
          message: "请求地址错误(404)",
          type: 'warning',
        })
        break
      default:
        ElMessage({
          showClose: true,
          message: error.message,
          type: 'warning',
        })
    }
    return Promise.reject(error);
  }
);


const ComAPI = class {
  get(url, params) {
    return instance({ url, params }).then((res) => {
      return res;
    }).catch((err) => {
      return err;
    });
  }

  post(url, data) {
    return instance({
      url,
      data,
      method: "post",
    }).then((res) => {
      return res;
    }).catch((err) => {
      return err;
    });
  }
};


export default new ComAPI;
