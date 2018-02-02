// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import axios from 'axios'
//import { Msg} from './msg'

import {msg} from './server/directive'

Vue.use(ElementUI)
Vue.prototype.$ajax = axios
// Vue.prototype.$msg = Msg
Vue.config.productionTip = false

Vue.prototype.$msg = msg

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App }
})
