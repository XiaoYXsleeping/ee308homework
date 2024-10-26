<script>
export default {
  name: "Header",
  methods:{
    toUser(){
      console.log('to_user')
    },
    logout(){
      console.log('logout')
    },
    collapse(){
      this.$emit("doCollapse")
    }
  }
}
</script>

<template>
  <div style="display: flex; line-height: 60px">

    <div style="margin-top: 8px;">
      <i class="el-icon-s-fold" style="font-size: 20px;"@click="collapse"></i>
    </div>
    <div style="flex: 1; text-align: center; font-size: 34px">
      <span>欢迎来到通讯录</span>
    </div>
    <el-dropdown>
      <span>欢迎</span><i class="el-icon-arrow-down" style="margin-left: 10px;"></i>
      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item @click.native="toUser">个人中心</el-dropdown-item>
        <el-dropdown-item @click.native="logout">退出登录</el-dropdown-item>

      </el-dropdown-menu>
    </el-dropdown>

  </div>
</template>

<style scoped>

</style>
