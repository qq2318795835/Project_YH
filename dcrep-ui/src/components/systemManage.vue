<template>
  <div>
    <navigation />
    <router-view />
    <div class="body">

    </div>
  </div>
</template>

<script>
    import navigation from "./system/navigation";
    import breadcrumb from "./system/breadcrumb";
    export default {
        name: "systemManage",
        components: {navigation,breadcrumb},
    }
</script>

<style>

</style>

<style scoped>
  .body{
    margin-left: 214px;
    margin-right: -8px;
    margin-top: -181px;
  }

</style>
