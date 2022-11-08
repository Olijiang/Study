<template>
    <header @mousemove="onMousemove" :class="headerStyle">

        <div class="author">
            <!-- {{ authorInfo.name }} -->
            神华里绫
        </div>
        <div class="nav">
            <template v-if="isLogin">
                <div v-for="(item, index) in navItems" :key="index" class="nav_item" @click="routerHandler(item.name)">
                    <span>{{ item.label }}</span>
                    <div class="item_line"></div>
                </div>
                <div class="nav_item" @click="routerHandler('Personal')">
                    个人中心
                    <div class="item_line"></div>
                </div>
                <div class="nav_item" @click="logoutHandler">
                    退出登录
                    <div class="item_line"></div>
                </div>
            </template>

            <div v-else class="nav_item" @click="loginHandler">
                <span>登录</span>
                <div class="item_line"></div>
            </div>
        </div>
    </header>
</template>

<script>

export default {
    components: {

    },
    props: {},
    data() {
        return {
            x: 100,
            navItems: [
                {
                    label: "首页",
                    name: "Home"
                },
                {
                    label: "相册",
                    name: "Album"
                },
                {
                    label: "文章列表",
                    name: "ArticleList"
                },
            ],
            headerStyle: "header-on",
        }
    },
    methods: {
        logoutHandler() {
            ElMessageBox.confirm('是否确认退出?', '提示框',
                {
                    distinguishCancelAndClose: true,
                    confirmButtonText: '是',
                    cancelButtonText: '否',
                    type: 'warning',
                    customStyle: { top: "-20% !important", position: "relative" },
                }).then(() => {
                    this.$store.commit("logout")
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
        },
        loginHandler() {
            //模态框动态显示需要先if条件为真, 初始为隐藏状态, 再改变class显现
            this.$store.state.loginFlag = true
        },
        routerHandler(value) {
            this.$router.push({
                name: value
            })
        },
        onMousemove(event) {
            this.x = event.clientX
        }
    },
    computed: {
        isLogin() {
            return this.$store.state.isLogin;
        }
    },
    watch: {

    },
    mounted() {
        let oldy = 0;
        window.addEventListener('mousewheel', () => {
            let y = document.documentElement.scrollTop || document.body.scrollTop
            if (y - oldy > 0) { // 向下滚动
                this.headerStyle = "header-off"
            } else {
                this.headerStyle = "header-on"
            }
            oldy = y;
        });
    },
}

</script>

<style lang='less' scoped>
// ------------------------->>>>>  heaer css   <<<<<-------------------------
@borderColor: #989898;
@colortransition: 0.1s background-color ease-in-out;
@transition: 0.3s all ease-in-out;

.header-on {
    position: fixed;
    display: flex;
    justify-content: space-between;
    font-weight: bold;
    font-size: 18px;
    z-index: 3;
    width: 100vw; //包括滚动条的宽度在内
    height: 50px;
    line-height: 50px;
    box-shadow: 0px 0px 5px @borderColor;
    transition: @colortransition, @transition;
    color: #ffab37
}


.header-off {
    .header-on;
    opacity: 0.2;
    transform: translate(0, -50px);
}

.author {
    margin-left: 20px;
    color: #0088ff;
}

.nav {
    z-index: 3;
    margin-right: 20px;
}

.nav_item {
    position: relative;
    display: inline-block;
    line-height: 20px;
    margin: 0 8px;
    cursor: pointer;
    transition: 0.3s all ease-in-out;

    .item_line {
        position: absolute;
        width: 0;
        margin-top: 10px;
        height: 5px;
        border-radius: 2px;
        background-color: rgb(2, 159, 207);
        transition: 0.3s all ease-in-out;
    }

    &:hover {
        color: rgb(2, 159, 207);
        transition: 0.3s all ease-in-out;

        .item_line {
            translate: 0;
            width: 100%;
        }
    }
}
</style>