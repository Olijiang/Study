
<template>
  <TopNavBarVue></TopNavBarVue>
  <!--  @mousemove="onMousemove" :style="{ backgroundColor: `hsl(${x % 360}, 30%, 90%, 0.3)` }" -->
  <div class="main" v-cloak @click="changeColor" :style="{ backgroundColor: `hsla(${x+y}, 30%, 85%, 0.4)` }">
    <router-view v-slot="{ Component, route }">
      <transition name="slide-fade">
        <component :is="Component" :key="route.path + Math.random()" />
      </transition>
    </router-view>



  </div>

  <FooterVue></FooterVue>
  <backToTopVue />
  <vLoginVue></vLoginVue>

</template>

<script>

import backToTopVue from './components/backToTop.vue';
import FooterVue from './components/layout/Footer.vue';
import TopNavBarVue from './components/layout/TopNavBar.vue';
import vLoginVue from './components/v-login.vue';

export default {
  components: {
    backToTopVue,
    FooterVue,
    TopNavBarVue,
    vLoginVue
  },
  data() {
    return {
      x: 100,
      y: 100
    }
  },
  methods: {
    changeColor(event) {
      this.x = event.clientX + Math.random() * 100
      this.y = event.clientY + Math.random() * 100
    }
  },
  mounted() {

  },
  created() {
    // 这行代码的意思是定义一个全局变量，等于该组件的实例
    window.mv = this

    //在页面加载时读取sessionStorage里的状态信息
    if (sessionStorage.getItem("store")) {
      this.$store.replaceState(Object.assign({}, this.$store.state, JSON.parse(sessionStorage.getItem("store"))));
      sessionStorage.removeItem('store');
      // this.$router.push({ name: this.$store.state.currentTag.path })
    }

    //在页面刷新时将vuex里的信息保存到sessionStorage里
    window.addEventListener("beforeunload", () => {
      sessionStorage.setItem("store", JSON.stringify(this.$store.state))
    })
  },
}

</script>

<style lang="less" scoped>
.main {
  min-height: 800px;
  position: relative;
  z-index: 0;
  flex: 1 0 auto;
  transition: 0.5s background-color ease-in-out;
}
</style>
