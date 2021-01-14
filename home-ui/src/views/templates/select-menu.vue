<template >
    <div>
        <h3>浮动下拉选择表单</h3>
        <div class="menu_list">
            <div class="tip" @click="showModel">
                <p>{{value ? value:'请选择'}}</p>
                <Icon type="ios-arrow-down" />
            </div>
            <Button type="success" @click="clear">清除已选值</Button>
            <div :class="['list-menu',{'active': show }]">
                <ul>
                    <li :class="['item',{'selected':index == i}]" v-for="(item,i) in list" :key="item.id" @click="getItem(item,i)"> {{ item.title }} </li>
                </ul>
            </div>
        </div>
    </div>
</template>
<script>
export default {
  name: 'select-menu',
  components: {},
  data () {
    return {
      value: '',
      show: false,
      index: -1,
      list: [
        {
          id: 1,
          title: '张三',
          rightDetail: '2019-03-18',
          detail: 'XXXXXXXXXXXXXXXXXXX公司',
          slide_x: 0
        },
        {
          id: 2,
          surname: '李',
          title: '李二牛',
          rightDetail: '2019-03-17',
          detail: 'XXXXXXXXXXXXXXXXXXX公司',
          slide_x: 0
        },
        {
          id: 3,
          surname: '李',
          title: '斯洛克',
          rightDetail: '2019-03-17',
          detail: 'XXXXXXXXXXXXXXXXXXX公司',
          slide_x: 0
        }
      ]
    }
  },
  created () {

  },
  methods: {
    getItem (item, i) {
      this.index = i
      console.log(item, 6666)
      this.value = item.title
      this.show = !this.show
    },
    showModel () {
      this.show = !this.show
      console.log(this.show, 6666)
    },
    clear () {
      this.value = ''
    }
  },
  mounted () {

  }
}
</script>
<style lang="scss">
   .menu_list{
       margin-top: 30px;
       position: relative;
       .tip{
            display: flex;
            align-items: center;
            cursor: pointer;
            border: 1px solid #bbbbbb;
            border-radius: 6px;
            padding: 0 12px;
            &:hover{
                border: 1px solid #16a596;
                box-shadow: 1px 5px 10px #16a596;
            }
        }
       button{
           position: absolute;
           top: -4px;
           left: 132px;
       }
       .list-menu{
            border-radius: 6px;
            background-color: #3F536E;
            color: #FFFFFF;
            text-align: center;
            position: absolute;
            overflow: hidden;
            height: 0;
            width: 20vw;
            top: 19px;
            left: 0;
            transition: 0.5s;
            .item{
                padding: 3px 0;
                cursor: pointer;
            }
            .selected{
                color: skyblue;
            }
            &.active{
                height: 100px;
            }
        }
   }
</style>
