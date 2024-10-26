
<template>
  <el-container style="height: 100%; border: 1px solid #eee">
    <el-aside :width="aside_width" style="background-color: rgb(238, 241, 246);height: 100%">
      <Aside :isCollapse="isCollapse"></Aside>
    </el-aside>

    <el-container style="height: 100%">
      <el-header style="text-align: right; font-size: 12px;height: 100%;border-bottom: #0b0c0c 1px solid;">
        <Header @doCollapse="doCollapse"></Header>
      </el-header>

      <el-main style="height: 100%">
        <Main></Main>
      </el-main>
    </el-container>
  </el-container>
</template>


<script>
import Aside from "./Aside.vue";
import Header from "./Header.vue";
import Main from "./Main.vue";

export default {
  name: "Index",
  components: {Main, Header, Aside},
  data: function () {
    return {
      isCollapse:false,
      aside_width:'200px'
    }


  },
  methods:{
    doCollapse() {


     this.isCollapse = !this.isCollapse
      if (!this.isCollapse){
       this.aside_width='200px'
    }else{
        this.aside_width='64px'
    }

  }

}
}

</script>


<style scoped>
.el-header {
  background-color: #0cd3f3;
  color: #333;
  line-height: 60px;
}
.el-main{
  padding: 5px;
}
.el-aside {
  color: #333;
}
</style>
