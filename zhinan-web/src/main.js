import Vue from 'vue'
import App from './App.vue'
import Meta from 'vue-meta'

Vue.config.productionTip = false;
Vue.use(Meta);

new Vue({
  render: h => h(App),
  metaInfo() {
    return {
      meta: [
        {
          name: "referrer",
          content: "no-referrer"
        }
      ]
    }
  }
}).$mount('#app');
