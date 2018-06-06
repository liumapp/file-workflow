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
        <Form :model="checkMsgForm" :rules="checkMsgRule">

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
    return {
      checkMsgForm: {
        name: '',
        sex: 1,
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
        ]
      }
    }
  },
  methods: {
    handleSubmit (name) {

    }
  }
}
</script>


