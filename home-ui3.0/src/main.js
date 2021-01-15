import { createApp } from 'vue'
import VueWechatTitle from 'vue-wechat-title'
import App from '~@/App.vue'
import router from '~@/router'
import store from '~@/store'

createApp(App).use(VueWechatTitle).use(store).use(router).mount('#app')
