<template>
  <router-view></router-view>
</template>

<script>

export default {
  name: 'App',

  created() {
    // 这行代码的意思是定义一个全局变量，等于该组件的实例
    window.myvue = this

    //在页面加载时读取sessionStorage里的状态信息
    if (sessionStorage.getItem("store")) {
      this.$store.replaceState(Object.assign({}, this.$store.state, JSON.parse(sessionStorage.getItem("store"))));
      sessionStorage.removeItem('store');
    }

    //在页面刷新时将vuex里的信息保存到sessionStorage里
    window.addEventListener("beforeunload", () => {
      sessionStorage.setItem("store", JSON.stringify(this.$store.state))
    })
  }
}



</script>

<style>
body {
  padding: 0;
  margin: 0;
}
</style>
