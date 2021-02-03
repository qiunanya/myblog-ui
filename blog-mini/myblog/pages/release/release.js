// pages/release/release.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
        formData:{
            title: '标题',
            content: '',
            tag: '',
            photos:[],
            location: ''
        },
        imgList: [],
    },

    /**
     * @description 图片预览方法
     */
    handlePriviewImg(item){
        wx.previewImage({
            current: item.currentTarget.dataset.index, // 当前显示图片的http链接
            urls: this.data.imgList // 需要预览的图片http链接列表
        })
    },
    /**
     * @description  ShowActionSheet 弹窗
     */
    handleShowActionSheet(){
        let that = this
        wx.showActionSheet({
            itemList: ['相册', '拍照'],
            success (res) {
                console.log(res.tapIndex)
                // 建立临时数组，然后根据类型取值，拍照或者相册
                const type = ['album', 'camera']
                wx.chooseImage({
                    count: 9,
                    sizeType: ['original', 'compressed'],
                    sourceType: [type[res.tapIndex]],
                    success (res) {
                        // tempFilePath可以作为img标签的src属性显示图片
                        const tempFilePaths = res.tempFilePaths
                        tempFilePaths.forEach(e =>{
                            that.data.imgList.push(e)
                        })
                        that.setData({
                            'formData.photos': that.data.imgList
                        })
                        console.log(that.data.imgList, '临时图片路径')
                    }
                })
            },
            fail (res) {
              console.log(res.errMsg)
            }
          })
    },

    /**
     * @description 发布提交方法
     * @param {*} options 
     */
    handleSubmit(){
        console.log(this.data.formData)
    },
    updateValue(e){
        if (e.detail.detail.value) {
            this.setData({
                'formData.title': e.detail.detail.value
            })
        }else{
            wx.showToast({
                title: '标题不能为空！',
                icon: 'none'
            })
        }
        
    },
    updateArea(e){
        if (e.detail.detail.value) {
            this.setData({
                'formData.content': e.detail.detail.value
            })
        }else{
            wx.showToast({
                title: '内容不能为空！',
                icon: 'none'
            })
        }
    },
    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {

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

    },

    /**
     * 页面上拉触底事件的处理函数
     */
    onReachBottom: function () {

    },

    /**
     * 用户点击右上角分享
     */
    onShareAppMessage: function () {

    }
})