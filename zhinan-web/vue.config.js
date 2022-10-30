module.exports = {
  transpileDependencies: true,
  devServer: {
    onBeforeSetupMiddleware: require("./mock/mock.js")
  },
  pages: {
    index: {
      entry: 'src/main.js',
      filename: 'index.html'
    },
    admin: {
      entry: 'src/pages/admin/admin.js',
      template: 'src/pages/admin/admin.html',
      filename: 'admin.html'
    },
    'collect': {
      entry: 'src/pages/admin/collect/collect.js',
      template: 'src/pages/admin/collect/collect.html',
      filename: 'admin/collect/collect.html'
    }
  }
};
