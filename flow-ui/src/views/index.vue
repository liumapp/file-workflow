/**
 * @file index.vue
 * @author liumapp
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 6/7/18
 */
<template>
  <div>
    <Row>
      <Col span="18" offset="3">
        <Card>
          <Steps :current="current">
            <Step title="提交基础信息" content="上传基础用户信息"></Step>
            <Step title="初核" content="审核基础信息"></Step>
            <Step title="复审" content="复审基础信息"></Step>
            <Step title="审核结果" content="展示审核结果"></Step>
          </Steps>
          <upload-form v-if="current == 0" @setFormData="setFormData" @next="nextStep"></upload-form>
          <first-check v-if="current == 1" @next="nextStep" :formData="formData"></first-check>
          <second-check v-if="current == 2" @next="nextStep"></second-check>
          <result v-if="current == 3" @next="nextStep"></result>
        </Card>
      </Col>
    </Row>
  </div>
</template>
<script>
  import util from '@/libs/util';
  import SingleImgUpload from '@/components/SingleImgUpload';
  import uploadForm from '@/components/uploadForm';
  import firstCheck from '@/components/firstCheck';
  import secondCheck from '@/components/secondCheck';
  import result from '@/components/result';
  export default {
    name: 'HelloWorld',
    components: {
      uploadForm,firstCheck,secondCheck,result,SingleImgUpload
    },
    data () {
      return {
        current: 0,
        formData: {}
      }
    },
    methods: {
      setFormData (data) {
        this.formData = data;
      },
      nextStep () {
        this.current++;
      },
      prevStep () {
        this.current--;
      }
    }
  }
</script>


