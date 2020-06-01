<template>
  <v-row class="mx-2">
    <v-col
      cols="4"
    >
      <v-card v-if="admin">
        <v-card-title>用户总数</v-card-title>
        <v-card-text>{{ totalUser }}</v-card-text>
      </v-card>
      <v-card v-else>
        <v-card-title>你好，博主</v-card-title>
      </v-card>
    </v-col>
    <v-col
      cols="4"
    >
      <v-card>
        <v-card-title>博客总数</v-card-title>
        <v-card-text>{{ totalArticle }}</v-card-text>
      </v-card>
    </v-col>
    <v-col
      cols="4"
    >
      <v-card>
        <v-card-title>评论总数</v-card-title>
        <v-card-text>{{ totalArticle }}</v-card-text>
      </v-card>
    </v-col>
  </v-row>
</template>

<script>
import { getUserTotal } from '../../api/user'
import { getArticleTotal } from '../../api/article'
import { getCommentTotal } from '../../api/comment'

export default {
  name: 'Index',
  data () {
    return {
      admin: false,
      totalUser: undefined,
      totalArticle: undefined,
      totalComment: undefined
    }
  },
  async mounted () {
    this.totalUser = await getUserTotal()
    this.totalArticle = await getArticleTotal()
    this.totalComment = await getCommentTotal()
    this.admin = localStorage.getItem('admin')
  }
}
</script>

<style scoped>

</style>
