<script>

export default {
  name: "Aside",
  data: function () {
    return {
      //isCollapse:false
    }
  },
  props:{
    isCollapse:Boolean

  }
}
</script>

<template>
  <el-menu
    background-color="#8A2CBF"
    text-color="#fff"
    active-text-color="#ffd04b"
    style="height: 100vh"
    default-active="/Home"
    :collapse="isCollapse"
    :collapse-transition="true"


  >
    <el-menu-item index="/Home">
      <i class="el-icon-s-home"></i>
      <span>首页</span>
    </el-menu-item>

    <el-menu-item index="/One">
      <i class="el-icon-s-flag"></i>
      <span>导航一</span>
    </el-menu-item>

    <el-menu-item index="/Two">
      <i class="el-icon-s-opportunity"></i>
      <span>导航二</span>
    </el-menu-item>
  </el-menu>

</template>

<style scoped>

</style>



