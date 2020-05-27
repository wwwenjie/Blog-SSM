import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login'
import Register from '../views/Register'
import UserList from '../views/UserList'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/register',
    name: 'Register',
    component: Register
  },
  {
    path: '/users',
    name: 'Users',
    component: UserList
  },
  {
    path: '*',
    name: '404',
    // supposed to be 404 page
    component: Home
  }
]

const router = new VueRouter({
  base: process.env.BASE_URL,
  routes
})

export default router
