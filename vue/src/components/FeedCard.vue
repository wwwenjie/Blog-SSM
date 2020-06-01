<template>
  <v-col
    cols="12"
    :md="size === 2 ? 6 : size === 3 ? 4 : undefined"
  >
    <base-card
      :height="value.prominent ? 450 : 350"
      color="grey lighten-1"
      dark
      @click="onClick(value.articleId)"
    >
      <v-img
        height="100%"
        gradient="rgba(0, 0, 0, .42), rgba(0, 0, 0, .42)"
        src="https://cdn.vuetifyjs.com/images/cards/docks.jpg"
      >
        <v-row
          v-if="!value.prominent"
          class="fill-height text-right ma-0"
        >
          <v-col cols="12">
            <v-chip
              label
              class="mx-0 mb-2 text-uppercase"
              color="grey darken-3"
              text-color="white"
              small
              @click.stop=""
            >
              {{ value.articleCategory }}
            </v-chip>

            <h3 class="title font-weight-bold mb-2">
              {{ value.articleTitle }}
            </h3>

            <div class="caption">
              {{ new Date(value.articleLastModifyDate + 8 * 3600 * 1000).toJSON().substr(0, 19).replace('T', ' ') }}
            </div>
          </v-col>

          <v-col align-self="end">
            <v-chip
              class="text-uppercase ma-0"
              color="primary"
              label
              small
              @click.stop=""
            >
              更多
            </v-chip>
          </v-col>
        </v-row>
      </v-img>
    </base-card>
  </v-col>
</template>

<script>
export default {
  name: 'FeedCard',

  props: {
    size: {
      type: Number,
      required: true
    },
    value: {
      type: Object,
      default: () => ({})
    }
  },
  methods: {
    onClick (id) {
      this.$router.push({ name: 'article', params: { id: id } })
    }
  }
}
</script>

<style>
.v-image__image {
  transition: .3s linear;
}
</style>
