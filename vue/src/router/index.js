import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import AdminHome from '../views/admin/Home.vue'
import User from '../views/admin/User'
import Account from '../views/Account'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/account',
      name: 'account',
      component: Account
    },
    {
      path: '/admin',
      name: 'admin',
      component: AdminHome,
      children: [
        {
          path: 'user',
          component: User
        }
      ]
    }
  ]
})
