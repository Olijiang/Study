<template>
    <el-dialog v-model="loginFlag" width="400px" top="20vh" modal style=" border-radius: 20px;">
        <template class=" card-header" #header>
            <h3>登&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;录</h3>
        </template>
        <div class="card-body">
            <el-form ref="loginRef" :model="loginForm" status-icon :rules="rules" label-width="80px"
                class="demo-ruleForm">
                <el-form-item label="用户名" prop="username">
                    <el-input v-model="loginForm.username" type="text" autocomplete="off" placeholder="请输入账户" />
                </el-form-item>
                <el-form-item label="密&#160;&#160;码" prop="password">
                    <el-input v-model="loginForm.password" type="password" autocomplete="off" placeholder="请输入密码" />
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="submitForm">登录</el-button>
                    <el-button @click="resetForm">清空</el-button>
                </el-form-item>
            </el-form>
        </div>


    </el-dialog>
</template>

<script>

import API from '../utils/API'


export default {

    components: {

    },
    props: {},
    data() {
        function validateUserName(rule, value, callback) {
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
        function validatePassword(rule, value, callback) {
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
        submitForm() {
            this.$refs['loginRef'].validate((valid) => {
                if (valid) {

                    API.post('/login', this.loginForm)
                        .then(res => {
                            if (res.code === 200) {
                                // 同步vuex
                                this.$store.commit("login", res.author)
                                this.$store.state.loginFlag = false
                            }
                        })
                }
            })
        },
        resetForm() {
            this.$refs['loginRef'].resetFields()
        }
    },
    computed: {
        loginFlag: {
            set(value) {
                this.$store.state.loginFlag = value;
            },
            get() {
                return this.$store.state.loginFlag;
            }
        }
    },
    watch: {

    },
    mounted() {

    },
}

</script>

<style lang='less' scoped>
el-dialog {
    border-radius: 20px !important;
}

.card-body {
    width: 300px;
    margin: auto;
    z-index: 20;
    padding-right: 5%
}

.card-header {
    font-size: 20px;
    font-family: "宋体";
    align-items: center;
}
</style>