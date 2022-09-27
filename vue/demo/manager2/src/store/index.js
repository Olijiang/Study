import { createStore } from "vuex";

// 创建一个新的 store 实例
const store = createStore({
  state() {
    return {
      token:{
        type:'未登录'
      },
      isCollapse: false,
      activeIndex: "",
      currentTag: {
        index: "1",
        path: "Home",
        itemName: "首页",
      },
      tags: [],
    };
  },
  mutations: {
    clear(state){
      state.token.type='未登录',
      state.isCollapse= false,
      state.activeIndex= "",
      state.tags= [],
      state.currentTag= {
        index: "1",
        path: "Home",
        itemName: "首页",
      }
    },
    addToken(state, token){
      state.token = token
    },
    removeToken(state){
      state.token = ''
    },
    foldMenu(state) {
      state.isCollapse = !state.isCollapse;
    },
    changeTag(state, tag){
      // 改变当前激活对象，将 tag标签 设置 高亮
      state.currentTag = tag
      for(let i=0; i<state.tags.length; i++) {
        if(state.tags[i].index === state.currentTag.index){
          state.tags[i].type = 'success'
        }else{
          state.tags[i].type = ''
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
      }
      this.commit('changeTag', state.currentTag)
    },
    removeTag(state, Deletetag) {
      let index = this.state.tags.findIndex((tag) => {
        return tag.index === Deletetag.index;
      });
      //找到该元素，使用splice方法删除元素
      // console.log("index", index);
      let tempTag = state.tags[index]
      this.state.tags.splice(index, 1);
      //if删除的激活标签, 激活切换下一个标签
      if(tempTag.index === state.currentTag.index){
        if(state.tags.length>0){
          if(index>0){
            state.currentTag = state.tags[index-1]
          }else{
            state.currentTag = state.tags[0]
          }
          this.commit('changeTag',state.currentTag)
        }else{
          state.currentTag = {
            index: "1",
            path: "Home",
            itemName: "首页",
          }
        }
      }
    },
  },
});

export default store;

// const app = createApp({ /* 根组件 */ })

// // 将 store 实例作为插件安装
// app.use(store)
