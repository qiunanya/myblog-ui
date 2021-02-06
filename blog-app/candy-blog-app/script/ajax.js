/**
 * @description 全局统一封装请求方式
 * @param {*} options 封装请求数据信息，包括参数，请求url，请求方式 
 */

// 默认请求超时时间s
let timeout = 15000
function request(method, url, data) {
	return new Promise((resolve, rejected) => {
		uni.showLoading({
			title:'加载中...'
		});
		uni.request({
			method: method,
			url: url,
			data: data,
			timeout: timeout,
			header: {
				'Accept': "*/*",
				'content-type': 'application/json;charset=utf-8',
				'token': "",//您可根据如本地存储或者vuex再此处使用逻辑或 来插入token
				'Authorization':'',//有的时候这里不一定是 token 还可能是 Authorization
			},
			success(res) {
				resolve(res)
				uni.hideLoading()
			},
			fail(err) {
				uni.showToast({
					title: '请求失败',
					icon: 'none',
					duration: 1500,
				})
				rejected(err)
				uni.hideLoading()
			}
		})
	})
}
function post(url,data) {
  return request('post',url,data)
}
function get(url,data) {
  return request('get',url,data)
}
function del(url,data) {
  return request('delete',url,data)
}
function put(url,data) {
  return request('put',url,data)
}

export default {
	post,
	get,
	del,
	put
}
