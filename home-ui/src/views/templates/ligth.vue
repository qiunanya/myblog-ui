<template >
    <div class="wrapper">
      <div class="horse">
            <span style="font-family: Arial, Helvetica, sans-serif;">CSS3</span>
            <span style="font-family: Arial, Helvetica, sans-serif;">实现的跑马灯效果</span>
      </div>
    </div>
</template>
<script>
export default {
  name: 'w3c',
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
<style lang="scss" scoped>
.wrapper{
    width:200px;
    height:50px;
    margin: 100px auto;
    padding: 10px;
    font-size: 20px;
    border: solid 1px black;
    position: relative;
    overflow: hidden;
    .horse{
        position: absolute;
        width:200px;
        -webkit-animation:horse 3s linear 0s infinite;
    }
    @-webkit-keyframes horse
    {
        0%   {left:0px;top:0px;background-color: #16a596;}
        47%  {left:220px;top:0px;}
        48%  {left:220px;top:100px;}
        49%  {left:-200px;top:100px;}
        50%  {left:-200px;top:0px;background-color:  #aa3a3a;}
        100% {left:0px;top:0px;background-color: yellow;}
    }

}
</style>
