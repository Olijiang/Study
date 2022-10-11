<template>
    <div class="errPage-container">
        <el-button class="pan-back-btn" @click="back">
            返回
        </el-button>
        <el-row>
            <el-col :span="12">
                <h1 class="text-jumbo text-ginormous">
                    Oops!
                </h1>
                <h2>页面不见了...</h2>
            </el-col>
            <el-col :span="12">
                <img :src="errGif" width="313" height="428" alt="Girl has dropped her ice cream.">
            </el-col>
        </el-row>
    </div>
</template>
  
<script>
import errGif from '../images/401.gif'

export default {
    name: 'Error',
    data() {
        return {
            errGif: errGif + '?' + +new Date(),
            ewizardClap: 'https://wpimg.wallstcn.com/007ef517-bafd-4066-aae4-6883632d9646',
            dialogVisible: false
        }
    },
    methods: {
        back() {
            this.$router.replace({ path: this.$store.state.currentTag.path })
        }
    }
}
</script>
  
<style scoped>
.errPage-container {
    width: 800px;
    max-width: 100%;
    margin: 100px 250px;
    position: absolute;
}

.pan-back-btn {
    background: #008489;
    color: #fff;
    border: none !important;
    margin-right: 800px;
}

.text-jumbo {
    font-size: 60px;
    font-weight: 700;
    color: #484848;
}
</style>
  