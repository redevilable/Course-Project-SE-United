<template>
  <div id="board-title">
    <span>{{ title }}</span>
  </div>
</template>

<script>

export default {
  name: 'BoardTitle',
  props: {
    title: {
      type: String,
      default: 'Board Title'
    }
  },
  data() {
    return {
    }
  },
  methods: {
  }
}

</script>

<style scoped lang="scss">

#board-title {
  margin-top: 30px;
  margin-left: 30px;
  margin-bottom: 80px;

  span {
    font-size: 20pt;
    font-weight: bold;
  }
}

</style>
