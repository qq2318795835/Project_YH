import Vue from 'vue'
import Router from 'vue-router'
import index from '@/components/module/index'
import job from '@/components/module/job'
import corp from '@/components/module/corp'
import information from '@/components/module/information'
import news from '@/components/module/news'
import resume from '@/components/module/resume'
import personal from '@/components/module/personal'

Vue.use(Router)

export default new Router({
  routes: [
    {path: '/',redirect:'/index'},
    {path: '/index',component: index},
    {path: '/job',component: job},
    {path: '/corp',component: corp},
    {path: '/information',component: information},
    {path: '/news',component: news},
    {path: '/resume',component: resume},
    {path: '/personal',component: personal},
  ]
})
