<template>
    <Mytable v-if="dataOK" :tableData=data></Mytable>
</template>

<script>
import Mytable from '../components/Mytable.vue'
import ComAPI from '@/utils/ComAPI';
export default {
    name: 'Teacher',
    data() {
        return {
            data: {},
            dataOK: false
        }
    },
    components: {
        Mytable
    },
    computed: {
        requested() {
            return this.$store.state.requested
        }
    },
    mounted() {
        console.log("请求teacher配置");
        let data = { type: "教师" }
        ComAPI.get('/tableConfig/get', data).then(res => {
            if (res.code == 200) {
                this.data = res
                this.data.config = JSON.parse(this.data.config)
                this.dataOK = true
            }
        })
    },

}
</script>
