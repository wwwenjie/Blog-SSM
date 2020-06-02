import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import AdminHome from '../views/admin/Home.vue'
import User from '../views/admin/User'
import Index from '../views/admin/Index'
import Editor from '../views/admin/Editor'
import Account from '../views/Account'
import Article from '../views/Article'
import ArticleList from '../views/admin/Article'
import Comment from '../views/admin/Comment'
import Writer from '../views/Writer'
import Log from '../views/admin/Log'

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
      path: '/article/:id',
      name: 'article',
      component: Article
    },
    {
      path: '/account',
      name: 'account',
      component: Account
    },
    {
      path: '/writer',
      name: 'writer',
      component: Writer
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
          name: 'articleList',
          path: 'article',
          component: ArticleList
        },
        {
          name: 'commentList',
          path: 'comment',
          component: Comment
        },
        {
          name: 'logList',
          path: 'log',
          component: Log
        }
      ]
    }
  ]
})
