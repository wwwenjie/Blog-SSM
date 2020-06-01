<template>
  <v-data-table
    :headers="headers"
    :items="users"
    :options.sync="options"
    :server-items-length="totalUsers"
    :loading="loading"
    class="elevation-1"
  >
    <template v-slot:top>
      <v-toolbar
        flat
        color="white"
      >
        <v-toolbar-title>用户列表</v-toolbar-title>
        <v-divider
          class="mx-4"
          inset
          vertical
        />
        <v-spacer />
        <v-dialog
          v-model="dialog"
          max-width="500px"
        >
          <template v-slot:activator="{ on }">
            <v-btn
              color="primary"
              dark
              class="mb-2"
              v-on="on"
              @click="onCreate"
            >
              新建用户
            </v-btn>
          </template>
          <v-card>
            <v-card-title>
              <span class="headline">{{ editMode ? "修改用户" : "新建用户" }}</span>
            </v-card-title>

            <v-card-text>
              <v-container>
                <v-row>
                  <v-col
                    cols="12"
                    sm="6"
                    md="4"
                  >
                    <v-text-field
                      v-model="editedItem.userName"
                      label="用户名"
                    />
                  </v-col>
                  <v-col
                    cols="12"
                    sm="6"
                    md="4"
                  >
                    <v-text-field
                      v-model="editedItem.userEmail"
                      label="用户邮箱"
                    />
                  </v-col>
                  <v-col
                    cols="12"
                    sm="6"
                    md="4"
                  >
                    <v-text-field
                      v-model="editedItem.userPassword"
                      label="用户密码"
                    />
                  </v-col>
                  <v-col
                    cols="12"
                    sm="6"
                    md="4"
                  >
                    <v-text-field
                      v-model="editedItem.userGender"
                      label="用户性别"
                    />
                  </v-col>
                </v-row>
              </v-container>
            </v-card-text>

            <v-card-actions>
              <v-spacer />
              <v-btn
                color="blue darken-1"
                text
                @click="dialog = false"
              >
                取消
              </v-btn>
              <v-btn
                color="blue darken-1"
                text
                @click="save"
              >
                {{ editMode ? "修改" : "新建" }}
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
      </v-toolbar>
    </template>
    <template v-slot:item.actions="{ item }">
      <v-icon
        small
        class="mr-2"
        @click="onEdit(item)"
      >
        mdi-pencil
      </v-icon>
      <v-icon
        small
        @click="onDelete(item.userId)"
      >
        mdi-delete
      </v-icon>
    </template>
  </v-data-table>
</template>

<script>
import Message from '../../util/message'
import { deleteUser, getUserList, getUserTotal, register, updateUser } from '../../api/user'

export default {
  name: 'User',
  data () {
    return {
      editMode: true,
      dialog: false,
      text: '操作成功',
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
          text: '邮箱',
          value: 'userEmail'
        },
        {
          text: '密码',
          value: 'userPassword'
        },
        {
          text: '用户性别',
          value: 'userGender'
        },
        {
          text: '注册日期',
          value: 'userRegistrationDate'
        },
        {
          text: '注册IP',
          value: 'userIp'
        },
        {
          text: '操作',
          value: 'actions',
          sortable: false
        }
      ],
      users: [],
      totalUsers: 0,
      loading: true,
      options: {},
      editedIndex: -1,
      editedItem: {
        userName: '',
        userEmail: '',
        userPassword: '',
        userGender: ''
      }
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
    onEdit (user) {
      this.editMode = true
      const { userId, userName, userEmail, userPassword, userGender } = user
      this.editedItem.userId = userId
      this.editedItem.userName = userName
      this.editedItem.userEmail = userEmail
      this.editedItem.userPassword = userPassword
      this.editedItem.userGender = userGender
      this.dialog = true
    },
    async onDelete (id) {
      await deleteUser(id)
      this.totalUsers = await getUserTotal()
      await this.getUsers(this.options)
      Message.success()
    },
    onCreate () {
      this.editMode = false
      delete this.editedItem.userId
      this.editedItem.userName = ''
      this.editedItem.userEmail = ''
      this.editedItem.userPassword = ''
      this.editedItem.userGender = ''
    },
    async save () {
      if (this.editMode) {
        await updateUser(this.editedItem)
      } else {
        await register(this.editedItem)
        this.totalUsers = await getUserTotal()
      }
      await this.getUsers(this.options)
      Message.success()
      this.dialog = false
    },
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
