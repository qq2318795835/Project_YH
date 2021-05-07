<template>
  <div>
    <div class="body">
      <el-card class="card-body" style="border-radius: 0px;">
        <breadcrumb />
        流程管理
      </el-card>
    </div>
  </div>
</template>

<script>
    import breadcrumb from "../../components/system/breadcrumb";
    export default {
        name: "processManage",
        components: {breadcrumb,},
    }
</script>

<style>

</style>

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
</style>
