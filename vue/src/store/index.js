import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    messageConfig: {
      isShow: false,
      text: '',
      timeout: 1500
    }
  },
  mutations: {
    CALL_MESSAGE (state, config) {
      for (const [key, value] of Object.entries(config)) {
        state.messageConfig.isShow = true
        state.messageConfig[key] = value
      }
    }
  },
  actions: {
  },
  modules: {
  }
})
