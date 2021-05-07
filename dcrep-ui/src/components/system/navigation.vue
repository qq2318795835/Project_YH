<template>
<div class="main">
  <div class="header" >
    <div class="title">
     <span class="title-content">Dcrep管理系统</span>
    </div>
    <div class="logo">
      <img src="../../assets/img/system/logo.jpg" width="40px" height="40px">
    </div>
    <div class="time-body">
      {{dateFormat(date)}}
    </div>
    <div class="personalIntro" v-if="loginedUser">
      <div class="IntroPor">
        <img class="IntroPor-body" v-bind:src="loginedUser.uimgpath">
      </div>
      <div class="uremark" >
        <el-dropdown>
        <span class="el-dropdown-link" style="color: #fff;font-size: 16px">
          {{loginedUser.uname}}
          <i class="el-icon-arrow-down el-icon--right"></i>
        </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>个人中心</el-dropdown-item>
            <el-dropdown-item @click.native="loginout(1)">退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
    </div>
  </div>
  <div class="left-menu" v-if="loginedUser">
    <div class="PersonalInfo">
      <div class="HeadPortrait">
        <img class="HeadPortrait-body" :src="loginedUser.uimgpath">
      </div>
      <div class="uLogName">
        <span>你好！{{loginedUser.uloginname}},欢迎登陆</span>
      </div>
      <el-divider class="hr"></el-divider>
    </div>
    <div class="left-menu-body">
      <el-scrollbar>
        <el-menu
          style="height: 100%"
          :default-active="this.$route.path"
          class="el-menu-vertical-demo"
          @open="handleOpen"
          @close="handleClose"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b">
          <router-link style="text-decoration: none;" to="/index">
            <el-menu-item index="/index">
              <i class="el-icon-s-home"></i>
              <span slot="title">后台首页</span>
            </el-menu-item>
          </router-link>
          <el-submenu index="2">
            <template slot="title">
              <i class="el-icon-setting"></i>
              <span>系统管理</span>
            </template>
            <el-menu-item-group>
              <router-link to="/departmentManage" style="text-decoration: none">
                <el-menu-item index="/departmentManage">
                  <i class="el-icon-menu"></i>
                  部门管理
                </el-menu-item>
              </router-link>
              <router-link to="/rightManage" style="text-decoration: none">
                <el-menu-item index="/rightManage">
                  <i class="el-icon-key"></i>
                  权限管理
                </el-menu-item>
              </router-link>
              <router-link to="/ruleManage" style="text-decoration: none">
                <el-menu-item index="/ruleManage">
                  <i class="el-icon-user"></i>
                  角色管理
                </el-menu-item>
              </router-link>
              <router-link to="/userManage" style="text-decoration: none">
                <el-menu-item index="/userManage">
                  <i class="el-icon-user-solid"></i>
                  用户管理
                </el-menu-item>
              </router-link>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="3">
            <template slot="title">
              <i class="el-icon-star-off"></i>
              <span>基础管理</span>
            </template>
            <el-menu-item-group>
              <router-link to="/customerManage" style="text-decoration: none">
                <el-menu-item index="/customerManage">
                  <i class="el-icon-s-custom"></i>
                  客户管理
                </el-menu-item>
              </router-link>
              <router-link to="/supplierManage" style="text-decoration: none">
                <el-menu-item index="/supplierManage">
                  <i class="el-icon-truck"></i>
                  供应商管理
                </el-menu-item>
              </router-link>
              <router-link to="/goodsManage" style="text-decoration: none">
                <el-menu-item index="/goodsManage">
                  <i class="el-icon-goods"></i>
                  商品管理
                </el-menu-item>
              </router-link>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="4">
            <template slot="title">
              <i class="el-icon-box"></i>
              <span>货物管理</span>
            </template>
            <el-menu-item-group>
              <router-link to="/purchaseManage" style="text-decoration: none">
                <el-menu-item index="/purchaseManage">
                  <i class="el-icon-s-fold"></i>
                  进货管理
                </el-menu-item>
              </router-link>
              <router-link to="/returnManage" style="text-decoration: none">
                <el-menu-item index="/returnManage">
                  <i class="el-icon-s-unfold"></i>
                  退货管理
                </el-menu-item>
              </router-link>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="5">
            <template slot="title">
              <i class="el-icon-coffee-cup"></i>
              <span>销售管理</span>
            </template>
            <el-menu-item-group>
              <router-link to="/commoditySaleManage" style="text-decoration: none">
                <el-menu-item index="/commoditySaleManage">
                  <i class="el-icon-shopping-cart-full"></i>
                  商品销售
                </el-menu-item>
              </router-link>
              <router-link to="/saleReturn" style="text-decoration: none">
                <el-menu-item index="/saleReturn">
                  <i class="el-icon-shopping-cart-1"></i>
                  销售退货
                </el-menu-item>
              </router-link>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="6">
            <template slot="title">
              <i class="el-icon-more-outline"></i>
              <span>其他管理</span>
            </template>
            <el-menu-item-group>
              <router-link to="/myTask" style="text-decoration: none">
                <el-menu-item index="/myTask">
                  <i class="el-icon-alarm-clock"></i>
                  我的待办任务
                </el-menu-item>
              </router-link>
              <router-link to="/processManage" style="text-decoration: none">
                <el-menu-item index="/processManage">
                  <i class="el-icon-coffee"></i>
                  流程管理
                </el-menu-item>
              </router-link>
            </el-menu-item-group>
          </el-submenu>
        </el-menu>
      </el-scrollbar>
    </div>
  </div>
