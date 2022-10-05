<template>
  <el-config-provider :locale="locale">
    <router-view v-slot="{ Component }">
      <Transition name="fade">

        <component :is="Component" />

      </Transition>
    </router-view>
  </el-config-provider>

</template>

<script>
import { ElConfigProvider } from 'element-plus'
import zhCn from 'element-plus/lib/locale/lang/zh-cn'


export default {
  name: 'App',
  data() {
    return {
      locale: zhCn,
    }
  },
  components: {
    ElConfigProvider,
  }
  ,
  created() {
    // 这行代码的意思是定义一个全局变量，等于该组件的实例
    window.myvue = this



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
  mounted() {

  },

}



</script>

<style scoped>
/* 过度动画 */
.fade-enter-active {
  transition: all 0.2s ease-in;
}

.fade-leave-active {
  transition: all 0.1s;
}

.fade-enter-from {
  transform: translateX(-20px);
  opacity: 0;
}

.fade-leave-to {
  transform: translateX(10px);
  opacity: 0;
}
</style>
