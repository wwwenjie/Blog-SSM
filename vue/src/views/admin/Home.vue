<template>
  <div id="inspire">
    <v-navigation-drawer
      v-model="drawer"
      :clipped="$vuetify.breakpoint.lgAndUp"
      app
    >
      <v-list dense>
        <template v-for="item in items">
          <v-list-item
            :key="item.text"
            link
            :to="{name: item.route}"
          >
            <v-list-item-action>
              <v-icon>{{ item.icon }}</v-icon>
            </v-list-item-action>
            <v-list-item-content>
              <v-list-item-title>
                {{ item.text }}
              </v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </template>
      </v-list>
    </v-navigation-drawer>

    <v-app-bar
      :clipped-left="$vuetify.breakpoint.lgAndUp"
      app
      color="blue darken-3"
      dark
    >
      <v-app-bar-nav-icon @click.stop="drawer = !drawer" />
      <v-toolbar-title
        style="width: 300px"
        class="ml-0 pl-4"
        @click="$router.push({ name: 'adminIndex' })"
      >
        <span class="hidden-sm-and-down">博客后台管理</span>
      </v-toolbar-title>
      <v-spacer />
      <v-toolbar-title
        class="mr-6"
        @click="$router.push({ name: 'home' })"
      >
        <v-btn outlined>
          博客首页
        </v-btn>
      </v-toolbar-title>
      <v-toolbar-title
        @click="logout"
      >
        <v-btn outlined>
          登出
        </v-btn>
      </v-toolbar-title>
    </v-app-bar>
    <v-content>
      <v-container
        class="fill-height"
        fluid
      >
        <v-row
          align="center"
          justify="center"
        >
          <router-view />
        </v-row>
      </v-container>
    </v-content>
  </div>
</template>

<script>
import axios from '../../plugins/axios'
import { getUserTotal } from '../../api/user'

export default {
  name: 'AdminHome',
  data: () => ({
    dialog: false,
    drawer: null,
    items: [
      {
        icon: 'mdi-contacts',
        text: '用户列表',
        route: 'userList'
      },
      {
        icon: 'mdi-post',
        text: '博文列表',
        route: 'articleList'
      },
      {
        icon: 'mdi-pencil',
        text: '编辑博文',
        route: 'edit'
      },
      {
        icon: 'mdi-pencil',
        text: '评论列表',
        route: 'commentList'
      }
    ]
  }),
  async beforeRouteEnter (to, from, next) {
    try {
      // 请求一个需要权限的资源
      await getUserTotal()
      next()
      // 若 401 错误则跳转登陆页面
    } catch (e) {
      next({ path: '/account' })
    }
  },
  methods: {
    logout () {
      axios.defaults.headers.Authorization = null
      this.$router.push({ name: 'account' })
    }
  }
}
</script>

<style scoped>

</style>
