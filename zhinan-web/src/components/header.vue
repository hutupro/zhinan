<template>
  <div class="header">
    <div class="logo-bg">
      <div class="logo">
        知识索引
      </div>
    </div>

  </div>
</template>

<script>
export default {
  name: 'HeaderPage',
  props: {
    msg: String
  }
}
</script>

<style scoped>
  .header {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    z-index: 2;
    height: 51px;
    background: #17191a repeat-x 0 0;
    box-shadow: 0 1px 2px rgb(0 0 0 / 35%);
  }

  .logo {
    float: left;
    position: relative;
    margin: 11px 0 0 18px;
  }
</style>
