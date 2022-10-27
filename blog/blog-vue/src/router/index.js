import { createRouter, createWebHistory, createWebHashHistory } from 'vue-router'

const routes = [
    {
        path: '/',
        name: '/',
        children: [
            {
                path: 'Home',
                name: 'Home',
                component: () => import('../views/Home.vue'),
            },
            {
                path: 'Article',
                name: 'Article',
                component: () => import('../views/Article.vue'),
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
    history: createWebHashHistory(),
    routes, // `routes: routes` 的缩写
})

// 守卫路由
router.beforeEach((to, from, next) => {
    next()
});

export default router