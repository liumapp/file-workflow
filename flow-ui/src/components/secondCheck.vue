/**
 * @file secondCheck.vue
 * @author liumapp
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 6/7/18
 */
<template>
<div>
  this is secondCheck
  <br>
  <Button type="primary" @click="access()">通过</Button>
  <Button type="ghost" @click="refuse()">拒绝</Button>
</div>
</template>
<script>
export default {
  name: 'secondCheck',
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
