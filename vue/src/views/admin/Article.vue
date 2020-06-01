<template>
  <v-data-table
    :headers="headers"
    :items="articles"
    :options.sync="options"
    :server-items-length="totalArticles"
    :loading="loading"
    class="elevation-1"
  >
    <template v-slot:top>
      <v-toolbar
        flat
        color="white"
      >
        <v-toolbar-title>博文列表</v-toolbar-title>
        <v-divider
          class="mx-4"
          inset
          vertical
        />
        <v-spacer />
        <v-btn
          color="primary"
          dark
          class="mb-2"
          @click="$router.push({ name: 'edit' })"
        >
          新建博文
        </v-btn>
      </v-toolbar>
    </template>
    <template v-slot:item.actions="{ item }">
      <v-icon
        small
        class="mr-2"
        @click="onEdit(item.articleId)"
      >
        mdi-pencil
      </v-icon>
      <v-icon
        small
        @click="onDelete(item.articleId)"
      >
        mdi-delete
      </v-icon>
    </template>
  </v-data-table>
</template>

<script>
import Message from '../../util/message'
import { deleteArticle, getArticleByUserId, getArticleList, getArticleTotal } from '../../api/article'

export default {
  name: 'Article',
  data () {
    return {
      editMode: true,
      dialog: false,
      text: '操作成功',
      headers: [
        {
          text: '博文ID',
          align: 'start',
          value: 'articleId'
        },
        {
          text: '作者ID',
          value: 'userId'
        },
        {
          text: '博文分类',
          value: 'articleCategory'
        },
        {
          text: '博文标题',
          value: 'articleTitle'
        },
        {
          text: '发表日期',
          value: 'articleDate'
        },
        {
          text: '修改日期',
          value: 'articleLastModifyDate'
        },
        {
          text: '操作',
          value: 'actions',
          sortable: false
        }
      ],
      articles: [],
      totalArticles: 0,
      loading: true,
      options: {}
    }
  },
  watch: {
    options: async function (options) {
      await this.getArticles(options)
    }
  },
  async mounted () {
    this.totalArticles = await getArticleTotal()
  },
  methods: {
    async onDelete (id) {
      await deleteArticle(id)
      this.totalArticles = await getArticleTotal()
      await this.getArticles(this.options)
      Message.success()
    },
    onEdit (id) {
      this.$router.push({ name: 'edit', query: { id: id } })
    },
    async getArticles (options) {
      this.loading = true
      if (localStorage.getItem('admin')) {
        this.articles = await getArticleList(options.page, options.itemsPerPage)
      } else {
        this.articles = await getArticleByUserId(localStorage.getItem('uid'), options.page, options.itemsPerPage)
      }
      this.articles.forEach(article => {
        const date = new Date(article.articleDate + 8 * 3600 * 1000)
        const date2 = new Date(article.articleLastModifyDate + 8 * 3600 * 1000)
        article.articleDate = date.toJSON().substr(0, 19).replace('T', ' ')
        article.articleLastModifyDate = date2.toJSON().substr(0, 19).replace('T', ' ')
      })
      this.loading = false
    }
  }
}
</script>

<style scoped>

</style>
