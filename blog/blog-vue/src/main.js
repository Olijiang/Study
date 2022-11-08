import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import router from "./router";
import store from './store';
import '@/utils/mock'
import '@/assets/css/styles/vs.css'

createApp(App)
    .use(router)
    .use(store)
    .mount('#app')

