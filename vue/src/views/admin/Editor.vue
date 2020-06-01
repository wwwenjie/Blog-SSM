<template>
  <div>
    <v-text-field
      v-model="article.articleTitle"
      label="博客标题"
      class="d-inline-block"
      style="width: 250px;"
    />
    <v-text-field
      v-model="article.articleCategory"
      label="博客分类"
      class="d-inline-block mx-12"
      style="width: 250px;"
    />
    <v-btn
      color="primary"
      @click="save"
    >
      保存
    </v-btn>
    <editor
      v-model="article.articleContent"
      api-key="no-api-key"
      :init="{
        height: 700,
        menubar: true,
        plugins: [
          'advlist autolink lists link image charmap print preview anchor',
          'searchreplace visualblocks code fullscreen',
          'insertdatetime media table paste code help wordcount'
        ],
        toolbar:
          'undo redo | formatselect | bold italic backcolor | \
           alignleft aligncenter alignright alignjustify | \
           bullist numlist outdent indent | removeformat | help'
      }"
    />
  </div>
</template>

<script>
import Editor from '@tinymce/tinymce-vue'
import { creatArticle, getArticle, updateArticle } from '../../api/article'
import Message from '../../util/message'
export default {
  name: 'Editor',
  components: { editor: Editor },
  data () {
    return {
      createMode: true,
      article: {
        articleTitle: undefined,
        articleContent: undefined,
        articleCategory: undefined,
        // 后端通过 token 识别新建博客的 uid，编辑博客将获取 uid 赋值
        userId: undefined
      }
    }
  },
  async mounted () {
    const id = this.$route.query.id
    Message.default(id ? `编辑博客：${id}` : '新建博客')
    if (id) {
      this.article = await getArticle(id)
    }
  },
  methods: {
    async save () {
      if (this.$route.query.id) {
        await updateArticle(this.article)
      } else {
        await creatArticle(this.article)
      }
      Message.success()
    }
  }
}
</script>

<style scoped>

</style>
