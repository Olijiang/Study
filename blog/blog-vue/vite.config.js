import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import { resolve } from 'path'
import AutoImport from 'unplugin-auto-import/vite'
import Components from 'unplugin-vue-components/vite'
import { ElementPlusResolver } from 'unplugin-vue-components/resolvers'
import { compression } from 'vite-plugin-compression2'
// import { Plugin as importToCDN } from "vite-plugin-cdn-import"

// https://vitejs.dev/config/
export default defineConfig({
  base: './',
  server: {
    proxy: {
      "/api": {
        target: "http://localhost:8888",
        changeOrigin: true,
        rewrite: (path) => path.replace(/^\/api/, ""),
      }
    },
  },
  plugins: [
    compression({
      verbose: true,
      disable: false,
      threshold: 1024,//100kB
      algorithm: 'gzip',
      ext: '.gz',
    }),
    vue(),
    AutoImport({
      resolvers: [ElementPlusResolver()],
    }),
    Components({
      resolvers: [ElementPlusResolver()],
    }),
    // importToCDN({
    //   modules: [
    //     {
    //       name: 'vue',
    //       var: 'Vue',
    //       path: 'https://cdnjs.cloudflare.com/ajax/libs/vue/3.2.31/vue.global.prod.min.js'
    //     },
    //     {
    //       name: 'vuex',
    //       var: 'Vuex',
    //       path: 'https://cdnjs.cloudflare.com/ajax/libs/vuex/4.0.2/vuex.global.prod.min.js'
    //     },
    //     {
    //       name: 'vue-router',
    //       var: 'VueRouter',
    //       path: 'https://cdnjs.cloudflare.com/ajax/libs/vue-router/4.0.12/vue-router.global.prod.min.js'
    //     },
    //     {
    //       name: 'element-plus',
    //       var: 'ElementPlus',
    //       path: 'https://unpkg.com/element-plus@1.2.0-beta.6/dist/index.full.js'
    //     }
    //   ]
    // })
  ],

  resolve: {
    alias: {
      "@": resolve(__dirname, 'src'), // 路径别名
    },
    extensions: ['.js', '.json', '.ts', 'vue'] // 使用路径别名时想要省略的后缀名，可以自己 增减
  },

})
