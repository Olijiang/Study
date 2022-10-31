import { createStore } from "vuex";
// import router from "@/router";
// 创建一个新的 store 实例
const store = createStore({
  state() {
    return {
      authorInfo: {
        name: "",
        desc: "",
        articleN: 0,
        categoryN: 0,
        tagN: 0,
        imgUrl: ""
      },
      loginFlag: false, //控制登录窗口
      isLogin: false  //控制是否登录
    }
  },
  mutations: {
    login(state, author) {
      // state.authorInfo = author
      state.isLogin = true
    },
    logout(state, author) {
      // state.authorInfo = {}
      state.isLogin = false
    },
    setAuthorInfo(state, author) {
      state.authorInfo = author
    }
  }
})

export default store;

