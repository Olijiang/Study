import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import router from "./router";
import store from './store';
import '@/utils/mock'
import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'


createApp(App)
    .use(router)
    .use(store)
    .use(mavonEditor)
    .mount('#app')

