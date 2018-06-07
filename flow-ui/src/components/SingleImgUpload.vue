/**
 * @file SingleImgUpload.vue
 * @author liumapp
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 6/7/18
 */
<template>
  <Upload :action="url"
    :on-success="handleSuccess"
    :before-upload="handleBeforeUpload">
    <Button type="ghost" icon="ios-cloud-upload-outline">上传文件</Button>
  </Upload>
</template>
<script>
import util from '@/libs/util.js';
export default {
  name: 'SingleImgUpload',
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
  },
  methods: {
    handleSuccess (response, file) {
      this.$Message.success('上传成功!');
      this.$emit('imgInfo', file);
    },
    handleBeforeUpload (file) {
      const format = file.type === 'image/jpeg' || file.type === 'image/png';
      const size = file.size / 1024 / 1024 < 2;

      if (!format) {
        this.$Message.error('上传头像图片只能是 JPG/PNG 格式!')
      }
      if (!size) {
        this.$Message.error('上传头像图片大小不能超过 2MB!')
      }
      return format && size;
    }
  }

}
</script>
