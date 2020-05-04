<template>
  <div
    v-show="messageConfig.isShow"
    class="global-message"
  >
    <div class="global-message-warp">
      {{ messageConfig.text }}
    </div>
  </div>
</template>

<script>
export default {
  name: 'Message',
  props: {
    messageConfig: {
      type: Object,
      // the default value is set at store snackCon
      default: () => ({
        isShow: false,
        text: '',
        timeout: 1500
      })
    }
  },
  watch: {
    messageConfig: {
      deep: true,
      handler () {
        if (this.messageConfig.isShow) {
          setTimeout(() => {
            this.$store.commit('CALL_MESSAGE', { isShow: false })
          }, this.messageConfig.timeout)
        }
      }
    }
  }
}
</script>

<style lang="sass">
$background-color:rgba(4, 112, 217)
.global-message
  position: fixed
  display: flex
  align-items: center
  justify-content: center
  width: 100%
  height: 32px
  top: 5vh
  z-index: 1

  &-warp
    padding: 10px 20px
    border: $background-color solid 2px
    border-radius: 5px
    color: white
    background-color: $background-color
</style>
