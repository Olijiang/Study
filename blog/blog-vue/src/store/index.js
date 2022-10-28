import { createStore } from "vuex";
// import router from "@/router";
// 创建一个新的 store 实例
const store = createStore({
  state() {
    return {
      authorInfo: {},
      loginFlag: false
    }
  },
  mutations: {
    putAuthorInfo(state, author) {
      state.authorInfo = author
    },
  }
})

export default store;

