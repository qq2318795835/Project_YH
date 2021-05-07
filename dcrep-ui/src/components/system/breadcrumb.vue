<template>
  <el-card class="index-header">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item v-for="(item,index) in breadList"
                          :key="index"
                          >{{item.meta.title}}
      </el-breadcrumb-item>
    </el-breadcrumb>
  </el-card>
</template>

<script>
    export default {
        name: "breadcrumb",
        data() {
            return {
                breadList: [], // 路由集合
            };
        },
        watch: {
            $route() {
                this.getBreadcrumb();
            }
        },
        methods: {
            isHome(route) {
                return route.name === "index";
            },
            getBreadcrumb() {
                let matched = this.$route.matched;
                //如果不是首页
                if (!this.isHome(matched[0])) {
                    matched = [{ path: "/index", meta: { title: "首页" } }].concat(matched);
                }
                this.breadList = matched;
            }
        },
        created() {
            this.getBreadcrumb();
        },
    }
</script>

<style>

</style>
<style scoped>
  .el-breadcrumb{
    margin-top: 13px;
    margin-left: 15px;
  }
  .index-header{
    height: 40px;
    border-radius: 0px;
    border: none;
  }
</style>
