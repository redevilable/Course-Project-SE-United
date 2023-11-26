<template>
  <div id="root-board">
    <BoardTitle :title="title"></BoardTitle>

    <div class="data-board">

      <el-form :inline="true" class="demo-form-inline">
        <el-form-item label="">
          <el-cascader
            v-model="selectedOption"
            :options="selectOptions"
            placeholder="Please Select..."
            @change="handleCascaderChange" />
        </el-form-item>
      </el-form>

      <el-table
        :data="userStories"
        :stripe="true"
        style="width: 100%"
        border
      >
        <el-table-column prop="id" align="center" width="200" label="Story ID"></el-table-column>
        <el-table-column prop="name" align="center" label="Name"></el-table-column>
        <el-table-column prop="desc" align="center" width="650" label="Description"></el-table-column>
        <el-table-column prop="priority" align="center" width="150" label="Priority"></el-table-column>
        <el-table-column prop="status" align="center" width="150" label="Status"></el-table-column>
        <el-table-column prop="creator" align="center" width="200" label="Creator"></el-table-column>
        <el-table-column prop="start_time" align="center" label="StartTime"></el-table-column>
        <el-table-column prop="end_time" align="center" label="EndTime"></el-table-column>
        <el-table-column prop="create_time" align="center" label="CreateTime"></el-table-column>
        <el-table-column label="操作" align="center">
          <template slot-scope="scope">
            <el-button class="op-button" type="primary" icon="el-icon-edit" @click="handleEdit(scope.row)"></el-button>
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
import user from '@/store/modules/user';

export default {
  name: 'UserStory',
  computed: {
    user() {
      return user
    }
  },
  components: {
    BoardTitle
  },
  data() {
    return {
      title: 'UserStory List',
      selectOptions: [],
      selectedOption: '',
      userStories: []
    }
  },
  created() {
    this.getSelectOptions()
    this.getUserStrories()
  },
  methods: {
    handleCascaderChange(value) {
      console.info(value)
    },
    getSelectOptions() {
      this.selectOptions = [
        {
          value: 1,
          label: 'project 1',
          children: [
            {
              value: 1,
              label: 'sprint 1'
            },
            {
              value: 2,
              label: 'sprint 2'
            }
          ]
        },
        {
          value: 2,
          label: 'project 2',
          children: [
            {
              value: 1,
              label: 'sprint 3'
            },
            {
              value: 2,
              label: 'sprint 4'
            }
          ]
        }
      ]
    },
    getUserStrories() {
      this.userStories = [
        {
          id: 1,
          sprint_id: 1,
          name: 'story 1',
          desc: 'desc 1',
          priority: 1,
          status: 0,
          start_time: '2020-01-01 00:00:00',
          end_time: '2020-01-02 00:00:00',
          creator: 'mike',
          executor: 'mike',
          create_time: '2020-01-01 00:00:00'
        },
        {
          id: 2,
          sprint_id: 2,
          name: 'story 2',
          desc: 'desc 2',
          priority: 2,
          status: 1,
          start_time: '2020-01-01 00:00:00',
          end_time: '2020-01-02 00:00:00',
          creator: 'mike',
          executor: 'amy',
          create_time: '2020-01-01 00:00:00'
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
