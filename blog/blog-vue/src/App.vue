
<template>
  <header @mousemove="onMousemove(1, $event)" :style="{ backgroundColor: `hsl(${x%360}, 30%, 90%, 0.6)` }"
    :class="headerStyle">
    <div style="float: left;margin-left: 20px;color:aliceblue">
      {{ authorInfo.name }}
    </div>
    <div class="nav">
      <template v-if="isLogin">
        <div v-for="(item, index) in navItems" :key="index" class="nav-item">
          <span>{{ item }}</span>
          <div class="item-line"></div>
        </div>
        <div class="nav-item1">
          个人中心
          <div class="item-line"></div>
        </div>
        <div class="nav-item1" @click="logoutHandler">
          退出登录
          <div class="item-line"></div>
        </div>
      </template>

      <div v-else class="nav-item" @click="loginHandler">
        <span>登录</span>
        <div class="item-line"></div>
      </div>
    </div>
  </header>

  <div class="main" @mousemove="onMousemove(2, $event)" :style="{ backgroundColor: `hsl(${y % 360}, 30%, 90%, 0.3)` }">
    <HomeVue></HomeVue>

  </div>

  <footer @mousemove="onMousemove(3, $event)" :style="{ backgroundColor: `hsl(${z % 360}, 30%, 90%, 1)` }">
    @copyright
  </footer>

  <backToTopVue />

  <!-- -------------------------  登录控制模块   ------------------------- -->
  <div :class="LoginBoxStyle">
    <div class="login-card">
      <div class="card-header">
        <h3>登&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;录</h3>
      </div>
      <div class="card-body">
        <el-form ref="loginRef" :model="loginForm" status-icon :rules="rules" label-width="80px" class="demo-ruleForm">
          <el-form-item label="用户名" prop="username">
            <el-input v-model="loginForm.username" type="text" autocomplete="off" placeholder="请输入账户" />
          </el-form-item>
          <el-form-item label="密&#160;&#160;&#160;&#160;码" prop="password">
            <el-input v-model="loginForm.password" type="password" autocomplete="off" placeholder="请输入密码" />
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitForm(loginRef)">登录</el-button>
            <el-button @click="resetForm(loginRef)">清空</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script lang="ts" setup>
import { ref, reactive, onMounted, provide } from 'vue';
import HomeVue from './views/Home.vue';
import backToTopVue from './components/backToTop.vue';
import { FormInstance, FormRules, ElMessage, ElMessageBox } from 'element-plus'
import { lock, unlock } from 'tua-body-scroll-lock'


