<template>
  <div id="root-board">
    <BoardTitle :title="title"></BoardTitle>

    <div class="data-board">
      <el-table
        :data="products"
        :stripe="true"
        style="width: 100%"
        border
      >
        <el-table-column prop="id" align="center" width="200" label="Project ID"></el-table-column>
        <el-table-column prop="name" align="center" label="Name"></el-table-column>
        <el-table-column prop="desc" align="center" width="650" label="Description"></el-table-column>
        <el-table-column prop="creator" align="center" width="300" label="Creator"></el-table-column>
        <el-table-column prop="create_time" align="center" label="CreateTime"></el-table-column>
        <el-table-column label="操作" align="center">
          <template slot-scope="scope">
            <el-button class="op-button" type="primary" icon="el-icon-edit" @click="handleEdit(scope.row)"></el-button>
            <el-switch class="op-button" v-model="scope.row.enabled" @change="handleSwitch(scope.row)"></el-switch>
            <el-button
              class="op-button"
              type="danger"
              icon="el-icon-delete"
              @click="handleDelete(scope.row)">
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>

import BoardTitle from '@/components/Board/BoardTitle.vue'

export default {
  name: 'Product',
  components: {
    BoardTitle
  },
  data() {
    return {
      title: 'Product List',
      products: []
    }
  },
  created() {
    this.getProducts()
  },
  methods: {
    getProducts() {
      this.products = [
        {
          id: 1,
          name: 'product 1',
          desc: 'product 1 desc',
          creator: 'admin',
          enabled: true,
          create_time: '2020-01-01 00:00:00',
        },
        {
          id: 2,
          name: 'product 2',
          desc: 'product 2 desc',
          creator: 'admin',
          enabled: true,
          create_time: '2020-01-02 00:00:00',
        },
        {
          id: 3,
          name: 'product 3',
          desc: 'product 3 desc',
          creator: 'admin',
          enabled: false,
          create_time: '2020-01-03 00:00:00',
        },
        {
          id: 4,
          name: 'product 4',
          desc: 'product 4 desc',
          creator: 'mike',
          enabled: false,
          create_time: '2020-01-03 00:00:00',
        }
      ]
    }
  }
}
</script>

<style scoped lang="scss">
.data-board {
  margin-left: 30px;
}

.op-button {
  margin-left: 30px;
}
</style>
