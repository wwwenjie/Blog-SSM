<template>
  <v-content>
    <v-container
      class="fill-height"
      fluid
    >
      <v-row
        align="center"
        justify="center"
      >
        <v-col
          cols="12"
          sm="8"
          md="4"
        >
          <v-card class="elevation-12">
            <v-toolbar
              color="primary"
              dark
              flat
            >
              <v-toolbar-title>{{ title }}</v-toolbar-title>
            </v-toolbar>
            <v-card-text>
              <v-form>
                <v-text-field
                  v-model="user.userEmail"
                  label="邮箱"
                  name="email"
                  prepend-icon="mdi-account"
                  type="text"
                />

                <v-text-field
                  id="password"
                  v-model="user.userPassword"
                  label="密码"
                  name="password"
                  prepend-icon="mdi-shield"
                  type="password"
                />

                <v-text-field
                  v-if="!loginMode"
                  id="name"
                  v-model="user.userName"
                  label="用户名"
                  prepend-icon="mdi-information"
                  name="name"
                  type="text"
                />
                <v-radio-group
                  v-if="!loginMode"
                  v-model="user.userGender"
                  row
                >
                  <span class="mr-4">性别</span>
                  <v-radio
                    label="男"
                    value="男"
                  />
                  <v-radio
                    label="女"
                    value="女"
                  />
                </v-radio-group>
              </v-form>
            </v-card-text>
            <v-card-actions class="mx-2">
              <v-btn
                color="primary"
                @click="register"
              >
                注册
              </v-btn>
              <v-spacer />
              <v-btn
                color="primary"
                @click="login"
              >
                登陆
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </v-content>
</template>

<script>
import { login, register } from '../api/user'

export default {
  name: 'Account',
  data () {
    return {
      title: '登陆',
      loginMode: true,
      user: {
        userName: undefined,
        userPassword: undefined,
        userEmail: undefined,
        userGender: undefined
      }
    }
  },
  methods: {
    async register () {
      if (this.loginMode) {
        this.title = '注册'
        this.loginMode = false
      } else {
        await register(this.user)
      }
    },
    async login () {
      this.loginMode = true
      const auth = await login(this.user)
      localStorage.setItem('token', auth.token)
    }
  }
}
</script>

<style scoped>

</style>
