<template>
  <div id="root-board">
    <BoardTitle :title="title"></BoardTitle>
  </div>
</template>

<script>

import BoardTitle from '@/components/Board/BoardTitle.vue'

export default {
  name: 'Overview',
  components: {
    BoardTitle
  },
  data() {
    return {
      title: 'Overview'
    }
  },
  methods: {
  }
}
</script>

<style scoped lang="scss">

</style>
