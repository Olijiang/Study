<template>
    <Mytable :tableData=data></Mytable>
</template>

<script>
import ComAPI from '../api/ComAPI'
import Mytable from '../components/Mytable.vue'
export default {
    name: 'Teacher',
    data() {
        return {
            data: {}
        }
    },
    components: {
        Mytable
    },
    mounted() {
        ComAPI.get('/getTeachers')
            .then(res => {
                this.data = res
                // console.log(res.data);
            }).catch(err => {
                console.log(err);
            })
    }
}
</script>
