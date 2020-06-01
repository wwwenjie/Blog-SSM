<template>
  <v-container>
    <v-row>
      <v-col cols="12">
        <slot />
      </v-col>

      <feed-card
        v-for="(article, i) in articles"
        :key="article.articleId"
        :size="layout[i]"
        :value="article"
      />
    </v-row>

    <v-row align="center">
      <v-col cols="3">
        <base-btn
          v-if="page !== 1"
          class="ml-0"
          square
          title="Previous page"
          @click="page--"
        >
          <v-icon>mdi-chevron-left</v-icon>
        </base-btn>
      </v-col>

      <v-col
        class="text-center subheading"
        cols="6"
      >
        PAGE {{ page }} OF {{ pages }}
      </v-col>

      <v-col
        class="text-right"
        cols="3"
      >
        <base-btn
          v-if="pages > 1 && page < pages"
          class="mr-0"
          square
          title="Next page"
          @click="page++"
        >
          <v-icon>mdi-chevron-right</v-icon>
        </base-btn>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
// Utilities
import { getArticleList, getArticleTotal } from '../api/article'

export default {
  name: 'Feed',

  components: {
    FeedCard: () => import('@/components/FeedCard')
  },

  data: () => ({
    articles: undefined,
    layout: [1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3],
    page: 1,
    pages: 1
  }),

  watch: {
    async page () {
      window.scrollTo(0, 0)
      this.articles = await getArticleList(this.page, 8)
    }
  },

  async mounted () {
    this.articles = await getArticleList(0, 8)
    this.pages = Math.ceil(await getArticleTotal() / 8)
  }
}
</script>
