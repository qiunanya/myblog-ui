import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
	state:{
		username: '邱南亚'
	},
    getters:{
		GET_USERNAME(state){
			return state.username
		}
	},
	mutations:{
		// 测试store, 重置用户名
		SET_USERNAME(state, username){
			state.username = username
			// 放入缓存
			uni.setStorageSync('username', username)
		}
	},
	actions:{},
})

// 这种方式到处数据不用加 {}
export default store