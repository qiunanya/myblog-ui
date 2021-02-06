import Vue from 'vue'
import App from './App'
import uView from "uview-ui";
//  引入vuex
import store from 'store/store.js'
// 引入api
import api from 'script/api.js'
// 引入ajax请求方式
import ajax from 'script/ajax.js'

Vue.use(uView);
// 把vuex定义成全局组件
Vue.prototype.$store = store
// api 全局挂载
Vue.prototype.$api = api
// 挂载全局ajax
Vue.prototype.$ajax = ajax

Vue.config.productionTip = false

App.mpType = 'app'

const app = new Vue({
    ...App,
	// 挂栽vuex
	store,
	api,
	ajax
})
app.$mount()
