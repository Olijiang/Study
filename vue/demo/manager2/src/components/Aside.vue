<template>
    <el-menu :default-active=activeName class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose"
        :collapse="isCollapse" style="text-align:left; border: none;" background-color='#F5F7FA' mode="vertical">

        <template v-for="(item,index) in sideData">
            <el-menu-item v-if="!item.children" :key="index" @click=selectMenu(item) :index="item.name">
                <el-icon>
                    <component :is=item.icon></component>
                </el-icon>
                <template #title>{{item.label}}</template>
            </el-menu-item>
            <el-sub-menu v-else :key="index+1" :index="item.name">
                <template #title>
                    <el-icon>
                        <component :is=item.icon></component>
                    </el-icon>
                    <span>{{item.label}}</span>
                </template>
                <el-menu-item-group>
                    <el-menu-item v-for="subItem in item.children" :key="index" :index="subItem.name"
                        @click=selectMenu(subItem)>{{subItem.label}}</el-menu-item>
                </el-menu-item-group>
            </el-sub-menu>
        </template>

    </el-menu>
</template>

<style>
aside .el-menu-vertical-demo:not(.el-menu--collapse) {
    width: 180px;
    min-height: 400px;
}

aside .el-menu {
    height: 100%;
    /* color: #e9fdff; */
}

aside .el-menu-item,
.el-sub-menu__title {
    height: 50px !important;
}

aside .el-menu-item-group__title {
    display: none;
}
</style>

<script>


export default {
    name: 'Aside',
    props: {
        sideData: Array
    },
    data() {
        return {
        }
    },
    methods: {
        handleOpen() {
            // console.log(this.$store);
            // console.log(this.isCollapse);
        },
        handleClose(key, keyPath) {
            // console.log(key, keyPath);
        },
        selectMenu(item) {
            // 路由跳转
            this.$router.push({
                name: item.name
            })
            // console.log(item.itemName, item.index)
            // menu 点击事件逻辑, vuex 中存放一个激活tag， 
            // 1 切换激活 tag, 根据需要 addTag
            this.$store.commit('changeTag', item)
            this.$store.commit('addTag')
        },
    },
    computed: {
        activeName() {
            // console.log(this.$store.state.currentTag)
            return this.$store.state.currentTag.name
        },
        isCollapse() {
            return this.$store.state.isCollapse
        },
    },
    watch: {
        // activeIndex: function () {
        //     this.$router.push({
        //         name: this.$store.state.currentTag.path
        //     })
        // }
    }
}
</script>