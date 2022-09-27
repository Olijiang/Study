
import {createRouter, createWebHistory, createWebHashHistory} from 'vue-router'
import Main from '../views/Main.vue'
import Home from '../views/Home.vue'

const routes = [
    {
        path:'/Main',
        name:'Main',
        component: Main,
        redirect:Home,
        children:[
        {
            index:'1',
            lable:'首页',
            path:'Home',
            name:'Home',
            component: () => import('../views/Home.vue'),
        },
        {
            index:'2',
            lable:'学生信息',
            path:'Student',
            name:'Student',
            component: () => import('../views/Student.vue'),
        },
        {
            index:'3',
            lable:'教师信息',
            path:'Teacher',
            name:'Teacher',
            component: () => import('../views/Teacher.vue'),
        },
        {
            index:'4',
            lable:'用户信息',
            path:'User',
            name:'User',
            component: () => import('../views/User.vue'),
        },
        {
            index:'5-1',
            lable:'页面1',
            path:'PageOne',
            name:'PageOne',
            component: () => import('../views/PageOne.vue'),
        },
        {
            index:'5-2',
            lable:'页面2',
            path:'PageTwo',
            name:'PageTwo',
            component: () => import('../views/PageTwo.vue'),
        },
        ]
    },
    {
        path:'/Login',
        name:'Login',
        component: () => import('../views/Login.vue'),
    },
    {
        path:'/',
        redirect:'Login'
    }


    
]

const router = createRouter({
    // 4. 内部提供了 history 模式的实现。为了简单起见，我们在这里使用 hash 模式。
    history: createWebHashHistory(),
    routes, // `routes: routes` 的缩写
  })

export default router