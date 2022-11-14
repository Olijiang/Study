
import { createStore } from "vuex";
import API from "../utils/API";
// import router from "@/router";
// 创建一个新的 store 实例
const store = createStore({
  state() {
    return {
      defaultAuthorId: "2020",
      author: undefined,
      loginDialog: false, //控制登录窗口
      editDialog: false, //控制文章编辑窗口
      isLogin: false,  //控制是否登录
      refresh: null
    }
  },
  mutations: {
    login(state, author) {
      state.author = author
      state.isLogin = true
      // token 过期时间为一小时, 50分钟刷新一次
      state.refresh = setInterval(() => {
        API.get('api/refreshToken')
          .then(res => {
            if (res.code === 200) {
              state.author.password = res.data
            }
          })
      }, 50 * 60 * 1000);
    },
    logout(state) {
      // 作者切换为默认
      API.get('api/init/author', { authorId: state.defaultAuthorId })
        .then(res => {
          if (res.code == 200) {
            state.author = res.data
          }
        })
      state.isLogin = false
      clearInterval(state.refresh)
    },
    setAuthorInfo(state, author) {
      state.author = author
    },
  }
})

export default store;

