import Vue from 'vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import Admin from './admin.vue'

Vue.use(ElementUI);

new Vue({
    render: h => h(Admin)
}).$mount('#app');