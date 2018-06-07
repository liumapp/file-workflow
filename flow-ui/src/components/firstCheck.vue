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
  头像: <img :src="util.ajaxUrl + '/file/get?filename=' + data.headPic" width="200"><br>
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
      data: {}
    }
  },
  created () {
    this.data = this.formData;
  }
}
</script>
