import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/home/Home.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
    meta: {
      title: '首页',
      icon: 'ios-people'
    },
    children: [
      {
        path: '/w3c',
        name: 'w3c',
        component: () => import('@/views/templates/w3c-standard'),
        meta: {
          title: 'w3c html5 标准'
        }
      },
      {
        path: '/seletMenu',
        name: 'seletMenu',
        component: () => import('@/views/templates/select-menu'),
        meta: {
          title: '浮动下拉菜单'
        }
      },
      {
        path: '/test',
        name: 'test',
        component: () => import('@/views/templates/test'),
        meta: {
          title: '测试页面'
        }
      },
      {
        path: '/transform',
        name: 'transform',
        component: () => import('@/views/templates/transform'),
        meta: {
          title: 'transform 位移案例'
        }
      },
      {
        path: '/transition',
        name: 'transition',
        component: () => import('@/views/templates/transition'),
        meta: {
          title: 'transition 过度动画页面'
        }
      },
      {
        path: '/scale',
        name: 'scale',
        component: () => import('@/views/templates/scale'),
        meta: {
          title: 'scale 图片放大效果'
        }
      },
      {
        path: '/ligth',
        name: 'ligth',
        component: () => import('@/views/templates/ligth'),
        meta: {
          title: 'ligth 跑马灯效果'
        }
      },
      {
        path: '/dynamicRoute',
        name: 'dynamicRoute',
        component: () => import('@/views/templates/dynamicRoute'),
        meta: {
          title: 'component is 匹配不同组件并显示'
        }
      }
    ]
  },
  {
    path: '/about',
    name: 'about',
    component: Home,
    meta: {
      title: '关于项目',
      icon: 'ios-stats'
    },
    children: [
      {
        path: '/readme',
        name: 'readme',
        component: () => import('@/views/templates/readme'),
        meta: {
          title: '项目地址'
        }
      }
    ]
  },
  {
    path: '/array',
    name: 'array',
    component: Home,
    meta: {
      title: '数组操作',
      icon: 'ios-apps'
    },
    children: [
      {
        path: '/array-action',
        name: 'array-action',
        component: () => import('@/views/templates/array-action'),
        meta: {
          title: '数组'
        }
      }
    ]
  }
]

/**
 * 重写路由的push方法
 * 解决，相同路由跳转时，报错 虽然不影响程序运行
 */
const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push (location, onResolve, onReject) {
  if (onResolve || onReject) return originalPush.call(this, location, onResolve, onReject)
  return originalPush.call(this, location).catch((err) => err)
}

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
