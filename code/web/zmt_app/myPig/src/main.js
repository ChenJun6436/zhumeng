// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'

import router from './router'
import Mint from 'mint-ui'
import 'mint-ui/lib/style.css'
import axios from 'axios'
import { Msg, Load } from './directive/directive'
import { DatetimePicker } from 'mint-ui';

Vue.component('picker', DatetimePicker);

Vue.use(Mint)


Vue.prototype.$msg = Msg
Vue.prototype.$load = Load
Vue.config.productionTip = true


/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App }
})
