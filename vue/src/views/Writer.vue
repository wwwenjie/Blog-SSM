<template>
  <div>
    <core-app-bar />

    <core-drawer />

    <v-content>
      <v-data-table
        :headers="headers"
        :items="users"
        :options.sync="options"
        :server-items-length="totalUsers"
        :loading="loading"
        class="elevation-1 mx-auto"
        style="width: 70vw;"
      >
        <template v-slot:top>
          <v-toolbar
            flat
            color="white"
          >
            <v-toolbar-title>博主列表</v-toolbar-title>
            <v-divider
              class="mx-4"
              inset
              vertical
            />
          </v-toolbar>
        </template>
      </v-data-table>
    </v-content>

    <core-footer />
  </div>
</template>

<script>
import { getUserList, getUserTotal } from '../api/user'

export default {
  name: 'Writer',
  components: {
    CoreDrawer: () => import('../components/core/Drawer'),
    CoreFooter: () => import('../components/core/Footer'),
    CoreAppBar: () => import('../components/core/AppBar')
  },
  data () {
    return {
      headers: [
        {
          text: '用户ID',
          align: 'start',
          value: 'userId'
        },
        {
          text: '用户名',
          value: 'userName'
        },
        {
          text: '用户性别',
          value: 'userGender'
        },
        {
          text: '注册日期',
          value: 'userRegistrationDate'
        }
      ],
      users: [],
      totalUsers: 0,
      loading: true,
      options: {}
    }
  },
  watch: {
    options: async function (options) {
      await this.getUsers(options)
    }
  },
  async mounted () {
    this.totalUsers = await getUserTotal()
  },
  methods: {
    async getUsers (options) {
      this.loading = true
      this.users = await getUserList(options.page, options.itemsPerPage)
      this.users.forEach(user => {
        const date = new Date(user.userRegistrationDate + 8 * 3600 * 1000)
        user.userRegistrationDate = date.toJSON().substr(0, 19).replace('T', ' ')
      })
      this.loading = false
    }
  }
}
</script>

<style scoped>

</style>
