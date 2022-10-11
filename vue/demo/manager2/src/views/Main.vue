<template>
    <el-container>
        <el-aside width="auto">
            <Transition name="slide-fade">
                <Aside v-if="AideDataOK" :sideData=AideData></Aside>
            </Transition>
        </el-aside>
        <Transition name="slide-fade">
            <el-container v-if="AideDataOK">
                <el-header>
                    <Header> </Header>
                </el-header>
                <el-main>
                    <router-view v-slot="{ Component }">
                        <Transition name="slide-fade">
                            <component :is="Component" />
                        </Transition>
                    </router-view>
                </el-main>
            </el-container>
        </Transition>
    </el-container>
</template>

<script>

import Aside from '../components/Aside.vue'
import Header from '../components/Header.vue'
import ComAPI from '@/utils/ComAPI'

export default {
    name: "Main",
    data() {
        return {
            AideData: [],
            AideDataOK: false,
            userInfo: []    // 个人信息的config
        };
    },
    components: {
        Aside,
        Header
    },
    methods: {

    },
    created() {
        ComAPI.get('/menu/get').then(res => {
            if (res.code == 200) {
                let parents = res.menuData.filter((c) => c.pid == 0),  //1
                    childrens = res.menuData.filter((c1) => c1.pid != 0);  //3
                function tree(parents, childrens) {
                    parents.forEach((v) => {
                        childrens.forEach((c, i) => {
                            if (v.id === c.pid) {
                                //对象拷贝
                                let _c = JSON.parse(JSON.stringify(childrens));
                                _c.splice(i, 1);
                                // childrens.splice(i, 1);
                                if (v.children) {
                                    v.children.push(c);
                                } else {
                                    v.children = [c];
                                }
                                tree([c], _c);
                            }
                        });
                    });
                }
                tree(parents, childrens);
                this.$store.commit("saveRouters", parents) //路由信息包含着menuData中
                this.AideData = parents
                // console.log(parents);
                this.AideDataOK = true
            }
        })
    },
    computed: {

    }
    ,
    watch: {
        AideData: {
            immediate: true,
            handler() {
                this.$store.commit('addRouters')
            }
        }
    }

}
</script>




<style>
/* 过度动画 */
.slide-fade-enter-active {
    transition: all 0.3s ease-in-out;
}

.slide-fade-leave-active {
    transition: all 0.3s;
}

.slide-fade-enter-from {
    transform: translateX(-10px);
    opacity: 0;
}

.slide-fade-leave-to {
    transform: translateX(10px);
    opacity: 0;
}

.el-header {
    background-color: #FAFAFA;
    text-align: center;
    line-height: 50px;
    height: 50px !important;
    padding: 0 !important;
    box-shadow: 0 1px 5px #b9bcbc;
}

.el-aside {
    text-align: center;
    line-height: 200px;
}

.el-main {
    color: #333;
    text-align: center;
    overflow: hidden;
}

.el-container {

    height: 100vh;
}

body>.el-container {
    margin-bottom: 40px;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
    line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
    line-height: 320px;
}
</style>
  
  