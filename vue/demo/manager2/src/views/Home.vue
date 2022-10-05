<template>
    <el-row>
        <el-col :span="8">
            <el-card class="box-card" shadow="hover">
                <template #header>
                    <div class="card-header">
                        <img src="../images/img.png" style="width:200px;height:200px; border-radius:50%;" alt="头像" />
                        <div class="user-info">
                            <p style="font-size:20px"> {{username}} </p>
                            <p style="font-size:15px"> {{usertype}} </p>
                        </div>
                    </div>
                </template>
                <div class="card-body">
                    <div class="login-info">上次登录时间: <span style="margin-left:50px"> 2020-09-08 </span></div>
                    <div class="login-info">上次登录地点: <span style="margin-left:50px"> 猎户座银河系 </span></div>
                </div>
            </el-card>
        </el-col>
    </el-row>
</template>

<script>

export default {
    name: 'Home',
    data() {
        return {
        }
    },
    created() {
        this.$store.commit("addTag")
    },
    computed: {
        username() {
            return this.$store.state.userInfo.userName
        },
        usertype() {
            return this.$store.state.userInfo.userType
        }
    }
}
</script>

<style scoped>
.el-card {
    border-radius: 20px !important;
}

.user-info {
    margin-left: 80px;
    text-align: left;
}

.card-header {
    display: flex;
    justify-content: flex-start;
    align-items: center;
}

.login-info {
    font-size: 14px;
    padding-bottom: 10px;
    padding-left: 80px;
    text-align: left;
}

.box-card {
    position: absolute;
    width: 480px;
}
</style>