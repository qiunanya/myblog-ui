<template >
  <div>
    <div>
      <Button type="success" @click="tabComponent('Asset')">资产页面</Button>
      <Button type="warning" @click="tabComponent('Approval')">审批页面</Button>
    </div>
    <div>
      <component :is="currentPanl"></component>
    </div>
  </div>
</template>
<script>
import Approval from '~@components/approval';
import Asset from '~@components/asset';
export default {
  name: 'w3c',
  components: {
    Approval,
    Asset
  },
  data () {
    return {
      currentPanl: 'Asset'
    };
  },
  created () {},
  methods: {
    tabComponent (item) {
      this.currentPanl = item;
    }
  },
  mounted () {}
};
</script>
