import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import router from "./router";
import store from './store';
// import '@/utils/mock'
import '@/assets/css/hight.css'
import '@/assets/css/markdown.css'

const defaultAccount = "2020"

createApp(App)
    .use(router)
    .use(store)
    .mount('#app')

