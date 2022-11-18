
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
      // token 过期时间为一小时, 50分钟刷新一次
      state.refresh = setInterval(() => {
        API.get('refreshToken')
          .then(res => {
            if (res.code === 200) {
              state.author.password = res.data
            }
          })
      }, 50 * 60 * 1000);
    },
    logout(state) {
      // 作者切换为默认
      API.get('init/author', { authorId: state.defaultAuthorId })
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
    setArticle(state, article) {
      state.article = article
      // 解析tag
      state.article.tag = JSON.parse(article.tag).tags
      // 请求文章内容
      let data = { "fileName": article.content.split('\\')[1] }
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
    }
  }
})

export default store;

