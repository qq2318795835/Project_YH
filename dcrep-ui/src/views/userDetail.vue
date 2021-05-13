<template>
  <div>
    <!--注意这里的拦截问题没有解决，后端拦截器只放行dologin-->
    <navigation />
    <div class="body">
      <el-card class="card-body" style="border-radius: 0px;">
        <breadcrumb />
        <div class="main-body">
          <div class="user-form">
            <el-form :label-position="labelPosition" label-width="80px" :model="updateUserForm">
              <el-form-item class="form-item" label="登录名">
                <el-input v-model="updateUserForm.uloginname"></el-input>
              </el-form-item>
              <el-form-item class="form-item" label="真实姓名">
                <el-input v-model="updateUserForm.uname"></el-input>
              </el-form-item>
              <el-form-item class="form-item" label="家庭地址">
                <el-input v-model="updateUserForm.uaddress"></el-input>
              </el-form-item>
              <el-form-item class="form-item" label="性别">
                <el-input v-model="updateUserForm.type"></el-input>
              </el-form-item>
              <el-form-item class="form-item" label="备注">
                <el-input v-model="updateUserForm.usex"></el-input>
              </el-form-item>
              <el-form-item class="form-item" label="入职时间">
                <el-input v-model="updateUserForm.uhiredate"></el-input>
              </el-form-item>
            </el-form>
          </div>
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
    import navigation from "../components/system/navigation";
    import breadcrumb from "../components/system/breadcrumb";
    export default {
        name: "userDetail",
        components: {navigation,breadcrumb},

        data(){
            return {
                labelPosition: 'right',
                uid :null,
                user :null,
                updateUserForm: {
                    uname:'',
                    uloginname:'',
                    uaddress:'',
                    usex:'',
                    uremark:'',
                    uhiredate:'',
                    uimgpath:'',
                    usalt:'',
                }
            }
        },
        methods:{

        },
        mounted() {

        }
    }
</script>

<style scoped>
  >>>.el-card__body {
    padding: 0px;
  }
  .body{
    margin-left: 214px;
    margin-right: -8px;
    margin-top: -181px;
  }
  .card-body{
    border: none;
  }
  .main-body{

  }
  .user-form{

  }
  .form-item{
    margin-left: 400px;
    margin-top: 30px;
    width: 450px;
  }
</style>
