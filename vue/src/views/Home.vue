<template>
  <div>
    <core-app-bar />

    <core-drawer />

    <v-content id="content">
      <div id="home">
        <articles />
      </div>
    </v-content>

    <core-footer />
  </div>
</template>

<script>
export default {
  name: 'Home',

  components: {
    Articles: () => import('../components/home/Articles'),
    CoreDrawer: () => import('../components/core/Drawer'),
    CoreFooter: () => import('../components/core/Footer'),
    CoreAppBar: () => import('../components/core/AppBar')
  }
}
</script>
