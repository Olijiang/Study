import { createRouter, createWebHistory, createWebHashHistory } from 'vue-router'
import Home from '../views/Home.vue'
import store from '../store'
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
                path: 'Article',
                name: 'Article',
                component: () => import('../views/Article.vue'),
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
    history: createWebHashHistory(),

    routes, // `routes: routes` 的缩写
    scrollBehavior(to, from, savedPosition) {
        // return 期望滚动到哪个的位置 { x: number, y: number } |  { selector: string } |
        return { top: 0 }
    }
})

// 守卫路由
router.beforeEach((to, from, next) => {
    // 处理token过期问题
    if (store.state.isLogin == true)
        if (store.state.author == undefined) {
            ElMessage({
                showClose: true,
                message: "身份验证已失效, 请重新登录",
                type: 'warning',
            })
            next({ name: "Home" })
            store.commit("logout")
        }

    // let rou = ["Home", "/", "ArticleDetail"]
    // if (!store.state.isLogin) {
    //     //未登录状态
    //     console.log("未登录");
    //     console.log(to.name);
    //     console.log(rou.includes(to.name));
    //     if (!rou.includes(to.name)) {
    //         ElMessage({
    //             showClose: true,
    //             message: "请先登录！",
    //             type: 'warning',
    //         })
    //         next({ name: "Home" })
    //     } else {
    //         next()
    //     }

    // } else {
    //     next()
    // }
    next()
});


export default router