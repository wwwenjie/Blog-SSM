import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    snackCon: {
      show: undefined,
      text: 'Default Text',
      type: 'info',
      confirmText: 'Okay',
      declineText: 'No',
      callbackConfirm: () => {},
      callbackDecline: () => {},
      timeout: 0
    },
    drawer: false
  },
  getters: {
  },
  mutations: {
    setDrawer: (state, payload) => (state.drawer = payload),
    toggleDrawer: state => (state.drawer = !state.drawer),
    setSnackCon: (state, payload) => (state.snackCon = payload)
  },
  actions: {
  }
})
