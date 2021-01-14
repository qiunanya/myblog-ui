<template >
    <div class="array_action">
       <h3>JavaScript的 Array 对象是用于构造数组的全局对象，数组是类似于列表的高阶对象。</h3>
       <Collapse v-model="value1">
            <Panel :name="String(index+1)" v-for="(item, index) in arrayList" :key="index">
                {{item.label}}
                <p slot="content">{{item.describe}}</p>
            </Panel>
        </Collapse>
    </div>
</template>
<script>
export default {
  name: 'array_action',
  components: {},
  data () {
    return {
      value1: '1',
      arrayList: [
        { label: 'Array.length', describe: 'length 是Array的实例属性。返回或设置一个数组中的元素个数。该值是一个无符号 32-bit 整数，并且总是大于数组最高项的下标。' },
        { label: 'Array.from(arrayLike[, mapFn[, thisArg]])', describe: ' 从一个类似数组或可迭代对象创建一个新的，浅拷贝的数组实例' },
        { label: 'Array.isArray(obj)', describe: '用于确定传递的值是否是一个 Array。' },
        { label: 'Array.of(element0[, element1[, ...[, elementN]]])', describe: '创建一个具有可变数量参数的新数组实例，而不考虑参数的数量或类型。Array.of(1, 2, 3);' },
        { label: 'Array.prototype.concat(value1[, value2[, ...[, valueN]]])', describe: '用于合并两个或多个数组。此方法不会更改现有数组，而是返回一个新数组。const array3 = array1.concat(array2);' },
        { label: 'Array.prototype.copyWithin(target[, start[, end]])', describe: '浅复制数组的一部分到同一数组中的另一个位置，并返回它，不会改变原数组的长度。array1.copyWithin(0, 3, 4)' },
        { label: 'Array.prototype.entries()', describe: '返回一个新的Array Iterator对象，该对象包含数组中每个索引的键/值对。const iterator1 = array1.entries()' },
        { label: 'Array.prototype.every(callback(element[, index[, array]])[, thisArg])', describe: '测试一个数组内的所有元素是否都能通过某个指定函数的测试。它返回一个布尔array1.every(函数表达式), 注意：若收到一个空数组，此方法在一切情况下都会返回 true。' },
        { label: 'Array.prototype.fill(value[, start[, end]])', describe: '用一个固定值填充一个数组中从起始索引到终止索引内的全部元素。不包括终止索引。arr.fill(value[, start[, end]])' },
        { label: 'Array.prototype.filter(callback(element[, index[, array]])[, thisArg])', describe: '创建一个新数组, 其包含通过所提供函数实现的测试的所有元素。' },
        { label: 'Array.prototype.find(callback[, thisArg])', describe: '返回数组中满足提供的测试函数的第一个元素的值。否则返回 undefined。' },
        { label: 'Array.prototype.findIndex(callback[, thisArg])', describe: '返回数组中满足提供的测试函数的第一个元素的索引。若没有找到对应元素则返回-1' },
        { label: 'Array.prototype.flat([depth])', describe: '会按照一个可指定的深度递归遍历数组，并将所有元素与遍历到的子数组中的元素合并为一个新数组返回。' },
        { label: 'Array.prototype.flatMap(function callback(currentValue[, index[, array]]) {// return element for new_array}[, thisArg])', describe: '首先使用映射函数映射每个元素，然后将结果压缩成一个新数组。它与 map 连着深度值为1的 flat 几乎相同，但 flatMap 通常在合并成一种方法的效率稍微高一些。' },
        { label: 'Array.prototype.forEach()', describe: '对数组的每个元素执行一次给定的函数。' },
        { label: 'Array.prototype.includes(valueToFind[, fromIndex])', describe: '方法用来判断一个数组是否包含一个指定的值，根据情况，如果包含则返回 true，否则返回false。' },
        { label: 'Array.prototype.indexOf(searchElement[, fromIndex])', describe: '返回在数组中可以找到一个给定元素的第一个索引，如果不存在，则返回-1' },
        { label: 'Array.prototype.join([separator])', describe: '将一个数组（或一个类数组对象）的所有元素连接成一个字符串并返回这个字符串。如果数组只有一个项目，那么将返回该项目而不使用分隔符。' },
        { label: 'Array.prototype.keys()', describe: '返回一个包含数组中每个索引键的Array Iterator对象。' },
        { label: 'Array.prototype.lastIndexOf()', describe: '返回指定元素（也即有效的 JavaScript 值或变量）在数组中的最后一个的索引，如果不存在则返回 -1。从数组的后面向前查找，从 fromIndex 处开始' },
        { label: 'Array.prototype.map()', describe: '创建一个新数组，其结果是该数组中的每个元素是调用一次提供的函数后的返回值。' },
        { label: 'Array.prototype.pop()', describe: '从数组中删除最后一个元素，并返回该元素的值。此方法更改数组的长度' },
        { label: 'Array.prototype.push()', describe: '将一个或多个元素添加到数组的末尾，并返回该数组的新长度。' },
        { label: 'Array.prototype.reduce(callback(accumulator, currentValue[, index[, array]])[, initialValue])', describe: '对数组中的每个元素执行一个由您提供的reducer函数(升序执行)，将其结果汇总为单个返回值。' },
        { label: 'Array.prototype.reduceRight()', describe: '接受一个函数作为累加器（accumulator）和数组的每个值（从右到左）将其减少为单个值。' },
        { label: 'Array.prototype.reverse()', describe: '将数组中元素的位置颠倒，并返回该数组。数组的第一个元素会变成最后一个，数组的最后一个元素变成第一个。该方法会改变原数组。' },
        { label: 'Array.prototype.shift()', describe: '从数组中删除第一个元素，并返回该元素的值。此方法更改数组的长度。' },
        { label: 'Array.prototype.slice([begin[, end]])', describe: '返回一个新的数组对象，这一对象是一个由 begin 和 end 决定的原数组的浅拷贝（包括 begin，不包括end）。原始数组不会被改变。' },
        { label: 'Array.prototype.some(callback(element[, index[, array]])[, thisArg])', describe: '测试数组中是不是至少有1个元素通过了被提供的函数测试。它返回的是一个Boolean类型的值。' },
        { label: 'Array.prototype.sort()', describe: '用原地算法对数组的元素进行排序，并返回数组。默认排序顺序是在将元素转换为字符串，然后比较它们的UTF-16代码单元值序列时构建的' },
        { label: 'Array.prototype.splice(start[, deleteCount[, item1[, item2[, ...]]]])', describe: '通过删除或替换现有元素或者原地添加新的元素来修改数组,并以数组形式返回被修改的内容。此方法会改变原数组。' },
        { label: 'Array.prototype.toLocaleString()', describe: ' 返回一个字符串表示数组中的元素。数组中的元素将使用各自的 toLocaleString 方法转成字符串，这些字符串将使用一个特定语言环境的字符串（例如一个逗号 ","）隔开。' },
        { label: 'Array.prototype.toSource()', describe: '返回一个字符串,代表该数组的源代码.' },
        { label: 'Array.prototype.toString()', describe: '返回一个字符串，表示指定的数组及其元素。' },
        { label: 'Array.prototype.unshift()', describe: '将一个或多个元素添加到数组的开头，并返回该数组的新长度(该方法修改原有数组)' },
        { label: 'Array.prototype.values()', describe: '返回一个新的 Array Iterator 对象，该对象包含数组每个索引的值' },
        { label: 'Array.prototype[@@iterator]()', describe: '属性和 Array.prototype.values() 属性的初始值是同一个函数对象。' },
        { label: 'get Array[@@species]', describe: ' 访问器属性返回 Array 的构造函数。' }
      ]
    }
  },
  created () {
  },
  methods: {
    /**
       * @descrition 数组操作测试方法
       */
    arrayTest () {
      // const arr = [1, 2, 3],
      const arr = ['李四', 'wangwu', '张三', '冬儿']
      const findArray2 = [5, 12, 8, 130, 44];
      //  [arr, ...findArray2]这种合并数组方式，第一个数组会被当成新数组的第一个元素，第二个数组当成新数组的其余元素
      const arrayLists = [arr, ...findArray2]
      //  arr.push.apply(arr,findArray2)这种合并数组方式，返回的是数组长度
      const list = arr.push.apply(arr, findArray2)
      console.log('合并arr和findArray2数组为一个数组const arrayLists = [arr, ...findArray2]', arrayLists);
      console.log('合并arr和findArray2数组为一个数组const list = arr.push.apply(arr,findArray2)', list, 666);

      // Array.length 数组长度
      console.log(' Array.length 判断数组长度', this.arrayList.length);
      // Array.from() 将 对象new Set(), new Map() 转换为对象
      const set = new Set()
      set.add('set对象')
      set.add(2222)
      console.warn('set对象---->', set);
      const map = new Map()
      map.set(1, 'map 对象')
      map.set(2, '777777')
      map.set(3, 66666)
      console.warn('map 字典对象---->', map);
      console.log('map通过get(key)获得值----->', map.get(2));
      console.log('map通过delete(key)删除值----->', map.delete(2), map);
      console.log('map--->', map);
      console.log(Array.from('李 四'), Array.from(arr, x => x + 'add'));
      console.log('Array.from() 把set集合变成数组---->', Array.from(set));
      console.log('Array.from() 把map集合变成数组---->', Array.from(map));
      // Array.isArray() 判断是否是数组，是返回true，否返回false
      console.log('Array.isArray()判断是否是数组', Array.isArray(arr));
      // Array.of()创建一个具有可变数量参数的新数组实例，而不考虑参数的数量或类型
      console.log('Array.of(7, 78, 898) 创建数字数组---》', Array.of(7, 78, 898));
      console.log('Array.of("李小龙", "叶问", "诸葛亮") 创建字符串数组---》', Array.of('李小龙', '叶问', '诸葛亮'));
      // Array.prototype.concat() 合并两个数组
      console.log('Array.prototype.concat(value1[, value2[, ...[, valueN]]) 合并set和map两个数组', Array.from(set).concat(Array.from(map)));
      console.log('Array.prototype.concat(value1[, value2[, ...[, valueN]]) 合并set，arr和map三个个数组', Array.from(set).concat(Array.from(map), ...arr));
      // Array.prototype.copyWithin()方法浅复制数组的一部分到同一数组中的另一个位置，并返回它，不会改变原数组的长度。
      console.log('Array.prototype.copyWithin(target[, start[, end])', arr.copyWithin(0, 1, 3));
      // Array.prototype.entries()
      const iterator = arr.entries()
      console.log('Array.prototype.entries()返回数组中每个索引的键/值对', iterator.next().value)
      console.log('Array.prototype.entries()返回数组中每个索引的键/值对', iterator.next().value)
      // Array.prototype.every()
      const isBelowThreshold = (currentValue) => currentValue < 40;
      const array1 = [1, 30, 39, 29, 10, 13];
      console.log('Array.prototype.every()方法测试一个数组内的所有元素是否都能通过某个指定函数的测试', array1.every(isBelowThreshold));
      // Array.prototype.fill()方法用一个固定值填充一个数组中从起始索引到终止索引内的全部元素。不包括终止索引。
      console.log('Array.prototype.fill(value[, start[, end])方法用一个固定值填充一个数组中从起始索引到终止索引内的全部元素。不包括终止索引', arr.fill('我是fill填充的值', 2, 3));
      // Array.prototype.filter()创建一个新数组, 其包含通过所提供函数实现的测试的所有元素。
      const words = ['spray', 'limit', 'elite', 'exuberant', 'destruction', 'present'];
      const result = words.filter((element, index, words) => {
        console.log('filter遍历数组索引----》', element, index, words);
        if (element.length > 6) {
          return element
        }
      });
      console.log('Array.prototype.filter()创建一个新数组, 其包含通过所提供函数实现的测试的所有元素。', result);
      // Array.prototype.find()
      const findArray = [5, 12, 8, 130, 44];
      const result2 = findArray.find(element => element > 120)
      const one = findArray.find(el => {
        if (el > 120) {
          return el
        }
      })
      console.log('Array.prototype.find(callback[, thisArg])返回数组中满足提供的测试函数的第一个元素的值。否则返回 undefined', result2, one);
      console.log('Array.prototype.findIndex(callback[, thisArg])返回数组中满足提供的测试函数的第一个元素的索引。若没有找到对应元素则返回-1。', array1.findIndex(isBelowThreshold));
      // Array.prototype.forEach() 遍历循环数组
      console.log('Array.prototype.forEach(callback[, thisArg])');
      arrayLists.forEach(e => {
        console.log(e);
      })
    }
  },
  mounted () {
    this.arrayTest()
  }
}
</script>
<style lang="scss" >
    .array_action{
        background-color:#558e77;
        border-radius: 8px;
        color: #ffffff;
        padding: 8px;
        .array_item{
            display: flex;
            padding: 10px 0px;
            font-size: 15px;
            .title{
                font-weight: bolder;
            }
        }
    }
</style>