</div>
</template>

<script>
    export default {
        name: "navigation",
        data() {
            return {
                loginedUser: null,
                out: 0,
                token: '',
                CurrentTime: '',
                date:new Date(),
            }
        },
        methods: {
            handleOpen(key, keyPath) {
                // console.log(key, keyPath);
            },
            handleClose(key, keyPath) {
                // console.log(key, keyPath);
            },

            //这里存到sessionStorage的loginedUser必须存的是解析成json格式的对象，否则赋值赋不到loginedUser,解析后下面在转化成对象
            //目前存在不关页面token存在，且访问index可以正常，但后台显示token已过期，待解决
            getloginedUser() {
                // let _this = this
                var loginedUser = sessionStorage.getItem('loginedUser')
                loginedUser = JSON.parse(loginedUser)
                this.loginedUser = loginedUser
            },
            loginout(parm) {
                let _this = this;
                let outF = {
                    out: parm,
                    token: sessionStorage.getItem('Authorization'),
                }
                this.$axios({
                    method: "post",
                    url: '/User/outLogin',
                    data: _this.$qs.stringify(outF)
                }).then((response) => {
                }).catch(function (error) {
                    console.log(error)
                });
                sessionStorage.clear()
                this.$router.push('/login')
                location.reload()
            },
            //格式化当前时间
            dateFormat(time) {
                var date=new Date(time);
                var year=date.getFullYear();
                /* 在日期格式中，月份是从0开始的，因此要加0
                 * 使用三元表达式在小于10的前面加0，以达到格式统一  如 09:11:05
                 * */
                var month= date.getMonth()+1<10 ? "0"+(date.getMonth()+1) : date.getMonth()+1;
                var day=date.getDate()<10 ? "0"+date.getDate() : date.getDate();
                var hours=date.getHours()<10 ? "0"+date.getHours() : date.getHours();
                var minutes=date.getMinutes()<10 ? "0"+date.getMinutes() : date.getMinutes();
                var seconds=date.getSeconds()<10 ? "0"+date.getSeconds() : date.getSeconds();
                // 拼接
                return year+"-"+month+"-"+day+""+"-"+""+hours+":"+minutes+":"+seconds;
            }
        },
        mounted() {
            let _this = this; // 声明一个变量指向Vue实例this，保证作用域一致
            this.timer = setInterval(() => {
                _this.date = new Date(); // 修改数据date
            }, 1000)

            this.getloginedUser()
        },
        beforeDestroy() {
            if (this.timer) {
                clearInterval(this.timer); // 在Vue实例销毁前，清除我们的定时器
            }
        }
    }
</script>

<style>

</style>
<style scoped>
  >>>.el-card__body {
    padding: 0px;
  }
  .el-scrollbar{
    height: 495px;
  }
  >>>.el-scrollbar__thumb{
    background-color: #7e848a;
  }
  >>>.el-scrollbar__wrap {
    overflow-x: hidden;
  }
.main {
 margin: -8px -8px -8px -8px;
}
.header{
  height: 50px;
  background-color: rgb(57, 65, 69);
  color: #fff;
}
.title{
  width: 220px;
  text-align: center;
  line-height: 50px;
  font-size: 18px;
}
.title-content{
  line-height: 40px;
}
.logo{
  width: 40px;
  height: 40px;
  margin-left: 222px;
  margin-top: -45px;
}
.time-body{
  color: #fff;
  width: 200px;
  margin: -32px auto ;
  font-size: 18px;
  text-align: center;
}
.IntroPor{
  width: 30px;
  height: 30px;
  margin-top: 10px;
  float: left;
}
.IntroPor-body{
  border-radius: 50%;
  width: 30px;
  height: 30px;
}
.uremark{
  height: 30px;
  width: 120px;
  margin-top: 10px;
  margin-left: 35px;
  text-align: center;
  line-height: 28px;
}
.personalIntro{

  width: 160px;
  height: 48px;
  float: right;
  margin-right: 30px;
  margin-top: -5px;
}
.left-menu{
  width: 221px;
}
.PersonalInfo{
  width: 222px;
  height: 180px;
  border-top: 1px solid #545c64;
  background-color: #545c64;
}
.HeadPortrait{
  margin-left: 65px;
  margin-top: 20px;
  width: 90px;
  height: 90px;

}
.HeadPortrait-body{
  width: 90px;
  height: 90px;
  border-radius: 50%;
}
.uLogName{
  text-align: center;
  margin-top: 20px;
  color: #fff;
}
.hr{
  width: 180px;
  margin-left: 20px;
  background-color: #ffd04b;
}
.left-menu-body{
  /*position: fixed;*/
  position: absolute;
  /*height: 100%;*/
  height: 499px;
  background-color: #545c64;
}
.el-menu-vertical-demo{
  width: 222px;
}
</style>
