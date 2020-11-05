<template>
  <div>
    <Search/>
    <Search-job-by-type/>
    <hot-job/>
    <hot-corp/>
  </div>
</template>

<script>
import Search from "./index_components/Search";
import SearchJobByType from "./index_components/SearchJobByType";
import hotJob from "./index_components/hotJob";
import hotCorp from "./index_components/hotCorp";
    export default {
        name: "index",
        components: {SearchJobByType, Search,hotJob,hotCorp},
    }
</script>

<style scoped>

</style>
