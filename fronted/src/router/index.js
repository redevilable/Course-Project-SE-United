import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

/**
 * Note: sub-menu only appear when route children.length >= 1
 * Detail see: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 *
 * hidden: true                   if set true, item will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu
 *                                if not set alwaysShow, when item has more than one children route,
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noRedirect           if set noRedirect will no redirect in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
 roles: ['admin','editor']    control the page roles (you can set multiple roles)
 title: 'title'               the name show in sidebar and breadcrumb (recommend set)
 icon: 'svg-name'/'el-icon-x' the icon show in the sidebar
 breadcrumb: false            if set false, the item will hidden in breadcrumb(default is true)
 activeMenu: '/example/list'  if set path, the sidebar will highlight the path you set
 }
 */

/**
 * constantRoutes
 * a base page that does not have permission requirements
 * all roles can be accessed
 */
export const constantRoutes = [
  {
    path: '/404',
    component: () => import('@/views/404'),
    hidden: true
  },

  {
    path: '/',
    component: Layout,
    name: 'Overview',
    meta: {
      'title': 'Overview',
      'icon': 'el-icon-s-help'
    },
    alwaysShow: false,
    children: [
      {
        path: 'overview',
        name: 'Overview',
        component: () => import('@/views/overview/index.vue'),
        meta: {
          title: 'Overview',
          icon: 'example'
        }
      }
    ]
  },

  {
    path: '/project',
    component: Layout,
    name: 'Project Manage',
    meta: {
      'title': 'Project Manage',
      'icon': 'el-icon-s-help'
    },
    alwaysShow: false,
    children: [
      {
        path: 'project_manage',
        name: 'Project Manage',
        component: () => import('@/views/product/index.vue'),
        meta: {
          title: 'Project List',
          icon: 'link'
        }
      }
    ]
  },

  {
    path: '/sprint',
    component: Layout,
    name: 'Sprint Manage',
    meta: {
      'title': 'Sprint Manage',
      'icon': 'el-icon-s-help'
    },
    alwaysShow: false,
    children: [
      {
        path: 'sprint_manage',
        name: 'Sprint Manage',
        component: () => import('@/views/sprint/index.vue'),
        meta: {
          title: 'Sprint List',
          icon: 'table'
        }
      }
    ]
  },

  {
    path: '/userstory',
    component: Layout,
    name: 'Userstory Manage',
    meta: {
      'title': 'Userstory Manage',
      'icon': 'el-icon-s-help'
    },
    alwaysShow: false,
    children: [
      {
        path: 'userstory_manage',
        name: 'Userstory Manage',
        component: () => import('@/views/userstory/index.vue'),
        meta: {
          title: 'Userstory List',
          icon: 'dashboard'
        }
      }
    ]
  },

  {
    path: '/login',
    name: 'login',
    component: () => import('@/views/user/login.vue'),
    hidden: true
  },

  {
    path: '/register',
    name: 'register',
    component: () => import('@/views/user/register.vue'),
    hidden: true
  },

  // 404 page must be placed at the end !!!
  {path: '*', redirect: '/404', hidden: true}
]

const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({y: 0}),
  routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
