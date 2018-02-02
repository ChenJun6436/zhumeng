// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
// import ElementUI from 'element-ui'
import App from './App'
// import 'element-ui/lib/theme-chalk/index.css'
import router from './router'
import axios from 'axios'
import 'babel-polyfill'

// Vue.use(ElementUI)

Vue.prototype.$ajax = axios
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  render: h => h(App)
})



// WEBPACK FOOTER //
// ./src/main.js