// ------------------------->>>>>  公共部分控制模块   <<<<<-------------------------
// 控制背景颜色变化
const x = ref(0)
const y = ref(0)
const z = ref(0)
function onMousemove(index: Number, event: any) {
  switch (index) {
    case 1:
      x.value = event.clientX
      break;
    case 2:
      y.value = event.clientX
      break;
    case 3:
      z.value = event.clientX
      break;
    default:
      break;
  }
}
// ------------------------->>>>>  heaer 部分控制模块   <<<<<-------------------------
// 判断鼠标的上下滑动  1 up    0 down
// 控制header的收起的展开
const headerStyle = ref("header-on")
let oldy = 0;
onMounted(() => {
  window.addEventListener('mousewheel', () => {
    let y = document.documentElement.scrollTop || document.body.scrollTop
    if (y - oldy > 0) { // 向下滚动
      headerStyle.value = "header-off"
    } else {
      headerStyle.value = "header-on"
    }
    oldy = y;
  });
})
// 菜单
const navItems = ref()
navItems.value = ["首页", "分类", "文章"]
// 是否登录
const isLogin = ref(false)
// ------------>>>>  处理登录逻辑
const LoginBoxStyle = ref("loginBoxOff")
function loginHandler() {
  //模态框动态显示需要先if条件为真, 初始为隐藏状态, 再改变class显现
  LoginBoxStyle.value = "loginBoxOn"
  lock(null)  //锁住滚轮
}
// ------------>>>>  处理登出逻辑
function logoutHandler() {
  ElMessageBox.confirm('是否确认退出?', '提示框', {
    distinguishCancelAndClose: true,
    confirmButtonText: '是',
    cancelButtonText: '否',
    type: 'warning',
  }).then(() => {
    isLogin.value = false
    authorInit()
    ElMessage({
      type: 'success',
      message: '退出成功',
    })
  }).catch((action) => {
    if (action == 'cancel') {
      // 点击关闭 关闭弹窗回到主页面

    } else {
      // 按ESC 啥也不干
    }
  })
}
// ------------------------->>>>>  登录数据初始化   <<<<<-------------------------
const authorInfo = reactive({
  name: String,
  desc: String,
  articleN: Number,
  categoryN: Number,
  tagN: Number,
  imgUrl: String
})
type articleInfo = {
  index: Number,
  title: String,
  createTime: String,
  category: String, // 分类
  tag: String,  // 标签
  digest: String, //摘要
  url: String, //正文地址
  imgUrl: String, //插图地址
}
const articleList = reactive([] as articleInfo[])
function authorInit() {
  let author = {
    name: "神华里绫",
    desc: "这是我的blog",
    articleN: 99,
    categoryN: 99,
    tagN: 99,
    imgUrl: "src/img/1.png"
  }
  Object.keys(authorInfo).forEach(key => { authorInfo[key] = author[key] })

  let articles = [
    { index: 1, title: "段落标题段落标题段落标题段落标题段落标题", createTime: "2012-01-23", category: "Vue", tag: "vuex", digest: "段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要", url: "xxx", imgUrl: "src/img/1.png" },
    { index: 2, title: "段落标题", createTime: "2014-02-21", category: "Java", tag: "多线程", digest: "段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要段落摘要", url: "xxx", imgUrl: "src/img/2.png" },
    { index: 3, title: "段落标题", createTime: "2015-01-27", category: "Vue", tag: "router", digest: "段落摘要段落摘要", url: "xxx", imgUrl: "src/img/3.png" },
    { index: 4, title: "段落标题", createTime: "2016-02-15", category: "Redis", tag: "redis", digest: "段落摘要段落摘要", url: "xxx", imgUrl: "src/img/1.png" },
    { index: 5, title: "段落标题", createTime: "2017-11-23", category: "Python", tag: "CNN", digest: "段落摘要段落摘要", url: "xxx", imgUrl: "src/img/2.png" },
    { index: 6, title: "段落标题", createTime: "2018-05-29", category: "Vue", tag: "mock", digest: "段落摘要段落摘要", url: "xxx", imgUrl: "src/img/3.png" },
    { index: 7, title: "段落标题", createTime: "2019-08-01", category: "Java", tag: "springboot", digest: "段落摘要段落摘要", url: "xxx", imgUrl: "src/img/1.png" },
    { index: 8, title: "段落标题", createTime: "2021-04-29", category: "Vue", tag: "vuex", digest: "段落摘要段落摘要", url: "xxx", imgUrl: "src/img/2.png" }
  ]
  articles.forEach((e) => { articleList.push(e) })
}
onMounted(() => {
  // 请求初始数据
  authorInit()
})
// ---------------->>>> 数据透传
provide('authorInfo', authorInfo)
provide('articleList', articleList)

