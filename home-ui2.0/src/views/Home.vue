<template>
    <div class="home_container">
        <div class="home_wap">
            <img src="@/assets/logo.png" alt='picture'/>
            <h2>WEB 前端  VUE CSS3.0 JS HTML5 技术</h2>
            <p class="author">制作人：前端实习生</p>
            <p class="author">当前日期:{{ dateFamtter }}</p>
        </div>
        <div class="condition">
            <div class="location">当前位置：</div>
            <div class="search"> 
                <Input v-model="search" search enter-button="Search" placeholder="请输入搜索内容" @on-search="searchContent"/>
            </div>
        </div>
        <div class="content">
            <div class="item" v-for="(item, index) in arrayList" :key="index">
                <img src="@/assets/logo.png" alt='picture'/>
                <div class="title">{{item.label}}</div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "Home",
    data() {
        return {
            search:'',
            dateFamtter: '',
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
    methods: {
        /**
         * @description 搜索
         */
        searchContent(value){
            let temp = [...this.arrayList]
            if (value !== "") {
                let result = this.arrayList.filter(e => e.label.match(value))
                if (result.length !== 0) {
                    this.arrayList = result
                }else {
                    this.arrayList = temp
                    this.$Message.error("暂无数据")
                }
            }else this.$Message.warning("请输入搜素内容")
        },
        /**
         * @description 获取当前时间
         */
        getCurrentDate () {
        const date = new Date();
        // 获取当天时间
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
        }
        this.dateFamtter = `${date.getFullYear()}年${date.getMonth()}月${date.getDate()}日 ${date.getHours()}:${date.getMinutes()}:${date.getSeconds()} ${xq}`;
        }
    },
    mounted() {
        setInterval(() => {
            this.getCurrentDate();
        }, 1000);
    }
};
</script>
<style lang="scss" src="./style.scss">
</style>
