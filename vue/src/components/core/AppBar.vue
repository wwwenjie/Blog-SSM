<template>
  <v-app-bar
    app
    flat
  >
    <v-app-bar-nav-icon
      class="hidden-md-and-up"
      @click="toggleDrawer"
    />

    <v-container class="mx-auto py-0">
      <v-row align="center">
        <h1
          class="mx-2"
          @click="clickHome"
        >
          Blog
        </h1>

        <!--        <v-btn-->
        <!--          v-for="(link, i) in links"-->
        <!--          :key="i"-->
        <!--          v-bind="link"-->
        <!--          class="hidden-sm-and-down"-->
        <!--          text-->
        <!--          @click="onClick($event, link)"-->
        <!--        >-->
        <!--          {{ link.text }}-->
        <!--        </v-btn>-->

        <v-spacer />

        <router-link
          :to="{ name: 'adminIndex' }"
          style="text-decoration: none"
        >
          <v-btn
            text
            class="hidden-sm-and-down"
          >
            Login
          </v-btn>
        </router-link>
      </v-row>
    </v-container>
  </v-app-bar>
</template>

<script>
// Utilities
import {
  mapMutations
} from 'vuex'

export default {
  name: 'CoreAppBar',

  methods: {
    ...mapMutations(['toggleDrawer']),
    onClick (e, item) {
      e.stopPropagation()

      if (item.to || !item.href) return

      this.$vuetify.goTo(item.href.endsWith('!') ? 0 : item.href)
    },
    clickHome () {
      this.$vuetify.goTo(0)
      this.$router.push({ name: 'home' })
    }
  }
}
</script>
