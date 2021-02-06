// 注释将会特别详细，只有您有合理地耐心看完将不会出现问题
function request(method, url, data) {
	return new Promise((resolve, rejected) => {
		uni.showLoading({
			title:'加载中...'
		});
		uni.request({
			method: method,
			url: url,
			data: data,
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
function post(method,url,data) {
  return request(method,url,data)
}
function get(method,url,data) {
  return request(method,url,data)
}
function del(method,url,data) {
  return request(method,url,data)
}
function put(method,url,data) {
  return request(method,url,data)
}

export default {
	post,
	get,
	del,
	put
}
