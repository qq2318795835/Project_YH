import Vue from 'vue'
import Router from 'vue-router'
import login from '../views/login';
import index from '../views/index';
import userDetail from "../views/userDetail";
import notFound from "../components/system/notFound";
import systemManage from "../components/systemManage";
import basicManage from "../components/basicManage"
import purchaseManageM from "../components/purchaseManageM"
import saleManage from "../components/saleManage"
import otherManage from "../components/otherManage"
import navigation from "../components/system/navigation";
import breadcrumb from "../components/system/breadcrumb";
import departmentManage from "../views/systemManage/departmentManage";
import rightManage from "../views/systemManage/rightManage";
import ruleManage from "../views/systemManage/ruleManage";
import userManage from "../views/systemManage/userManage";
import customerManage from "../views/basicManage/customerManage";
import supplierManage from "../views/basicManage/supplierManage";
import goodsManage from "../views/basicManage/goodsManage";
import purchaseManage from "../views/purchaseManage/purchaseManage";
import returnManage from "../views/purchaseManage/returnManage";
import commoditySaleManage from "../views/saleManage/commoditySaleManage";
import saleReturn from "../views/saleManage/saleReturn";
import myTask from "../views/otherManage/myTask";
import processManage from "../views/otherManage/processManage";

Vue.use(Router)

const router = new Router({
  routes: [
    {path: '/', redirect:'/login'},
    {path: '/login', component: login,},
    {path: '/navigation', component: navigation,},
    {path: '/breadcrumb', component: breadcrumb,},
    {path: '/index', component: index, name:index, meta: { title: '后台首页' }},
    {path: '/userDetail', component: userDetail, name:userDetail, meta: { title: '个人中心' }},

    {path: '/systemManage', component: systemManage, name:systemManage,meta: { title: '系统管理'},
      children:[
        {path: '/departmentManage', component: departmentManage, name:departmentManage,meta: { title: '部门管理' }},
        {path: '/rightManage', component: rightManage, name:rightManage,meta: { title: '权限管理' }},
        {path: '/ruleManage', component: ruleManage, name:ruleManage,meta: { title: '角色管理' }},
        {path: '/userManage', component: userManage, name:userManage,meta: { title: '用户管理' }},
      ]},

    {path: '/basicManage', component: basicManage, name:basicManage,meta: { title: '基础管理' },
      children:[
        {path: '/customerManage', component: customerManage, name:customerManage,meta: { title: '客户管理' }},
        {path: '/supplierManage', component: supplierManage, name:supplierManage,meta: { title: '供应商管理' }},
        {path: '/goodsManage', component: goodsManage, name:goodsManage,meta: { title: '商品管理' }},
      ]},

    {path: '/purchaseManageM', component: purchaseManageM, name:purchaseManageM,meta: { title: '货物管理' },
      children:[
        {path: '/purchaseManage', component: purchaseManage, name:purchaseManage,meta: { title: '进货管理' }},
        {path: '/returnManage', component: returnManage, name:returnManage,meta: { title: '退货管理' }},
      ]},

    {path: '/saleManage', component: saleManage, name:saleManage,meta: { title: '销售管理' },
      children:[
        {path: '/commoditySaleManage', component: commoditySaleManage, name:commoditySaleManage,meta: { title: '商品销售' }},
        {path: '/saleReturn', component: saleReturn, name:saleReturn,meta: { title: '销售退货' }},
      ]},

    {path: '/otherManage', component: otherManage, name:otherManage,meta: { title: '其他管理' },
      children:[
        {path: '/myTask', component: myTask, name:myTask,meta: { title: '我的任务' }},
        {path: '/processManage', component: processManage, name:processManage,meta: { title: '流程管理' }},
      ]},

    {
      path: '/404',
      name: '404',
      component: notFound
    },
    {
      path: '*',
      redirect: '/404'
    }
  ]
})

//挂载路由导航守卫
router.beforeEach((to, from, next) => {
  //debugger
  if (to.path === '/login') {
    next();
  } else {
    let token = sessionStorage.getItem('Authorization');
    if (!token) {
      next('/login');
    } else {
      next();
    }
  }
});
export default router
