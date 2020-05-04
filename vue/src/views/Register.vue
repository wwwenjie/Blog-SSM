<template>
  <div>
    <h1>Register</h1>
    <div>
      <p
        v-for="(val,key) in user"
        :key="key"
        class="register-input"
      >
        <label>
          <div>{{key}}</div>
          <input
            v-model="user[key]"
            type="text"
          />
        </label>
      </p>
      <p class="register-input">
        <label>
          <div>userProfilePhoto</div>
          <input
            ref="img"
            type="file"
            @input="onUpload"
          >
        </label>
      </p>
      <img :src=user.userProfilePhoto style="width: 30vw; height: 10vw">
    </div>
    <button @click="register" class="register-button">Register</button>
    <p>{{user}}</p>
  </div>
</template>

<script>
import { register, uploadImg } from '../api/user'

export default {
  name: 'Register',
  data: function () {
    return {
      url: undefined,
      user: {
        userName: undefined,
        userEmail: undefined,
        userPassword: undefined,
        userProfilePhoto: undefined,
        userGender: undefined,
        userHobby: undefined,
        userBday: undefined
      }
    }
  },
  methods: {
    async register () {
      const res = await register(this.user)
      this.$store.commit('CALL_MESSAGE', { text: res })
    },
    async onUpload () {
      const f = this.$refs.img
      const param = new FormData()
      param.append('img', f.files[0])// 通过append向form对象添加数据
      const res = await uploadImg(param)
      console.log(res.url)
      this.user.userProfilePhoto = 'http://localhost:8000' + res.url
    }
  }
}
</script>

<style lang="sass">
.register
  &-input
    display: flex
    justify-content: center
    text-align: left
    &>label>input
      width: 30vw
  &-button
    width: 30vw
    height: 30px
    color: white
    background-color: deepskyblue
</style>
