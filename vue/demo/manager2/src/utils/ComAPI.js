import axios from "axios";
import store from "../store";
import router from "@/router";

// 创建对象
const instance = axios.create({
  // baseURL: "http://localhost:8080",
  timeout: 1000,
  // headers: {'X-Custom-Header': 'foobar'}
});

// 添加请求拦截器
instance.interceptors.request.use(
  function (config) {
    if (store.state.userInfo.token) {
      config.headers['token'] = store.state.userInfo.token
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
    // 2xx 范围内的状态码都会触发该函数。服务器正确返回, 包括返回错误信息
    // 对响应数据做点什么
    console.log('response', response.data.message, response);
    if (response.data.code != 200) {
      switch (response.data.code) {
        case 401://token 过期
          ElMessage({ 
            showClose: true,
            message: response.data.message,
            type: 'warning',
          })
          store.commit("clear")
          router.replace({ name: "Login" })
          break;
        case 409://成员列表获取失败
          ElMessage({
            showClose: true,
            message: response.data.message,
            type: 'warning',
          })
          break;
        default:
          ElMessage({
            showClose: true,
            message: response.data.message,
            type: 'warning',
          })
          router.push({ name: "Error" })
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
          message: "服务器错误(500)",
          type: 'warning',
        })
        break
      case 404:
        ElMessage({
          showClose: true,
          message: "请检查请求地址(404)",
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
