<template>
  <div id="app">
    <Header/>
    <router-view/>
    <Footer/>
  </div>
</template>

<script>
  import Header from "./components/Header";
  import Footer from "./components/Footer";
export default {
  name: 'App',
    components:{
        Footer,
        Header
    },
}
</script>

<style>
#app{
  background-color: #f6f6f8;
  margin-right: -8px;
  margin-left: -8px;
}
</style>
