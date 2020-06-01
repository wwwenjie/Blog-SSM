import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import AdminHome from '../views/admin/Home.vue'
import User from '../views/admin/User'
import Index from '../views/admin/Index'
import Editor from '../views/admin/Editor'
import Account from '../views/Account'
import Article from '../views/admin/Article'

Vue.use(Router)

export default new Router({
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
          name: 'adminIndex',
          path: 'index',
          component: Index
        },
        {
          name: 'userList',
          path: 'user',
          component: User
        },
        {
          name: 'edit',
          path: 'edit',
          component: Editor
        },
        {
          name: 'article',
          path: 'article',
          component: Article
        }
      ]
    }
  ]
})
