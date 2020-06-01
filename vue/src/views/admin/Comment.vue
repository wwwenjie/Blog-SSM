<template>
  <v-data-table
    :headers="headers"
    :items="comments"
    :options.sync="options"
    :server-items-length="totalComment"
    :loading="loading"
    class="elevation-1"
  >
    <template v-slot:top>
      <v-toolbar
        flat
        color="white"
      >
        <v-toolbar-title>评论列表</v-toolbar-title>
        <v-spacer />
        <div v-if="!admin">
          <v-btn @click="myCommentMode=true">
            查看我的评论
          </v-btn>
          <v-btn @click="myCommentMode=false">
            查看我的博客评论
          </v-btn>
        </div>
      </v-toolbar>
      <v-dialog
        v-model="dialog"
        max-width="600px"
      >
        <v-card>
          <v-card-title>
            <span class="headline">修改评论</span>
          </v-card-title>
          <v-card-text>
            <v-container>
              <v-row>
                <v-col
                  cols="12"
                >
                  <v-text-field
                    v-model="editContent"
                    label="评论内容"
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
              @click="onUpdate"
            >
              修改
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
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
        @click="onDelete(item.commentId)"
      >
        mdi-delete
      </v-icon>
    </template>
  </v-data-table>
</template>

<script>
import Message from '../../util/message'
import {
  deleteComment,
  getCommentTotal,
  getCommentList,
  updateComment,
  getCommentByUserId,
  getCommentByArticleId
} from '../../api/comment'
import { getArticleByUserId } from '../../api/article'

export default {
  name: 'Comment',
  data () {
    return {
      admin: localStorage.getItem('admin'),
      myCommentMode: true,
      editMode: true,
      dialog: false,
      text: '操作成功',
      editContent: undefined,
      editId: undefined,
      headers: [
        {
          text: '评论ID',
          align: 'start',
          value: 'commentId'
        },
        {
          text: '评论内容',
          align: 'start',
          value: 'commentContent'
        },
        {
          text: '评论博文ID',
          value: 'articleId'
        },
        {
          text: '评论者ID',
          value: 'userId'
        },
        {
          text: '评论者姓名',
          value: 'userName'
        },
        {
          text: '评论者IP',
          value: 'userIp'
        },
        {
          text: '发表日期',
          value: 'commentDate'
        },
        {
          text: '操作',
          value: 'actions',
          sortable: false
        }
      ],
      comments: [],
      totalComment: 0,
      loading: true,
      options: {}
    }
  },
  watch: {
    options: async function (options) {
      await this.getComments(options)
    },
    myCommentMode: async function (options) {
      await this.getComments(options)
    }
  },
  async mounted () {
    this.totalComment = await getCommentTotal()
  },
  methods: {
    async onDelete (id) {
      await deleteComment(id)
      this.totalComment = await getCommentTotal()
      await this.getComments(this.options)
      Message.success()
    },
    onEdit (comment) {
      this.dialog = true
      this.editContent = comment.commentContent
      this.editId = comment.commentId
    },
    async onUpdate () {
      const editComment = {
        commentId: this.editId,
        commentContent: this.editContent
      }
      this.dialog = false
      await updateComment(editComment)
      this.comments.forEach(comment => {
        if (comment.commentId === this.editId) {
          comment.commentContent = this.editContent
        }
      })
      Message.success()
    },
    async getComments (options) {
      this.loading = true
      if (localStorage.getItem('admin')) {
        this.comments = await getCommentList(options.page, options.itemsPerPage)
      } else {
        const uid = localStorage.getItem('uid')
        if (this.myCommentMode) {
          this.comments = await getCommentByUserId(uid, options.page, options.itemsPerPage)
        } else {
          const articles = await getArticleByUserId(uid)
          if (articles.length > 0) {
            for (const article of articles) {
              this.comments = await getCommentByArticleId(article.articleId)
            }
          }
        }
        if (this.comments.length === 0) {
          this.loading = false
          return
        }
      }
      this.comments.forEach(comment => {
        const date = new Date(comment.commentDate + 8 * 3600 * 1000)
        comment.commentDate = date.toJSON().substr(0, 19).replace('T', ' ')
      })
      this.loading = false
    }
  }
}
</script>

<style scoped>

</style>
