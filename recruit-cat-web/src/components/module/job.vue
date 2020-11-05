<template>
  <div>
    <Search/>
    <job-card/>
  </div>
</template>

<script>
import Search from "./index_components/Search";
import jobCard from "./job_components/jobCard";

  export default {
      name:"job",
      components:{Search,jobCard},
  }

</script>

<style scoped>

</style>
