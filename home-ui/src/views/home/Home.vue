<template>
  <div class="wrapper">
    <div class="home_wap">
      <img src="@/assets/logo.png" alt srcset />
      <h2>WEB 前端 CSS3.0 JS HTML5 技术</h2>
      <p class="author">制作人：前端实习生 (人无信不立)</p>
      <p class="author">当前日期：{{ dateFamtter }}</p>
    </div>
    <div class="content">
      <div class="item_left">
        <Menu accordion @on-select="getItem">
          <Submenu
            :name="item.path"
            v-for="(item, index) in menuList"
            :key="index"
          >
            <template slot="title">
              <Icon :type="item.meta.icon" />
              {{ item.meta.title }}
            </template>
            <MenuItem :name="e.path" v-for="(e, i) in item.children" :key="i">{{
              e.meta.title
            }}</MenuItem>
          </Submenu>
        </Menu>
      </div>
      <div class="item_right">
        <router-view></router-view>
      </div>
    </div>
  </div>
</template>

<script>
import { add } from '@script/index';
export default {
  name: 'Home',
  data () {
    return {
      menuList: [],
      dateFamtter: ''
    };
  },
  methods: {
    /**
     * @description 路由选择
     * @param path 路由地址
     */
    getItem (path) {
      this.$router.push(path);
      console.log(path);
    },
    /**
     * @description 获取当前时间
     */
    getCurrentDate () {
      const date = new Date();
      // 获取年
      console.log(date.getFullYear(), '年');
      // 获取月
      console.log(date.getMonth(), '月');
      // 获取日
      console.log(date.getDate(), '日');
      // 获取时分秒
      console.log(
        date.getHours(),
        date.getMinutes(),
        date.getSeconds(),
        '时间'
      );
      // 获取当天时间
      console.log(date.getDay(), '当天时间');
      let xq = '';
      switch (date.getDay()) {
        case 1:
          xq = '星期一';
          break;
        case 2:
          xq = '星期二';
          break;
        case 3:
          xq = '星期三';
          break;
        case 4:
          xq = '星期四';
          break;
        case 5:
          xq = '星期五';
          break;
        case 0:
          xq = '星期天';
          break;
        case 6:
          xq = '星期六';
          break;
        default:
          break;
      }
      this.dateFamtter = `${date.getFullYear()}年${date.getMonth()}月${date.getDate()}日 ${date.getHours()}:${date.getMinutes()}:${date.getSeconds()} ${xq}`;
    },
    /**
     * @description 数字排序
     */
    sortArray (arr) {
      for (let j = 0; j < arr.length; j++) {
        for (let i = j + 1; i < arr.length; i++) {
          if (arr[j] > arr[i]) {
            const temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
          }
        }
      }
    },
    /**
     * @description arguments 参数方式
     */
    sums (num1, num2, ...args) {
      let total = num1 + num2;
      for (let i = 0; i < arguments.length; i++) {
        total += arguments[i];
      }
      console.log(
        '--------------------------argumentsc 存放所有参数，不是数组却可以用数组方式调用-------------------'
      );
      console.log(arguments, 'arguments存放所有参数');

      console.log(args, 'args存放多余的参数');

      console.log(total, 'arguments 参数方式');
    }
  },
  created () {
    console.log('created1');
  },
  mounted () {
    console.log(add(14, -5), '外部引用js的求和函数');
    this.menuList = this.$router.options.routes;
    setInterval(() => {
      this.getCurrentDate();
    }, 1000);
  },
  beforeCreate () {
    console.log('beforeCreate');
  },
  beforeMount () {
    console.log('beforeMount');
    this.sums(1, 2, 88, 55, 12);
  },
  beforeUpdate () {
    console.log('beforeUpdate');
  },
  beforeDestroy () {
    console.log('beforeDestroy');
  },
  destroyed () {
    console.log('destroyed');
  }
};
</script>
<style lang="scss" src="./style.scss">
</style>
