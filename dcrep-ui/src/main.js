// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import qs from "qs"
import axios from 'axios'
import store from './store'
import * as echarts from 'echarts';
import App from './App'
import router from './router'

Vue.config.productionTip = false
Vue.use(ElementUI);
Vue.prototype.$qs = qs
Vue.prototype.$axios = axios
Vue.prototype.$echarts = echarts

//开发环境
// axios.defaults.baseURL = 'http://localhost:8079';
//运行环境
axios.defaults.baseURL = 'http://81.70.152.49:8079';

axios.defaults.headers.put['Content-Type'] = 'application/json; charset=utf-8';

/*请求拦截器*/
axios.interceptors.request.use(
  config => {
      config.headers.Authorization = sessionStorage.getItem('Authorization');
      // console.log(config);
    return config;
  },
  err => {
    return Promise.reject(err);
  });

/* 响应拦截器 */

axios.interceptors.response.use(
  function (response) {
  return response
},
  function (error) {
    if(error.response.status===401) {
      alert("登录信息已过期，请重新登录")
      router.replace({
        path: '/login' // 到登录页重新获取token
      })
      location.reload()
      sessionStorage.clear();
    }
  return Promise.reject(error);
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  // store,
  components: { App },
  template: '<App/>'
})


