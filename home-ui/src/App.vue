<template>
  <div id="app">
    <router-view />
   <foot></foot>
  </div>
</template>
<script>
import Foot from '@components/layout/foot';
export default {
  name: 'app',
  components: {
    Foot
  }
}
</script>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}
</style>
