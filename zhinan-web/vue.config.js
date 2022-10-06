module.exports = {
  transpileDependencies: true,
  devServer: {
    onBeforeSetupMiddleware: require("./mock/mock.js")
  }
};
