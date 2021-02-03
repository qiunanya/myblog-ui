<template>
	<view class="content">
		<image class="logo" src="/static/logo.png"></image>
		<view class="text-area">
			<text class="title">{{title}}</text>
			<text class="iconfont iconcamera"></text>
		</view>
		<u-button >默认按钮</u-button>
		<u-button type="primary">主要按钮</u-button>
		<u-button type="success">成功按钮</u-button>
		<u-button type="info">信息按钮</u-button>
		<u-button type="warning">警告按钮</u-button>
		<u-button type="error" @tap="showToast">危险按钮</u-button>
		<u-toast ref="uToast" />
		<view class="">
			<u-modal v-model="show" show-cancel-button :content="content" @confirm="confirm" ref="uModal" ></u-modal>
			<u-button @click="showModal">弹起Modal</u-button>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				title: 'Hello',
				show: false,
				content: '我是确认框内容'
			}
		},
		onLoad() {

		},
		methods: {
			showToast() {
				this.$refs.uToast.show({
					title: '登录成功',
					type: 'success',
					url: '/pages/user/index'
				})
			},
			showModal() {
				this.show = true;
			},
			confirm() {
				console.log('用户点击了确定按钮')
				setTimeout(() => {
					// 3秒后自动关闭
					this.show = false;
					// 如果不想关闭，而单是清除loading状态，需要通过ref手动调用方法
					// this.$refs.uModal.clearLoading();
				}, 3000)
			}
		}
	}
</script>

<style>
	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}

	.logo {
		height: 200rpx;
		width: 200rpx;
		margin-top: 200rpx;
		margin-left: auto;
		margin-right: auto;
		margin-bottom: 50rpx;
	}

	.text-area {
		display: flex;
		justify-content: center;
	}

	.title {
		font-size: 36rpx;
		color: #8f8f94;
	}
</style>
