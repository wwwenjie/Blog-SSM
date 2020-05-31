<template>
  <v-row class="mx-2">
    <v-col
      cols="4"
    >
      <v-card>
        <v-card-title>用户总数</v-card-title>
        <v-card-text>{{ totalUsers }}</v-card-text>
      </v-card>
    </v-col>
  </v-row>
</template>

<script>
import { getUserTotal } from '../../api/user'

export default {
  name: 'Index',
  data () {
    return {
      totalUsers: undefined
    }
  },
  async mounted () {
    this.totalUsers = await getUserTotal()
  }
}
</script>

<style scoped>

</style>
