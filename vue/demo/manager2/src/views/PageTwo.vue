
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
      pageSize: 15,
      side: [
        {
          "label": "Main",
          "name": "Main",
          "path": "Main",
          "children": [
            {
              "label": "学生信息",
              "name": "Student",
              "path": "Student",
              "children": null
            },
            {
              "label": "教师信息",
              "name": "Teacher",
              "path": "Teacher",
              "children": null
            },
            {
              "label": "更多功能",
              "name": "More",
              "path": "More",
              "children": null
            }
          ]
        },
        {
          "label": "更多功能",
          "name": "More",
          "path": "More",
          "children": [
            {
              "label": "功能一",
              "name": "PageOne",
              "path": "PageOne",
              "children": null
            },
            {
              "label": "功能二",
              "name": "PageTwo",
              "path": "PageTwo",
              "children": null
            }
          ]
        }
      ]
    }
  },
  methods: {

  }
}
</script>
  
