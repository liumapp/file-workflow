/**
 * @file uploadForm.vue
 * @author liumapp
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 6/7/18
 */
<template>
  <Form ref="checkMsgForm" :model="checkMsgForm" :rules="checkMsgRule">
    <FormItem label="用户名" prop="name">
      <Input type="text" v-model="checkMsgForm.name"></Input>
    </FormItem>
    <FormItem label="年龄" prop="age">
      <Input type="text" v-model="checkMsgForm.age" number></Input>
    </FormItem>
    <FormItem label="头像" prop="headPic">
      <SingleImgUpload id="head-pic-upload"
                         :uploadUrl="uploadUrl"
                         @imgInfo="handlePic" ></SingleImgUpload>
    </FormItem>
    <FormItem>
      <Button type="primary" @click="handleSubmit('checkMsgForm')">Submit</Button>
      <Button type="ghost" @click="handleReset('checkMsgForm')">Reset</Button>
    </FormItem>
  </Form>
</template>
<script>
import util from '@/libs/util';
import SingleImgUpload from '@/components/SingleImgUpload';
export default {
  name: 'uploadForm',
  components: {
    SingleImgUpload
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
      }, 200);
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
      }
    }
  },
  methods: {
    handleSubmit (name) {
      this.$refs[name].validate((valid) => {
        if (valid) {
          util.post('/info', this.checkMsgForm).then(res => {
            this.$Message.success('Success!');
            this.$emit('setFormData', this.checkMsgForm);
            this.$emit('next');
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
      this.checkMsgForm.headPic=file.name;
    }
  }
}
</script>
