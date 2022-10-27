<template>
    <div :class="LoginBoxStyle">
        <div class="login-card">
            <div class="card-header">
                <h3>登&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;录</h3>
            </div>
            <div class="card-body">
                <el-form ref="loginRef" :model="loginForm" status-icon :rules="rules" label-width="80px"
                    class="demo-ruleForm">
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

<script>

export default {
    name: name,
    components: {

    },
    props: {},
    data() {
        validateUserName = (rule, value, callback) => {
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
        validatePassword = (rule, value, callback) => {
            if (value === '') {
                callback('请输入密码')
            } else {
                callback()
            }
        }
        return {
            rules: {
                username: { validator: validateUserName, required: true, trigger: 'blur' },
                password: { validator: validatePassword, required: true, trigger: 'blur' }
            },
            loginForm: {
                username: '4050000',
                password: '123'
            }
        }
    },
    methods: {
        submitForm(formEl) {
            if (!formEl) return
            formEl.validate((valid, fields) => {
                if (valid) {
                    let author = {
                        name: "高西维尔",
                        desc: "这是我的blog",
                        articleN: 999,
                        categoryN: 999,
                        tagN: 999,
                        imgUrl: "src/img/2.png"
                    }
                    // 同步vuex
                    isLogin.value = true
                    unlock(null)  //解锁滚轮
                }
            })
        },
        resetForm(formEl) {
            if (!formEl) return
            formEl.resetFields()
        }
    },
    computed: {

    },
    watch: {

    },
    mounted() {

    },
}

</script>

<style lang='less' scoped>
.loginBoxOn {
    position: fixed;
    width: 100%;
    height: 100%;
    left: 0;
    top: 0;
    z-index: 5;
    background-color: rgba(250, 250, 250, 0.5);
    transition: all 0.2s ease-in-out;
    font-family: Arial, Helvetica, sans-serif;

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
}

.loginBoxOff {
    .loginBoxOn;

    opacity: 0;
    z-index: -1;
}
</style>