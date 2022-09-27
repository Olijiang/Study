import { createApp} from "vue";
import App from "./App.vue";
import router from "./router";
// import ElementPlus from "element-plus";
import "element-plus/dist/index.css";
import * as ElementPlusIconsVue from "@element-plus/icons-vue";
import store from "./store";
import "./utils/mock.js";

const app = createApp(App).use(router).use(store);

// 注册icon
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
  app.component(key, component);
}

// 守卫路由
router.beforeEach((to, from, next) => {
  const token = store.state.token;
  console.log('token : ', token);
  console.log(token.type);
  if (token.type==='未登录' && to.name !== "Login") {
    next({ name: "Login" });
  } else if(token.type!=='未登录' && to.name === "Login"){
    next({name:'Main'});
  }else{
    next()
  }
});


app.mount("#app");
