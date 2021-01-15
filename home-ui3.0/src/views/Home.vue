<template>
  <div class="home">
    <img alt="Vue logo" src="~@/assets/logo.png">
    {{book.title}}
    {{person}}
  </div>
</template>

<script>
import { ref, isRef, reactive, onMounted, onUpdated, onUnmounted } from 'vue'
export default {
  setup (props, context) {
    // 引用实例,这里放置data数据，生命周期，自定义函数等
    context.attrs
    context.slots
    context.parent
    context.root
    context.emit
    const readersNumber = ref(0)
    const book = reactive({ title: 'Vue 3 Guide' })
    const person = reactive([{name:'qiuiqu',age:5541},{name:"meiemi",age:24}])
    console.log(person);
    return {
      readersNumber,
      book,
      person
    }
    // eslint-disable-next-line no-unreachable
    onMounted(() => {
      console.log('mounted!')
    })
    // eslint-disable-next-line no-unreachable
    onUpdated(() => {
      console.log('updated!')
    })
    // eslint-disable-next-line no-unreachable
    onUnmounted(() => {
      console.log('unmounted!')
    })
  }
}
</script>
