
<template>
  <el-pagination v-model:currentPage="currentPage" v-model:page-size="pageSize" :page-sizes="[15, 30, 50]" background
    small layout="sizes, prev, pager, next, jumper" :total="1000" @size-change="handleSizeChange"
    @current-change="handleCurrentChange" />
</template>
  

<script>


export default {
  data() {
    return {
      currentPage: 1,
      pageSize: 15
    }
  },
  methods: {

  }
}
</script>
  
