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
    <v-col
      v-if="admin"
      cols="4"
    >
      <v-card>
        <v-card-title>博客名</v-card-title>
        <v-text-field
          v-model="blogName"
          label="修改博客名"
          class="mx-4"
        >
          <template v-slot:append-outer>
            <v-btn
              color="primary"
              @click="updateBlogName"
            >
              保存
            </v-btn>
          </template>
        </v-text-field>
      </v-card>
    </v-col>
  </v-row>
</template>

<script>
import { getUserTotal } from '../../api/user'
import { getArticleTotal } from '../../api/article'
import { getCommentTotal } from '../../api/comment'
import { getBlogName, updateOption } from '../../api/option'
import Message from '../../util/message'

export default {
  name: 'Index',
  data () {
    return {
      admin: false,
      blogName: undefined,
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
    this.blogName = await getBlogName()
  },
  methods: {
    async updateBlogName () {
      await updateOption({
        optionId: 2,
        optionValue: this.blogName
      })
      Message.success()
    }
  }
}
</script>

<style scoped>

</style>
