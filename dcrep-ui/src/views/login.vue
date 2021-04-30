<template>
  <div id="login">
    <div class="login-body">
      <el-card class="box-card">
        <div class="title">
          <h3>Dcrep管理系统</h3>
        </div>
        <el-form :model="loginForm" :rules="loginRules" ref="loginForm">
          <el-form-item label="账号" class="label" prop="uloginName">
            <el-input class="input1" type="text" v-model="loginForm.uloginName"></el-input>
          </el-form-item>
          <el-form-item label="密码" class="label" prop="password">
            <el-input class="input2" type="password" v-model="loginForm.password" @keyup.enter.native="submitForm"></el-input>
          </el-form-item>
          <el-form-item class="login-btn">
            <el-button type="primary" @click="submitForm" style="margin-left: 10px">登陆</el-button>
            <el-button type="primary" @click="resetForm('loginForm')" style="margin-left: 30px">重置</el-button>
          </el-form-item>
        </el-form>
      </el-card>
    </div>
  </div>
</template>

<script>
    export default {
        name: 'login',
        data(){
            var validateUname = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('用户名不能为空'));
                }
            };
            var validatePass = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('密码不能为空'));
                }
            };
            return{
                user:null,
                status:0,
                token:'',
                loginForm:{
                    uloginName:'',
                    password:''
                },
                loginRules:{
                    uloginName:[{ validator: validateUname, trigger: 'blur' }],
                    password:[{ validator: validatePass, trigger: 'blur' }]
                },
                fromPath:this.$route.query.currentPath
            }
        },
        methods:{
            submitForm() {
                let _this = this;
                let loginUser = {
                    uloginName : _this.loginForm.uloginName,
                    upass : _this.loginForm.password
                }
                this.$axios({
                    method: "post",
                    url: '/User/doLogin',
                    data: _this.$qs.stringify(loginUser)
                }).then((response) => {
                    this.user = response.data.data
                    this.status = response.data.code
                    this.token = response.data.token
                    let _user = JSON.stringify(this.user)
                    let _token = this.token
                    if(_this.status === 1){
                        sessionStorage.setItem('loginedUser',_user)
                        sessionStorage.setItem('Authorization',_token)
                        // _this.$store.commit('login',_this.loginForm)
                         let path = this.$route.query.redirect
                        alert('登陆成功')
                        _this.$router.replace({path: path === '/' || path === undefined ? '/index' : path})
                        // _this.$router.push('/index') //_this.$router.replace('/index') 这句是不能回退，登出功能完全做完可考虑替换
                    }else {
                        return this.$message.error('密码错误，请重新登录！')
                    }
                }).catch(function (error){
                    console.log(error)
                });
            },
            // regisForm() {
            //     let _this = this;
            //     let da = {
            //         uname : _this.loginForm.uname,
            //         upass : _this.loginForm.password
            //     }
            //     this.$axios({
            //         method: "post",
            //         url: 'http://192.168.144.44:8079/User/doRegister',
            //         data: _this.$qs.stringify(da)
            //     }).then((response) => {
            //         alert('注册成功，请登录')
            //     }).catch(function (error){
            //         console.log(error)
            //     });
            // },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },
        },
    }
</script>

<style>
  #login {
    background: url("../assets/img/system/bj_login.jpeg");
    width: 100%;
    height: 100%;
    position: fixed;
    background-size: 100% 100%;
    margin-top: -8px;
    margin-left: -8px;
  }
  .label .el-form-item__label{
    color: #F5F8E7; /*注意则是全局样式,全局的label*/
  }
</style>
<style scoped>
  .login-body{
    margin:12% auto;
    width: 400px;
    text-align: center;
  }
  .box-card{
    border-radius:10px;
    background-color:transparent;
    color: #fdfcfa;
  }
  .title{
    margin-top: -20px;
    font-size: 18px;
    color: #F5F8E7;
  }

  .input1{
    width: 300px;
  }
  .input2{
    width: 300px;
  }
  .login-btn{
    margin-top: 25px;
    margin-bottom: 8px;
  }
  .el-button{
    width: 100px;
    margin-top: 10px;
  }
  .el-button--primary,
  .el-button--primary:focus,
  .el-button--primary.is-active,
  .el-button--primary:active{
    background: #B1C434;
    border-color: #B1C434;
  }
  .el-button--primary:hover {
    background: #DBE568;
    border-color: #DBE568;
    color: #FFF;
  }

</style>
