
import { createRouter, createWebHistory, createWebHashHistory } from 'vue-router'
import Main from '../views/Main.vue'
import Home from '../views/Home.vue'
import store from '@/store'


const routes = [
  {
    path: '/Main',
    name: 'Main',
    component: Main,
    redirect: Home,
    children: [
      {
        lable: '首页',
        path: 'Home',
        name: 'Home',
        component: Home,
      },
      // {
      //   index: '2',
      //   lable: '学生信息',
      //   path: 'Student',
      //   name: 'Student',
      //   component: () => import('../views/Student.vue'),
      // },
      // {
      //   index: '3',
      //   lable: '教师信息',
      //   path: 'Teacher',
      //   name: 'Teacher',
      //   component: () => import('../views/Teacher.vue'),
      // },
      // {
      //   index: '4',
      //   lable: '用户信息',
      //   path: 'User',
      //   name: 'User',
      //   component: () => import('../views/User.vue'),
      // },
      // {
      //   index: '5-1',
      //   lable: '页面1',
      //   path: 'PageOne',
      //   name: 'PageOne',
      //   component: () => import('../views/PageOne.vue'),
      // },
      // {
      //   index: '5-2',
      //   lable: '页面2',
      //   path: 'PageTwo',
      //   name: 'PageTwo',
      //   component: () => import('../views/PageTwo.vue'),
      // },
      {
        path: 'Error',
        name: 'Error',
        component: () => import('../views/Error.vue'),
      },
    ]
  },
  {
    path: '/Login',
    name: 'Login',
    component: () => import('../views/Login.vue'),
  },
  {
    path: '/',
    redirect: 'Login'
  },
  {
    path: '/Error',
    name: '404',
    component: () => import('../views/Error.vue'),
  },
  // {
  //   path: '/*',
  //   component: () => import('../views/Error.vue'),
  // },
]

const router = createRouter({
  // 4. 内部提供了 history 模式的实现。为了简单起见，我们在这里使用 hash 模式。
  history: createWebHashHistory(),
  routes, // `routes: routes` 的缩写
})


// 守卫路由
router.beforeEach((to, from, next) => {

  const token = store.state.userInfo.token;
  if (token === "" && to.name !== "Login") {
    //未登录不能访问其他页面
    ElMessage({
      showClose: true,
      message: '请先登录再访问其他页面',
      type: 'warning',
    })
    return next({ name: "Login" });

  }
  if (token !== "" && to.name === "Login") {
    // 已登录不能访问登录页面
    ElMessage({
      showClose: true,
      message: '请先退出再访问登录页面',
      type: 'warning',
    })
    return next({ name: "Main" });
  }

  // 注册路由
  store.commit('addRouters')

  console.log(from.name, "跳转->", to.name);
  // 刷新后 to.name 为空, 无法跳转页面, 做特殊处理
  if (!to.name) {
    // 获取路由name
    let toname = to.path.split('/').pop()
    //判断 这个name存不存在
    if (router.hasRoute(toname)) {
      // 存在, 重定向到这个页面, to.name 变为之前页面路由的 toname
      return next({ name: toname });
    } else {
      // 不存在, 定位到错误页面
      next({ name: "Error" });
    }
  }
  else {
    next();
  }



  // if (router.hasRoute(to.name)) {
  //   next();
  // } else {
  //   next({ name: "404" });
  // }



});



export default router