<template>
  <div>
    <h1>User List</h1>
    <el-table
      :data="tableData"
      stripe
      style="margin-left: 18vw; width: 80vw">
      <el-table-column
        prop="userId"
        label="ID"
        width="180">
      </el-table-column>
      <el-table-column
        prop="userName"
        label="用户名"
        width="180">
      </el-table-column>
      <el-table-column
        prop="userEmail"
        label="邮箱"
        width="180">
      </el-table-column>
      <el-table-column
        prop="userPassword"
        label="密码"
        width="180">
      </el-table-column>
      <el-table-column
        prop="userRegistrationDate"
        label="注册日期"
        width="180">
      </el-table-column>
      <el-table-column
        prop="userIp"
        label="IP"
        width="180">
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :page-sizes="[5, 10, 20]"
      :page-size="5"
      layout=" sizes, prev, pager, next, jumper"
      :total="12">
    </el-pagination>
  </div>
</template>

<script>
import { getUserList } from '../api/user'

export default {
  name: 'UserList',
  data () {
    return {
      tableData: []
    }
  },
  async mounted () {
    this.tableData = await getUserList()
  },
  watch: {
    tableData: function () {
      this.tableData.forEach(data => {
        const date = new Date(data.userRegistrationDate + 8 * 3600 * 1000) // 增加8小时
        data.userRegistrationDate = date.toJSON().substr(0, 19).replace('T', ' ')
      })
    }
  },
  methods: {
    async handleCurrentChange (val) {
      this.$store.commit('CALL_MESSAGE', { text: val })
      this.tableData = await getUserList(val, this.pageSize)
    },
    async handleSizeChange (val) {
      this.$store.commit('CALL_MESSAGE', { text: val })
      this.pageSize = val
      this.tableData = await getUserList(this.currentPage, this.pageSize)
    }
  }
}
</script>

<style scoped>

</style>
