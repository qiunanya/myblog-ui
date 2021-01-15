import { createApp } from 'vue'
import VueWechatTitle from 'vue-wechat-title'
import App from '~@/App.vue'
import router from '~@/router'
import store from '~@/store'

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
const app = createApp(App)

app.use(ElementUI)
app.use(VueWechatTitle)
app.use(store)
app.use(router)
app.mount('#app')
// createApp(App).use(ElementUI).use(VueWechatTitle).use(store).use(router).mount('#app')
