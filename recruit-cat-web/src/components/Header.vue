<template>
  <div class="header">
    <div class="menu1">
        <el-menu
          :default-active="activeIndex2"
          class="el-menu-demo"
          mode="horizontal"
          @select="handleSelect"
          background-color="#545c64"
          text-color="#dadbdc"
          active-text-color="#ffd04b">
          <router-link class="el-menu-item-link1" to="/index">
          <el-menu-item class="el-menu-item1" index="1">
            首页
          </el-menu-item>
          </router-link>
          <router-link class="el-menu-item-link1" to="/job">
            <el-menu-item index="2">
              职位
            </el-menu-item>
          </router-link>
          <el-submenu index="3">
            <template slot="title">校园</template>
            <el-menu-item index="3-1">选项</el-menu-item>
            <el-menu-item index="3-2">选项2</el-menu-item>
            <el-menu-item index="3-3">选项3</el-menu-item>
            <el-menu-item index="3-3">选项3</el-menu-item>
          </el-submenu>
          <router-link class="el-menu-item-link1" to="/corp">
            <el-menu-item index="4" >
                公司
            </el-menu-item>
          </router-link>
          <router-link class="el-menu-item-link1" to="/information">
            <el-menu-item index="5">
                资讯
            </el-menu-item>
          </router-link>
<!--          <el-menu-item index="6">-->
<!--            APP-->
<!--          </el-menu-item>-->
          <router-link class="el-menu-item-link1" to="/news">
            <el-menu-item class="el-menu-item2" index="7">
                消息
            </el-menu-item>
          </router-link>
          <router-link class="el-menu-item-link1" to="/resume">
            <el-menu-item index="8">
                简历
            </el-menu-item>
          </router-link>
          <router-link class="el-menu-item-link1" to="/personal">
            <el-menu-item index="9">
                我的
            </el-menu-item>
          </router-link>
          <el-button round size="small" class="header-button1">注册</el-button>
          <el-button round size="small" class="header-button2">登录</el-button>
        </el-menu>
      </div>
    </div>
</template>

<script>
    export default {
        name: "Header"
    }
</script>

<style scoped>
@import "../assets/css/Header.css";
</style>
