<template >
    <div class="contianer">
        <div class="wrapper">
            <div class="item item_1">移动鼠标到此处，动画产生</div>
            <Button type="success">鼠标移动动画</Button>
        </div>
        <div class="wrapper">
            <div class="item item_2">移动鼠标到此处，更换背景色</div>
            <Button type="success">更换背景色</Button>
        </div>
        <div class="wrapper">
            <div :class="['item','item_3',{'active':flag}]">增加高度，点击</div>
            <Button type="success" @click="test">点击测试高度</Button>
        </div>
        <div class="wrapper">
            <div :class="['item','item_4',{'active4': flag4}]">增加宽度，点击</div>
            <Button type="success" @click="test4">点击测试宽度</Button>
        </div>
    </div>
</template>
<script>
export default {
  name: 'w3c',
  components: {},
  data () {
    return {
      flag: false,
      flag4: false
    }
  },
  methods: {
    test () {
      this.flag = !this.flag
    },
    test4 () {
      this.flag4 = !this.flag4
    }
  },
  mounted () {

  }
}
</script>
<style lang="scss">
    $item2:#16a596;
    $item3: #9ddfd3;
    $item4: #14274e;
    $item5: #aa3a3a;
    .contianer{
        display: flex;
        .wrapper{
            margin-left: 15px;
            text-align: center;
            .item{
                width: 200px;
                height: 200px;
                background-color: #214252;
                padding: 50px 50px;
                cursor: pointer;
                color: #ffffff;
                &.item_1:hover,&.item_2:hover{
                    border-radius: 50%;
                    -webkit-transition: all 0.5s;
                    -o-transition: all 0.5s;
                    -moz-transition: all 0.5s;
                    transition: all 2s;
                }
                &.item_2{
                    background-color: $item2;
                    &.item_2:hover{
                        background-color: $item3;
                    }
                }
                &.item_3{
                    background-color: $item4;
                    transition: all 0.3s;
                }
                &.active{
                    height: 400px;
                }
                &.item_4{
                    background-color: $item5;
                    transition: all 2s;
                    &.active4{
                        width: 400px;
                    }
                }
            }
            button{
                margin-top: 15px;
            }
        }

    }
</style>
