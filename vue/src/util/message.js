import store from '../store'

export default class Message {
  // function for setting more params
  // show,text,closeText,type,timeout
  static call (config) {
    if (config.show === undefined) {
      config.show = true
    }
    store.commit('setSnackCon', config)
  }

  static default (text = 'Default Text') {
    this.call({ text: text })
  }

  static success (text = 'Success') {
    this.call({
      text: text,
      confirmText: '好的',
      declineText: undefined,
      callbackConfirm: function () {},
      type: 'success',
      timeout: 1500
    })
  }

  static error (text = 'Error') {
    this.call({
      text: text,
      confirmText: '好的',
      callbackConfirm: function () {},
      declineText: undefined,
      type: 'error',
      timeout: 1500
    })
  }
}
