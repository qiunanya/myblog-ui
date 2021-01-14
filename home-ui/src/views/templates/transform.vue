<template >
    <div class="container">
        <div class="container item_1">
            <h2>translate(10px,20px) 水平和垂直方向位移</h2>
            <div class="box"></div>
        </div>
        <div class="container item_2">
            <h2> scale(2,0.5) 横向放大，纵向缩小 scale(1.5):当横向和纵向都放大1.5倍</h2>
            <div class="box"></div>
        </div>
        <div class="container item_3">
            <h2> transition 过度动画</h2>
            <div class="box"></div>
        </div>
    </div>
</template>
<script>
export default {
  name: 'transform',
  components: {},
  data () {
    return {

    }
  },
  created () {

  },
  methods: {

  },
  mounted () {

  }
}
</script>
<style lang="scss">
    .container{
        margin-left: 200px;
        &.item_1{
            margin-bottom: 30px;
            .box{
                width: 100px;
                height: 100px;
                background-color: pink;
                -webkit-transform: translate(10px,20px);/**兼容谷歌和苹果 */
                -moz-transform: translate(10px,20px);/**兼容火狐 */
                -ms-transform: translate(10px,20px);/**兼容ie */
                -o-transform: translate(10px,20px);/**兼容欧鹏 */
                transform: translate(10px,20px);/**兼容w3c浏览器 */
            }
        }
        &.item_2{
            .box{
                width: 200px;
                height: 200px;
                background-color: red;
                // 横向放大，纵向缩小
                -webkit-transform: scale(2,0.5);/**兼容谷歌和苹果 */
                -moz-transform: scale(2,0.5);/**兼容火狐 */
                -ms-transform: scale(2,0.5);/**兼容ie */
                -o-transform: scale(2,0.5);/**兼容欧鹏 */
                transform: scale(2,0.5);/**兼容w3c浏览器 */
            }
        }
        &.item_3{
            .box{
                width: 200px;
                height: 200px;
                background-color: skyblue;

            }
        }

    }

</style>