// ------------------------->>>>>  登录部分控制模块   <<<<<-------------------------
const validateUserName = (rule: any, value: any, callback: any) => {
  if (value === '') {
    callback('请输入用户名')
  } else {
    let idReg = /^\d{5,10}$/
    if (idReg.test(value)) {
      callback()
    } else {
      callback('请输入正确的用户名')
    }
  }
}
const validatePassword = (rule: any, value: any, callback: any) => {
  if (value === '') {
    callback('请输入密码')
  } else {
    callback()
  }
}
const loginRef = ref<FormInstance>()
const loginForm = reactive({
  username: '4050000',
  password: '123'
})
const rules = reactive<FormRules>({
  username: { validator: validateUserName, required: true, trigger: 'blur' },
  password: { validator: validatePassword, required: true, trigger: 'blur' }
})
// 登录后返回登录用户新数据
const submitForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return
  formEl.validate((valid, fields) => {
    if (valid) {
      let author = {
        name: "高西维尔",
        desc: "这是我的blog",
        articleN: 999,
        categoryN: 999,
        tagN: 999,
        imgUrl: "src/img/2.png"
      }
      Object.keys(authorInfo).forEach(key => { authorInfo[key] = author[key] })
      // console.log(authorInfo)
      LoginBoxStyle.value = "loginBoxOff"   //关闭模态框
      isLogin.value = true
      unlock(null)  //解锁滚轮
    }
  })
}
const resetForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return
  formEl.resetFields()
}
</script>

<style lang="less" scoped>
@borderColor: #989898;
@colortransition: 0.1s background-color ease-in-out;
@transition: 0.3s all ease-in-out;

// ------------------------->>>>>  heaer css   <<<<<-------------------------
.header-on {
  position: fixed;
  z-index: 3;
  width: 100%;
  height: 50px;
  line-height: 50px;
  box-shadow: 0px 0px 5px @borderColor;
  transition: @colortransition, @transition;
}

.header-off {
  .header-on;
  opacity: 0.2;
  transform: translate(0, -50px);
}

header {
  font-weight: bold;
  font-size: 18px;
}

.nav {
  z-index: 3;
  float: right;
  margin-right: 20px;
}

.nav-item {
  display: inline-block;
  line-height: 20px;
  margin: 0 5px;
  width: 40px;
  cursor: pointer;
  transition: 0.3s all ease-in-out;

  .item-line {
    position: absolute;
    width: 0;
    margin-top: 10px;
    height: 5px;
    translate: 25px; // 移到居中
    border-radius: 2px;
    background-color: rgb(2, 159, 207);
    transition: 0.3s all ease-in-out;
    transform: scale(0.1);
  }

  &:hover {
    color: rgb(2, 159, 207);
    transition: 0.3s all ease-in-out;

    .item-line {
      position: absolute;
      transform: scale(1);
      translate: 0;
      width: 40px;
      height: 5px;
      border-radius: 2px;
      background-color: rgb(2, 159, 207);
      transition: 0.3s all ease-in-out;
    }
  }
}

.nav-item1 {
  .nav-item;
  width: 75px;

  .item-line {
    translate: 40px; // 移到居中
  }

  &:hover {
    .item-line {
      width: 65px;
      translate: 5px; // 移到居中
    }


  }
}


// ------------------------->>>>>  login css   <<<<<-------------------------
.loginBoxOn {
  position: fixed;
  width: 100%;
  height: 100%;
  left: 0;
  top: 0;
  z-index: 5;
  background-color: rgba(250, 250, 250, 0.5);
  transition: all 0.2s ease-in-out;
  font-family: Arial, Helvetica, sans-serif;

  .login-card {
    border: 2px solid #f0eded;
    border-radius: 20px;
    background-color: #ffffff;
    width: 350px;
    height: 260px;
    margin: auto;
    margin-top: 25vh;
    position: fixed;
    left: 40%;
    z-index: 20;
  }

  .card-body {
    padding-right: 20px
  }

  .card-header {
    font-size: 20px;
    display: flex;
    justify-content: center;
    align-items: center;
  }
}

.loginBoxOff {
  .loginBoxOn;

  opacity: 0;
  z-index: -1;
}



.main {
  position: relative;
  z-index: 0;
  flex: 1 0 auto;
  transition: @colortransition;
}

footer {
  z-index: 1;
  height: 80px;
  line-height: 80px;
  box-shadow: 0px 0px 1px @borderColor;
  transition: @colortransition;
}
</style>
