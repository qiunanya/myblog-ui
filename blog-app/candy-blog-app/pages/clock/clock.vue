<template>
    <view class="clock_container">
        <view class="page-body">
            <view class="page-section page-section-gap">
                <map style="width: 100%; height: 300px;" enable-traffic :enable-3D="support" :scale="scale" :latitude="latitude" :longitude="longitude" :markers="covers" :controls="controls">
                </map>
            </view>
        </view>
		
		<view class="current_location_form">
			<u-form :model="form" ref="uForm" label-width="150">
				<u-form-item label="当前位置:">
					<u-input v-model="form.locationZh" type="textarea" border height="100" auto-height :clearable="false"/>
				</u-form-item>
				<!-- <u-button type="success" @tap="changeAddress">重新选择地址</u-button> -->
			</u-form>
		</view>
		<text class="iconfont iconcamera"></text>
    </view>
</template>

<script>
	export default{
		data() {
			return {
				form:{
					locationZh: '暂无数据'
				},
				id:0, // 使用 marker点击事件 需要填写id
				title: 'map',
				latitude: 39.909, // 纬度
				longitude: 116.39742, // 经度
				covers: [{
					latitude: 39.909,
					longitude: 116.39742,
					iconPath: '../../static/map/location.png',
					alpha: 0.5,
					rotate: 1, // 旋转度
					title: '默认定位北京'
					// callout:{
					// 	content: '默认定位北京',
					// 	color: '#ffffff',
					// 	fontSize: 12,
					// 	borderRadius: 4,
					// 	bgColor:'#16a596',
					// 	padding: 2,
					// 	textAlign: 'left',
					// 	display: 'ALWAYS'
					// }
				}],
				scale: 18, //缩放级别，取值范围为3-20
				support: true, // 是否显示3D楼块
				controls:[{//在地图上显示控件，控件不随着地图移动
					id:111,//控件id
					iconPath:'../../static/map/avatar.png',//显示的图标   
					position:{//控件在地图的位置
					 left:0,
					 top:0,
					 width:60,
					 height:60,
					},
					clickable:true
				}]
			}
		},
		methods: {
			// 选择地址
			changeAddress(){
				let this_ = this
				// 选择位置
				uni.chooseLocation({
				    success: function (res) {
				        // console.log('位置名称：' + res.name);
				        // console.log('详细地址：' + res.address);
				        // console.log('纬度：' + res.latitude);
				        // console.log('经度：' + res.longitude);
						this_.longitude = res.longitude
						this_.latitude = res.latitude
						let obj = {
							latitude: res.latitude,
							longitude: res.longitude,
							iconPath: '../../static/map/location.png',
							alpha: 0.5,
							title: res.address
						}
						this_.$set(this_.covers, 0, obj)
						this_.form.locationZh = res.address
				    }
				});
			}
		},
		// 监听右上角按钮
		onNavigationBarButtonTap(e){
			this.changeAddress()
		},
		onShow() {
			let this_ = this
			uni.showLoading({
			    title: '正在努力获取当前位置...'
			})
			// 获取当前位置
			uni.getLocation({
			    type: 'gcj02',
				geocode: true,
			    success: function (res) {
					this_.longitude = res.longitude
					this_.latitude = res.latitude
					let obj = {
						latitude: res.latitude,
						longitude: res.longitude,
						iconPath: '../../static/map/location.png',
						alpha: 0.5,
						title: `${res.address.city}${res.address.district}${res.address.street}${res.address.streetNum}号${res.address.poiName}(${res.address.cityCode})`
					}
					this_.covers[0] = obj
					this_.form.locationZh = `${res.address.country}${res.address.province}${res.address.city}${res.address.district}${res.address.street}${res.address.streetNum}号${res.address.poiName}-城市编号(${res.address.cityCode})`
			        // console.log('当前位置的经度：' + res.longitude, this_.longitude);
			        // console.log('当前位置的纬度：' + res.latitude,this_.latitude);
					uni.hideLoading();
			    }
			});
		}
	}
</script>
<style lang="scss">
	.clock_container{
		.current_location_form{
			padding: 0 15rpx;
		}
	}
</style>
