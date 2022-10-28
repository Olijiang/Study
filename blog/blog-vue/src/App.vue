
<template>
  <TopNavBarVue></TopNavBarVue>

  <div class="main" @mousemove="onMousemove" :style="{ backgroundColor: `hsl(${x % 360}, 30%, 90%, 0.3)` }">
    <router-view></router-view>
  </div>

  <FooterVue></FooterVue>
  <backToTopVue />
  <vLoginVue></vLoginVue>
  <!-- -------------------------  登录控制模块   ------------------------- -->

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
      x: 100
    }
  },
  methods: {
    onMousemove(event) {
      this.x = event.clientX
    }
  },
  mounted() {
    let author = {
      name: "神华里绫",
      desc: "这是我的blog",
      articleN: 99,
      categoryN: 99,
      tagN: 99,
      imgUrl: "src/img/1.png"
    }
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
@colortransition: 0.1s background-color ease-in-out;
@transition: 0.3s all ease-in-out;


.main {
  position: relative;
  z-index: 0;
  flex: 1 0 auto;
  transition: @colortransition;
}
</style>
