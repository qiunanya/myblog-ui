// pages/home/home.js
// getApp获取APP()产生的示例对象
const app = getApp()
// 导入自定义工具js
const utils = require("../../utils/util.js");
let { name, age } = app.globalData
console.log('全局属性', name, age);
import request from '../../requests/network.js'
Page({
  /**
   * 页面的初始数据
   */
    data: {
        background: ['/assets/home/map1.png', '/assets/home/map2.png', '/assets/home/map.png'],
        indicatorDots: true,
        vertical: false,
        autoplay: true,
        interval: 2000,
        duration: 500,
        userInfo:{}
    },
    options: {
        addGlobalClass: true
    },
    /**
     * @description 点击获取用户权限
     * @param {@} options 
     */
    handleGetUserInfos (event) {
        this.setData({
            userInfo: event.detail.userInfo
        })
        // 缓存用户信息
        try {
            wx.setStorageSync('userInfo', event.detail.userInfo)
        } catch (e) { 
            console.log(e)
        }
        console.log(event, 88888);
     },
    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        try {
            var user = wx.getStorageSync('userInfo')
            if (user) {
               console.log(user)
               this.setData({
                   userInfo: user
               })
            }
        } catch (e) {
            console.log(e)
        }
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
    console.log('下拉刷新')
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
    console.log('页面到底部，可以用于上拉加载更多')
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
     return{
         title: '物灵鸿图',
         path: "/pages/category/category",
         imageUrl:'/assets/tabbar/category.png'
     }
  },
   /**
    * @description 分享朋友圈
    */
	onShareTimeline() {
        return {
            title: '物灵鸿图',
            path: '/pages/home/home.wxml',
            imageUrl: '/assets/tabbar/category_active.png' //可以本地也可以线上
        }
    }    
})