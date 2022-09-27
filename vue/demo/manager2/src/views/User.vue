<template>
    <Mytable :tableData=data></Mytable>
</template>

<script>
import ComAPI from '@/api/ComAPI'
import Mytable from '../components/Mytable.vue'
export default {
    name: 'User',
    data() {
        return {
            data: {}
        }
    },
    components: {
        Mytable
    },
    mounted() {
        ComAPI.get('/getUser')
            .then(res => {
                this.data = res
                // console.log(res);
            }).catch(err => {
                console.log(err);
            })
    }
}
</script>
