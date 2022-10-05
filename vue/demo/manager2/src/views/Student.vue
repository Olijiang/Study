<template>

    <Mytable v-if="dataOK" :tableData=data></Mytable>

</template>

<script>
import Mytable from '../components/Mytable.vue'
import ComAPI from '@/utils/ComAPI';
export default {
    name: 'Student',
    data() {
        return {
            data: {
                config: {}
            },
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
    mounted() {
        console.log("请求student配置");
        let data = { type: "学生" }
        ComAPI.get('/tableConfig/get', data).then(res => {
            if (res.code == 200) {
                this.data = res
                this.data.config = JSON.parse(this.data.config)
                this.dataOK = true
                // console.log(res);
            }
        })
    },
    // activated() {
    //     // requested在每次添加tag是变为true
    //     if (this.requested) {
    //         console.log("请求student配置2");
    //         ComAPI.get('/studentMenu/get').then(res => {
    //             if (res.code == 200) {
    //                 this.data = res
    //                 this.data.config = JSON.parse(this.data.config)
    //                 this.dataOK = true
    //                 // console.log(res);
    //             }
    //         })
    //     }
    // }

}
</script>
