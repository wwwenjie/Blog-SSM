<template>
  <v-card class="mt-12">
    <v-card-title>评论</v-card-title>
    <v-card-text v-if="comments.length !== 0">
      <v-list-item
        v-for="(comment, index) in comments"
        :key="index"
      >
        <v-list-item-icon style="width: 90px;">
          <span>{{ comment.userName }} :</span>
        </v-list-item-icon>

        <v-list-item-content>
          <v-list-item-title v-text="comment.commentContent" />
          <v-divider />
        </v-list-item-content>
      </v-list-item>
    </v-card-text>
    <v-card-text
      v-else
    >
      <h3>暂无评论</h3>
    </v-card-text>
    <v-card-actions class="pa-0">
      <v-form
        style="width: 500px"
        class="mx-7 mb-12"
      >
        <v-card-title class="mx-n7">
          发表评论
        </v-card-title>
        <v-text-field
          v-model="userName"
          :counter="10"
          label="姓名（非必须）"
        />

        <v-text-field
          v-model="commentContent"
          label="评论内容"
          required
        />

        <v-btn
          color="primary"
          @click="creatComment"
        >
          发表评论
        </v-btn>
      </v-form>
    </v-card-actions>
  </v-card>
</template>

<script>
import { creatComment, getCommentByArticleId } from '../api/comment'
import Message from '../util/message'

export default {
  name: 'Comments',
  // eslint-disable-next-line vue/require-prop-types
  props: ['id'],
  data () {
    return {
      userName: undefined,
      commentContent: undefined,
      comments: []
    }
  },
  watch: {
    id: async function () {
      this.comments = await getCommentByArticleId(this.id)
    }
  },
  methods: {
    async creatComment () {
      const newComment = {
        userName: this.userName,
        commentContent: this.commentContent,
        articleId: this.id,
        commentDate: new Date()
      }
      await creatComment(newComment)
      this.comments = await getCommentByArticleId(this.id)
      Message.success()
    }
  }
}
</script>

<style scoped>

</style>
