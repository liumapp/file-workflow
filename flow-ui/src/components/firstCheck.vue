/**
 * @file firstCheck.vue
 * @author liumapp
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 6/7/18
 */
<template>
<div>
  用户名: {{ data.name }}<br>
  年龄: {{ data.age }} <br>
  头像: <img :src="picUrl" width="200"><br>
  <Button type="primary" @click="access()">通过</Button>
  <Button type="ghost" @click="refuse()">拒绝</Button>
</div>
</template>
<script>
import util from '@/libs/util';
export default {
  name: 'firstCheck',
  props: [
    'formData'
  ],
  data () {
    return {
      data: {},
      picUrl: ''
    }
  },
  created () {
    this.data = this.formData;
    this.picUrl = util.ajaxUrl + '/file/get?filename=' + this.data.headPic;
    console.log(this.picUrl);
  },
  methods: {
    access () {
      this.$emit('next');
    },
    refuse () {
      this.$emit('prev');
    }
  }
}
</script>
