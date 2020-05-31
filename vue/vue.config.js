module.exports = {
  outputDir: '../src/main/webapp',
  devServer: {
    proxy: 'http://localhost:8000/'
  },
  transpileDependencies: ['vuetify']
}
