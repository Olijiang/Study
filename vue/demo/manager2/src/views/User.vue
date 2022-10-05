<template>
    <Mytable v-if="dataOK" :tableData=data></Mytable>
</template>

<script>
import Mytable from '../components/Mytable.vue'
import ComAPI from '@/utils/ComAPI';
export default {
    name: 'User',
    data() {
        return {
            data: {},
            dataOK: false,
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
    watch: {

    },
    mounted() {
        console.log("请求user配置");
        let data = { type: "用户" }
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
