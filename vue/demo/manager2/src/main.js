import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
// import ElementPlus from "element-plus";
import "element-plus/dist/index.css";
import * as ElementPlusIconsVue from "@element-plus/icons-vue";
import store from "./store";
import "./utils/mock.js";
import zhCn from 'element-plus/es/locale/lang/zh-cn'

const app = createApp(App).use(router).use(store);

// 注册icon
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
  app.component(key, component);
}


// //在页面加载时读取sessionStorage里的状态信息
// if (sessionStorage.getItem("store")) {
//   store.replaceState(Object.assign({}, store.state, JSON.parse(sessionStorage.getItem("store"))));
//   sessionStorage.removeItem('store');
//   // router.push({ name: store.state.currentTag.path })
// }
// //在页面刷新时将vuex里的信息保存到sessionStorage里
// window.addEventListener("beforeunload", () => {
//   sessionStorage.setItem("store", JSON.stringify(store.state))
// })

app.mount("#app");
