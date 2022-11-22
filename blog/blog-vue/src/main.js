import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import router from "./router";
import store from './store';
import '@/assets/css/hight.css'
import '@/assets/css/markdown.css'

createApp(App)
    .use(router)
    .use(store)
    .mount('#app')

