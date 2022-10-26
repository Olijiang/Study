
<template>
  <header @mousemove="onMousemove(1, $event)" :style="{ backgroundColor: `hsl(${x%360}, 30%, 90%, 0.6)` }"
    :class="headerStyle">
    <div style="float: left;margin-left: 20px;cursor: pointer;">
      昵称
    </div>
    <div class="nav">
      <div v-for="(item, index) in navItems" :key="index" class="nav-item">
        <span>{{ item }}</span>
        <div class="item-line"></div>
      </div>
      <div v-if="isLogin" class="nav-item1">
        个人中心
        <div class="item-line"></div>
      </div>
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
  <div
    style="position: fixed;width: 100%;height: 100%;left: 0;top:0; z-index: 5;backgroundColor: hsl(100, 30%, 90%, 0.5)"
    v-show="isLoginVisible">
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
import { ref, reactive, onMounted } from 'vue';
import HomeVue from './views/Home.vue';
import backToTopVue from './components/backToTop.vue';
import type { FormInstance, FormRules } from 'element-plus'
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
// 处理登录逻辑
const isLoginVisible = ref(false)
function loginHandler() {
  //模态框动态显示需要先if条件为真, 初始为隐藏状态, 再改变class显现
  isLoginVisible.value = true   //打开模态框
  lock(null)  //锁住滚轮
  setTimeout(() => {

  }, 100);
}
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


const submitForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return
  formEl.validate((valid, fields) => {
    if (valid) {
      console.log('submit!')
      isLoginVisible.value = false   //关闭模态框
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
  opacity: 0.2;
  transform: translate(0, -50px);
  position: fixed;
  z-index: 3;
  width: 100%;
  height: 50px;
  line-height: 50px;
  box-shadow: 0px 0px 5px @borderColor;
  transition: @colortransition, @transition;
}

header {
  font-family: "Fantasy", "seSans-serifrif";
  font-weight: bold;
}

.nav {
  z-index: 3;
  float: right;
  margin-right: 20px;
}

.nav-item {
  display: inline-block;
  line-height: 20px;
  margin: 0 10px;
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

  .nav-item1 {
    display: inline-block;
    line-height: 20px;
    margin: 0 10px;
    width: 80px;
    cursor: pointer;
    transition: 0.3s all ease-in-out;

    .item-line {
      position: absolute;
      width: 0;
      margin-top: 10px;
      height: 5px;
      translate: 40px; // 移到居中
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
        translate: 5px;
        width: 70px;
        height: 5px;
        border-radius: 2px;
        background-color: rgb(2, 159, 207);
        transition: 0.3s all ease-in-out;
      }
    }
  }
}

// ------------------------->>>>>  login css   <<<<<-------------------------
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
