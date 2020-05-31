<template>
  <v-app id="inspire">
    <!--global snackbar-->
    <snackbar
      :show="snackCon.show"
      :snack-con="snackCon"
    />
    <router-view />
  </v-app>
</template>

<script>
import Snackbar from './components/core/Snackbar'
export default {
  name: 'App',
  components: {
    snackbar: Snackbar
  },
  computed: {
    snackCon: function () {
      return this.$store.state.snackCon
    }
  }
}
</script>
