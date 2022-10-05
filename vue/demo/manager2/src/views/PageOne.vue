<template>
  <el-button text @click="dialog = true">Open Drawer with nested form</el-button>
  <el-drawer ref="drawerRef" v-model="dialog" title="I have a nested form inside!" :before-close="handleClose"
    direction="rtl" custom-class="demo-drawer">
    <div class="demo-drawer__content">
      <el-form :model="form">
        <el-form-item label="Name" :label-width="formLabelWidth">
          <el-input v-model="form.name" autocomplete="off" />
        </el-form-item>
        <el-form-item label="Area" :label-width="formLabelWidth">
          <el-select v-model="form.region" placeholder="Please select activity area">
            <el-option label="Area1" value="shanghai" />
            <el-option label="Area2" value="beijing" />
          </el-select>
        </el-form-item>
      </el-form>
      <div class="demo-drawer__footer">
        <el-button @click="cancelForm">Cancel</el-button>
        <el-button type="primary" :loading="loading" @click="onClick">{{
        loading ? 'Submitting ...' : 'Submit'
        }}</el-button>
      </div>
    </div>
  </el-drawer>
  <el-dropdown trigger="click">
    <span class="el-dropdown-link">
      Dropdown List<el-icon class="el-icon--right">
        <arrow-down />
      </el-icon>
    </span>
    <template #dropdown>
      <el-dropdown-menu>
        <el-dropdown-item :icon="Plus">Action 1</el-dropdown-item>
        <el-dropdown-item :icon="CirclePlusFilled">
          Action 2
        </el-dropdown-item>
        <el-dropdown-item :icon="CirclePlus">Action 3</el-dropdown-item>
        <el-dropdown-item :icon="Check">Action 4</el-dropdown-item>
        <el-dropdown-item :icon="CircleCheck">Action 5</el-dropdown-item>
      </el-dropdown-menu>
    </template>
  </el-dropdown>
</template>

<script>

import { ElDrawer, ElMessageBox } from 'element-plus'
export default {
  name: 'pageTwo',
  data() {
    return {
      formLabelWidth: 80,
      form: {},
      loading: false,
      dialog: false,
      name: '',
      region: '',
      date1: '',
      date2: '',
      delivery: false,
      type: [],
      resource: '',
      desc: '',
    }
  },
  methods: {
    onClick() {
      this.loading = true
      // 动画关闭需要一定的时间
      setTimeout(() => {
        this.loading = false
        this.dialog = false
      }, 400)

    },

    handleClose(done) {
      if (this.loading) {
        return
      }
      ElMessageBox.confirm('Do you want to submit?')
        .then(() => {
          this.loading = true
          // 动画关闭需要一定的时间
          setTimeout(() => {
            this.dialog = false
            this.loading = false
          }, 400)
        })
        .catch(() => {
          // catch error
        })

    },
    cancelForm() {
      this.loading = false
      this.dialog = false
    }
  }
}
</script>

<style>

</style>