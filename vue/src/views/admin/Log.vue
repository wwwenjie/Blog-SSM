<template>
  <v-data-table
    :headers="headers"
    :items="logs"
    :options.sync="options"
    :server-items-length="totalLog"
    :loading="loading"
    class="elevation-1"
  />
</template>

<script>
import { getLogList, getLogTotal } from '../../api/log'

export default {
  name: 'Log',
  data () {
    return {
      logs: [],
      totalLog: undefined,
      headers: [
        {
          text: 'ID',
          align: 'start',
          value: 'id'
        },
        {
          text: '方法名',
          align: 'start',
          value: 'action'
        },
        {
          text: '详情',
          value: 'user'
        },
        {
          text: 'IP',
          value: 'ip'
        },
        {
          text: '日期',
          value: 'date'
        }
      ],
      loading: true,
      options: {}
    }
  },
  watch: {
    options: async function (options) {
      await this.getLogs(options)
    }
  },
  async mounted () {
    this.totalLog = await getLogTotal()
  },
  methods: {
    async getLogs (options) {
      this.loading = true
      this.logs = await getLogList(options.page, options.itemsPerPage)
      this.logs.forEach(log => {
        const date = new Date(log.date + 8 * 3600 * 1000)
        log.date = date.toJSON().substr(0, 19).replace('T', ' ')
      })
      this.loading = false
    }
  }
}
</script>

<style scoped>

</style>
