<template >
    <div class="wrapper">
       <div class="list">
           <img src="https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3456198419,871692454&fm=15&gp=0.jpg" alt="" >
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
   .list{
        width: 260px;
        height: 195px;
        overflow: hidden;
        img{
            transition: all 0.5s;
            &:hover{
                transform: scale(1.5);
            }
        }
   }
}
</style>
