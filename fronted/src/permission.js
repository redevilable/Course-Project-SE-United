import { getToken, removeToken } from '@/utils/auth'
import { getInfo } from '@/api/user'

export function before(router) {
  router.beforeEach((to, from, next) => {
    next()
    // const token = getToken()
    // if (token) {
    //   getInfo(token).then(response => {
    //     const { status } = response.data
    //     if (status !== 0) {
    //       removeToken('token')
    //       next({ path: '/login' })
    //     } else {
    //       next()
    //     }
    //   }).catch(error => {
    //     console.log(error)
    //     next({ path: '/login' })
    //   })
    // } else {
    //   if (to.name !== 'login' && to.name !== 'register' && !token) {
    //     next({ path: '/login' })
    //   } else {
    //     next()
    //   }
    // }
  })
}
