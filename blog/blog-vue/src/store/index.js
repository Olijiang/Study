
import { createStore } from "vuex";
import API from "../utils/API";
// import router from "@/router";
// 创建一个新的 store 实例
const store = createStore({
  state() {
    return {
      albums: [],
      author: undefined,
      loginDialog: false, //控制登录窗口
      editDialog: false, //控制文章编辑窗口
      isLogin: false,  //控制是否登录
      refresh: null,
      article: {
        authorId: "",
        title: "",
        category: "",
        tag: [],
        content: "",
        img: ""
      }
    }
  },
  mutations: {
    login(state, author) {
      state.author = author
      state.isLogin = true
      // token 过期时间为一小时, 45分钟刷新一次 2700000
      // 页面刷新就失效了, 可能是刷新时序列化造成的
      state.refresh = setInterval(() => {
        API.get('refreshToken')
          .then(res => {
            if (res.code === 200) {
              console.log(res.data);
              state.author.password = res.data
            }
          })
      }, 2700000);
    },
    logout(state) {
      state.isLogin = false
      clearInterval(state.refresh)
    },
    setAuthorInfo(state, author) {
      if (state.author) {
        author.password = state.author.password
      }
      state.author = author
    },
    setArticle(state, article) {
      state.article = article
      // 解析tag
      state.article.tag = JSON.parse(article.tag).tags
      // 请求文章内容
      let data = { "filePath": article.content }
      API.get('init/getContent', data)
        .then(res => {
          if (res.code == 200) {
            state.article.content = res.data
          }
        })
    },
    clearArticle(state) {
      for (let key in state.article) {
        if (key == "tag") state.article[key] = []
        state.article[key] = ""
      }
      console.log("clearArticle", state.article);
    },
    setAlbums(state, albums) {
      state.albums = albums
    }
  }
})

export default store;

