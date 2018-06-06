<template>
<div>
  <Row>
    <Col span="18" offset="3">
      <Card>
        <Steps :current="2">
          <Step title="已完成" content="这里是该步骤的描述信息"></Step>
          <Step title="进行中" content="这里是该步骤的描述信息"></Step>
          <Step title="待进行" content="这里是该步骤的描述信息"></Step>
          <Step title="待进行" content="这里是该步骤的描述信息"></Step>
        </Steps>
        <Form ref="checkMsgForm" :model="checkMsgForm" :rules="checkMsgRule">
          <FormItem label="用户名" prop="name">
            <Input type="text" v-model="checkMsgForm.name"></Input>
          </FormItem>
          <FormItem label="年龄" prop="age">
            <Input type="text" v-model="checkMsgForm.age" number></Input>
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
export default {
  name: 'HelloWorld',
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
      checkMsgForm: {
        name: '用户名称',
        age: 22,
        headPic: ''
      },
      checkMsgRule: {
        name: [
          {
            required: true,
            message: 'please fill in the user name',
            trigger: true
          },
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
    }
  },
  methods: {
    handleSubmit (name) {
      this.$refs[name].validate((valid) => {
        if (valid) {
          this.$Message.success('Success!');
        } else {
          this.$Message.error('Fail!');
        }
      });
    },
    handleReset (name) {
      this.$refs[name].resetFields();
    }
  }
}
</script>


