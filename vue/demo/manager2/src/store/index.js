import { createStore } from "vuex";

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
        routers: [], // 接收的动态路由
        routersX: ["Home", "Main", "Error", "Login", "404"] // 已经添加的路由
      },
      isCollapse: false,
      currentTag: {
        index: "1",
        path: "Home",
        itemName: "首页",
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
        routers: [],
        routersX: ["Home", "Main", "Error", "Login"]
      };
      state.currentTag = {
        index: "1",
        path: "Home",
        itemName: "首页",
      };
    },

    setRouters(state, routerData) {
      // 设置路由信息
      routerData.forEach(element => {
        if (element.children) {
          element.children.forEach(child => { //二级路由
            if (!state.userInfo.routersX.includes(child.path)) {
              let e = {
                path: child.path,
                name: child.path,
                index: child.index,
                label: child.itemName
              }
              state.userInfo.routersX.push(child.path)
              state.userInfo.routers.push(e)
            }
          })
        } else {
          if (!state.userInfo.routersX.includes(element.path)) {
            let e = {
              path: element.path,
              name: element.path,
              index: element.index,
              label: element.itemName
            }
            state.userInfo.routersX.push(e.path)
            state.userInfo.routers.push(e)
          }
        }
      })
      // // console.log(state.userInfo.routers);
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
        if (state.tags[i].index === state.currentTag.index) {
          state.tags[i].type = "success";
        } else {
          state.tags[i].type = "";
        }
      }
    },
    addTag(state) {
      //let一个index来接收findIndex的结果，这里arrText为要查找的数组
      let index = this.state.tags.findIndex((tag) => {
        return tag.index === state.currentTag.index;
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
        return tag.index === Deletetag.index;
      });
      //找到该元素，使用splice方法删除元素
      // console.log("index", index);
      let tempTag = state.tags[index];
      this.state.tags.splice(index, 1);
      //if删除的激活标签, 激活切换下一个标签
      if (tempTag.index === state.currentTag.index) {
        if (state.tags.length > 0) {
          if (index > 0) {
            state.currentTag = state.tags[index - 1];
          } else {
            state.currentTag = state.tags[0];
          }
          this.commit("changeTag", state.currentTag);
        } else {
          state.currentTag = {
            index: "1",
            path: "Home",
            itemName: "首页",
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
