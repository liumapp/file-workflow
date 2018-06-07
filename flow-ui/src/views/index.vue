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
        <Form ref="checkMsgForm" :model="checkMsgForm" :rules="checkMsgRule">
          <FormItem label="用户名" prop="name">
            <Input type="text" v-model="checkMsgForm.name"></Input>
          </FormItem>
          <FormItem label="年龄" prop="age">
            <Input type="text" v-model="checkMsgForm.age" number></Input>
          </FormItem>
          <FormItem label="头像" prop="headPic">
            <single-img-upload id="head-pic-upload"
                               :uploadUrl="uploadUrl"
                               @imgInfo="handlePic" ></single-img-upload>
          </FormItem>
          <FormItem>
            <Button type="primary" @click="handleSubmit('checkMsgForm')">Submit</Button>
            <Button type="ghost" @click="handleReset('checkMsgForm')">Reset</Button>
          </FormItem>
        </Form>
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
      const validateAge = (rule, value, callback) => {
        if (!value) {
          return callback(new Error('Age cannot be empty'));
        }
        // 模拟异步验证效果
        setTimeout(() => {
          if (!Number.isInteger(value)) {
            callback(new Error('Please enter a numeric value'));
          } else {
            if (value < 18) {
              callback(new Error('Must be over 18 years of age'));
            } else {
              callback();
            }
          }
        }, 1000);
      };

      return {
        uploadUrl: util.ajaxUrl + 'file/',
        checkMsgForm: {
          name: '用户名称呢',
          age: 22,
          headPic: ''
        },
        checkMsgRule: {
          name: [
            {
              type: 'string',
              min: 5,
              max: 10,
              message: 'the username size shall be no more than 10 chars and no less than 5 chars ',
              trigger: 'blur'
            }
          ],
          age: [
            {
              validator: validateAge,
              trigger: 'blur'
            }
          ]
        },
        current: 0
      }
    },
    methods: {
      handleSubmit (name) {
        this.$refs[name].validate((valid) => {
          if (valid) {
            util.post('/info', this.checkMsgForm).then(res => {
              this.current++;
              this.$Message.success('Success!');
            });
          } else {
            this.$Message.error('Fail!');
          }
        });
      },
      handleReset (name) {
        this.$refs[name].resetFields();
      },
      handlePic (file) {
        this.headPic=file.name;
      }
    },
    created () {
      console.log(this.uploadUrl);
    }
  }
</script>


