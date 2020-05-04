<template>
  <div>
    <h1>Login</h1>
    <p class="register-input">
      <label>
        <div>Email / Telephone</div>
        <input
          v-model="user.userEmail"
          type="text"
        />
      </label>
    </p>
    <p class="register-input">
      <label>
        <div>Password</div>
        <input
          v-model="user.userPassword"
          type="text"
        />
      </label>
    </p>
    <button
      class="register-button"
      @click="login"
    >Login</button>
    <p>{{user}}</p>
    <p>
      <img :src="user.userProfilePhoto" style="width: 30vw; height: 10vw"/>
    </p>
  </div>
</template>

<script>
import { login, getUserInfo } from '../api/user'

export default {
  name: 'Login',
  data: function () {
    return {
      user: {
        userEmail: undefined,
        userPassword: undefined
      }
    }
  },
  methods: {
    async login () {
      const res = await login(this.user)
      if (res) {
        this.$store.commit('CALL_MESSAGE', { text: 'success' })
        localStorage.setItem('token', res.token)
        localStorage.setItem('uid', res.uid)
        this.user = await getUserInfo(res.uid)
      }
    }
  }
}
</script>

<style scoped>

</style>
