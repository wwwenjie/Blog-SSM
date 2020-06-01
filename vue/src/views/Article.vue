<template>
  <div>
    <core-app-bar />

    <core-drawer />

    <v-content>
      <v-sheet
        style="width: 70vw"
        class="mx-auto"
      >
        <v-card>
          <v-img
            class="white--text align-end"
            height="200px"
            src="https://cdn.vuetifyjs.com/images/cards/docks.jpg"
          >
            <v-card-title>{{ article.articleTitle }} / {{ article.userId }}</v-card-title>
          </v-img>

          <v-card-subtitle class="pb-0">
            {{ new Date(article.articleLastModifyDate + 8 * 3600 * 1000).toJSON().substr(0, 19).replace('T', ' ') }}
          </v-card-subtitle>

          <v-card-text class="text--primary">
            <div v-html="article.articleContent" />
          </v-card-text>
        </v-card>
        <v-divider />
        <comments :id="article.articleId" />
      </v-sheet>
    </v-content>

    <core-footer />
  </div>
</template>

<script>
import { getArticle } from '../api/article'
export default {
  name: 'Article',
  components: {
    CoreDrawer: () => import('../components/core/Drawer'),
    CoreFooter: () => import('../components/core/Footer'),
    CoreAppBar: () => import('../components/core/AppBar'),
    Comments: () => import('../components/Comments')
  },
  data () {
    return {
      article: {
        // avoid undefined error
        articleContent: '加载中',
        articleLastModifyDate: 1
      }
    }
  },
  async mounted () {
    this.article = await getArticle(this.$route.params.id)
  }
}
</script>

<style scoped>

</style>
