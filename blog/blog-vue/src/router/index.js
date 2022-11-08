import { createRouter, createWebHistory, createWebHashHistory } from 'vue-router'
import Home from '../views/Home.vue'
const routes = [
    {
        path: '/',
        name: '/',
        redirect: Home,
        children: [
            {
                path: 'Home',
                name: 'Home',
                component: () => import('../views/Home.vue'),
            },
            {
                path: 'ArticleList',
                name: 'ArticleList',
                component: () => import('../views/ArticleList.vue'),
            },
            {
                path: 'ArticleDetail/:articleId',
                name: 'ArticleDetail',
                component: () => import('../views/ArticleDetail.vue'),
            },
            {
                path: 'Album',
                name: 'Album',
                component: () => import('../views/Album.vue'),
            },
            {
                path: 'Personal',
                name: 'Personal',
                component: () => import('../views/Personal.vue'),
            },
        ]
    }

]



const router = createRouter({
    // 4. 内部提供了 history 模式的实现。为了简单起见，我们在这里使用 hash 模式。
    history: createWebHistory(),
    routes, // `routes: routes` 的缩写
    scrollBehavior(to, from, savedPosition) {
        // return 期望滚动到哪个的位置 { x: number, y: number } |  { selector: string } |
        return { top: 0 }
    }

})

// 守卫路由
router.beforeEach((to, from, next) => {
    next()
});


export default router