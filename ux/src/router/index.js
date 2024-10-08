import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

// 公共路由
export const constantRoutes = [
  {
    path: '/redirect',
    component: Layout,
    hidden: true,
    children: [
      {
        path: '/redirect/:path(.*)',
        component: () => import('@/views/login/redirect')
      }
    ]
  },
  {
    path: '/login',
    component: () => import('@/views/login/login'),
    hidden: true
  },
  {
    path: '/register',
    component: () => import('@/views/login/register'),
    hidden: true
  },
  {
    path: '/404',
    component: () => import('@/views/error/404'),
    hidden: true
  },
  {
    path: '/401',
    component: () => import('@/views/error/401'),
    hidden: true
  },
  {
    path: '',
    component: Layout,
    redirect: 'index',
    children: [
      {
        path: 'index',
        component: () => import('@/views/dashboard/index'),
        name: 'Index',
        meta: { title: '首页', icon: 'list', affix: true }
      }
    ]
  }
]

// 动态路由，基于用户权限动态去加载
export const dynamicRoutes = [
  {
    path: '/system/user',
    component: Layout,
    meta: { title: '基础配置', icon: 'system', affix: true },
    children: [
      {
        path: 'user/list',
        component: () => import('@/views/system/user/index'),
        name: 'SystemUserList',
        meta: { title: '用户管理' }
      },
      {
        path: 'config/list',
        component: () => import('@/views/system/user/index'),
        name: 'SystemRoleList',
        meta: { title: '角色管理' }
      }
    ]
  },
  {
    path: '/imt',
    component: Layout,
    meta: { title: 'I茅台管理', icon: 'wechat', affix: true },
    children: [
      {
        path: 'user/list',
        component: () => import('@/views/imt/user/index'),
        name: 'IMTUserList',
        meta: { title: '用户列表' }
      },
      {
        path: 'item/list',
        component: () => import('@/views/imt/item/index'),
        name: 'IMTItemList',
        meta: { title: '预约商品' }
      },
      {
        path: 'delivery/list',
        component: () => import('@/views/imt/delivery/index'),
        name: 'IMTDeliveryList',
        meta: { title: '投放查询' }
      },
      {
        path: 'shop/list',
        component: () => import('@/views/imt/shop/index'),
        name: 'IMTShopList',
        meta: { title: '门店列表' }
      },
      {
        path: 'log/list',
        component: () => import('@/views/imt/log/index'),
        name: 'IMTLogList',
        meta: { title: '日志列表' }
      }
    ]
  },
  {
    path: '/system/xiaomi',
    component: Layout,
    meta: { title: '小米管理', icon: 'github', affix: true },
    children: [
      {
        path: 'xiaomi/user',
        component: () => import('@/views/imt/user/index'),
        name: 'XiaoMiUserList',
        meta: { title: '用户列表' }
      },
      {
        path: 'xiaomi/log',
        component: () => import('@/views/imt/log/index'),
        name: 'XiaoMiLogList',
        meta: { title: '小米预约' }
      }
    ]
  },
  {
    path: '/system/log',
    component: Layout,
    meta: { title: '日志管理', icon: 'star', affix: true },
    children: [
      {
        path: 'login/log',
        component: () => import('@/views/imt/user/index'),
        name: 'SystemLoginLogList',
        meta: { title: '登录日志' }
      },
      {
        path: 'operation/pro',
        component: () => import('@/views/imt/user/index'),
        name: 'SystemLogList',
        meta: { title: '操作日志' }
      }
    ]
  },
]

// 防止连续点击多次路由报错
let routerPush = Router.prototype.push;
Router.prototype.push = function push(location) {
  return routerPush.call(this, location).catch(err => err)
}

export default new Router({
  mode: 'history', // 去掉url中的#
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})
