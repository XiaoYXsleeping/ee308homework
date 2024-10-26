<script >

export default {
  beforeMount: function () {
    this.loadGet();
   // this.loadPost();

  },
  data: function () {

    return {
      tableData: [],
      centerDialogVisible: false,
      form:{
        id:'',
        no:'s',
        name:'',
        password:'111',
        age:'18',
        phone:'',
        sex:'',
        roleId:'1',

      },



    }
  },
  methods: {
    resetForm(){
      this.$refs.form.resetFields();
      console.log("zhiqna"+this.form.id);
      this.form.id=''

      this.form.name =''
      this.form.password = ''
      this.form.phone = ''
      this.form.sex = ''
      this.form.roleId = ''
      this.form.age=''


      console.log("zhihou "+this.form.id);





    },
    mod: function (row) {

      console.log(row);

      this.centerDialogVisible = true

      this.$nextTick(()=>{
        this.form.id = row.id
        this.form.name = row.name
        this.form.password = row.password
        this.form.phone = row.phone
        this.form.sex = row.sex+''
        this.form.roleId = row.roleId
        this.form.age=row.age+''




      })




    },
    del(id){
      console.log(id)
      this.$axios.get('http://localhost:8090/delete?id='+id,this.form).then(res=>res.data).then(res=>{
        console.log(res)
        this.$message({
          message:'删除成功',
          type:'success'
        })
        this.centerDialogVisible=false
        this.loadGet();


      })



    },
    add(){
      this.centerDialogVisible=true;

      this.$nextTick(()=>{
        this.resetForm();
      })


    },
    doMod(){
      this.$axios.post('http://localhost:8090/saveOrMod',this.form).then(res=>res.data).then(res=>{
        console.log(res)
        this.$message({
          message:'修改成功',
          type:'success'
        })
        this.centerDialogVisible=false
        this.loadGet();


      })
    },


    dosave(){
      this.$axios.post('http://localhost:8090/save',this.form).then(res=>res.data).then(res=>{
        console.log(res)
        this.$message({
          message:'新增成功',
          type:'success'
        })
        this.centerDialogVisible=false
        this.loadGet();


      })


    },

    save(){

      if(this.form.id){

        console.log("xiuga"+this.form.id)
        this.doMod();

      }else {
        console.log("add")
        this.dosave();
      }




    },



    loadGet() {
      this.$axios.get('http://localhost:8090/list').then(res => res.data).then(res => {
        console.log(res)
        this.tableData=res;

      })
    },


  },
  name: "Main"

}

</script>

<template>
  <div>
  <div style="margin-bottom: 5px">

    <el-button type="primary" style="margin-left: 5px;" @click="add">新增</el-button>


  </div>
  <el-table :data="tableData"
  :header-cell-style="{  background:'#f2f5fc',color:'#555555'}"
            border
  >
    <el-table-column prop="id" label="ID" width="120">
    </el-table-column>
    <el-table-column prop="name" label="姓名" width="120">
    </el-table-column>
    <el-table-column prop="sex" label="性别" width="80">
      <template v-slot:default="scope" >
        <el-tag
          :type="scope.row.sex ===1 ? 'primary' : 'success'"
          disable-transitions>{{scope.row.sex === 1? '男' : '女'}}</el-tag>
      </template>
    </el-table-column>
    <el-table-column prop="phone" label="联系电话" width="180">
    </el-table-column>
    <el-table-column prop="operate" label="操作">


      <template v-slot:default="scope">
        <el-button size="small" type="success" @click="mod(scope.row)">编辑</el-button>
          <el-button slot="reference" size="small" type="danger" @click="del(scope.row.id)" >删除</el-button>


      </template>

    </el-table-column>
  </el-table>


    <el-dialog
           title="输入信息"
           :visible.sync="centerDialogVisible"
            width="30%"
            center>


      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="名字" prop="name">
          <el-col :span="25">
          <el-input v-model="form.name"></el-input>
          </el-col>
        </el-form-item>


        <el-form-item label="性别" prop="sex">
          <el-radio-group v-model="form.sex">
            <el-radio label="1">男</el-radio>
            <el-radio label="0">女</el-radio>
          </el-radio-group>
        </el-form-item>

        <el-form-item label="联系电话" prop="phone">
          <el-col :span="25">
            <el-input v-model="form.phone"></el-input>
          </el-col>
        </el-form-item>
      </el-form>


    <span slot="footer" class="dialog-footer">
    <el-button @click="centerDialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="save">确定</el-button>


  </span>

    </el-dialog>














  </div>
</template>

<style scoped>

</style>
