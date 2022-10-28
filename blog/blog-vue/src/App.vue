
<template>
  <TopNavBarVue></TopNavBarVue>

  <div class="main" @mousemove="onMousemove" :style="{ backgroundColor: `hsl(${x % 360}, 30%, 90%, 0.3)` }">

    <!-- <router-view v-slot="{ Component }">
      <Transition name="fade">
        <component :is="Component" />
      </Transition>
    </router-view> -->
    <router-view></router-view>
  </div>

  <FooterVue></FooterVue>
  <backToTopVue />

  <!-- -------------------------  登录控制模块   ------------------------- -->

</template>

<script setup>
import { ref, reactive, onMounted, provide } from 'vue';
import backToTopVue from './components/backToTop.vue';
import { lock, unlock } from 'tua-body-scroll-lock'
import FooterVue from './components/layout/Footer.vue';
import TopNavBarVue from './components/layout/TopNavBar.vue';

// ------------------------->>>>>  公共部分控制模块   <<<<<-------------------------
// 控制背景颜色变化
const x = ref(0)
function onMousemove(event) {
  x.value = event.clientX
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
}
onMounted(() => {
  // 请求初始数据
  authorInit()
})

</script>

<style lang="less" scoped>
@colortransition: 0.1s background-color ease-in-out;
@transition: 0.3s all ease-in-out;


.main {
  position: relative;
  z-index: 0;
  flex: 1 0 auto;
  transition: @colortransition;
}
</style>
