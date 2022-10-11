import { createStore } from "vuex";
import router from "@/router";
// 创建一个新的 store 实例
const store = createStore({
  state() {
    return {
      requested: false,   // 新增 tab 的改为true， 页面数据重新请求 
      userInfo: {
        uid: "",
        userName: "",
        userType: "",
        token: "",
      },
      routers: [], // 接收的动态路由
      isCollapse: false,
      currentTag: {
        path: "/Home",
        label: "首页",
        name: "Home"
      },
      tags: [],
    };
  },
  mutations: {
    clear(state) {
      state.requested = false;
      state.isCollapse = false;
      state.tags = [];
      state.userInfo = {
        uid: "",
        userName: "",
        userType: "",
        token: "",
      };
      state.routers = [];
      state.currentTag = {
        path: "/Home",
        label: "首页",
        name: "Home"
      };
    },
    saveRouters(state, routers) {
      state.routers = routers
    },
    // 注册路由
    addRouters(state) {
      const routers = state.routers
      this.commit('addRouter', routers)
    },
    addRouter(state, routers) {
      // console.log(routers);
      routers.forEach((p) => {
        let route = {
          name: p.name,
          path: p.path,
          component: () => import('@/views/' + p.name + '.vue')
        }
        router.addRoute('Main', route)
        if (p.children) this.commit('addRouter', p.children)
      })
    },

    addToken(state, res) {
      state.userInfo.uid = res.uid;
      state.userInfo.userName = res.userName;
      state.userInfo.userType = res.userType;
      state.userInfo.token = res.token;
    },
    foldMenu(state) {
      state.isCollapse = !state.isCollapse;
    },
    changeTag(state, tag) {
      // 改变当前激活对象，将 tag标签 设置 高亮
      state.currentTag = tag;
      for (let i = 0; i < state.tags.length; i++) {
        if (state.tags[i].name === state.currentTag.name) {
          state.tags[i].type = "success";
        } else {
          state.tags[i].type = "";
        }
      }
    },
    addTag(state) {
      //let一个index来接收findIndex的结果，这里arrText为要查找的数组
      let index = this.state.tags.findIndex((tag) => {
        return tag.name === state.currentTag.name;
      });
      // console.log("index", index);
      // 找不到再添加
      if (index === -1) {
        state.tags.push(state.currentTag);
        // 数据重新请求
        state.requested = true
      }
      this.commit("changeTag", state.currentTag);
    },
    removeTag(state, Deletetag) {
      let index = this.state.tags.findIndex((tag) => {
        return tag.name === Deletetag.name;
      });
      //找到该元素，使用splice方法删除元素
      // console.log("index", index);
      let tempTag = state.tags[index];
      this.state.tags.splice(index, 1);
      //if删除的激活标签, 激活切换下一个标签
      if (tempTag.name === state.currentTag.name) {
        if (state.tags.length > 0) {
          if (index > 0) {
            state.currentTag = state.tags[index - 1];
          } else {
            state.currentTag = state.tags[0];
          }
          this.commit("changeTag", state.currentTag);
        } else {
          state.currentTag = {
            name: "Home",
            path: "/Home",
            label: "首页",
          };
        }
      }
    },
  },
});

export default store;

// const app = createApp({ /* 根组件 */ })

// // 将 store 实例作为插件安装
// app.use(store)
