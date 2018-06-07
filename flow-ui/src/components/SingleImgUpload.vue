/**
 * @file SingleImgUpload.vue
 * @author liumapp
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 6/7/18
 */
<template>
  <Upload :action="url">
    <Button type="ghost" icon="ios-cloud-upload-outline">上传文件</Button>
  </Upload>
</template>
<script>
import util from '@/libs/util.js';
export default {
  name: 'single-img-upload',
  props: [
    'uploadUrl'
  ],
  data () {
    return {
      url: ''
    };
  },
  created () {
    this.url = this.uploadUrl;
  }

}
</script>
