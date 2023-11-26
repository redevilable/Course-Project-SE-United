<template>
  <div id="root-board">
    <BoardTitle :title="title" />

    <div class="data-board">

      <el-form :inline="true" class="demo-form-inline">
        <el-form-item label="">
          <el-select v-model="selectProjectId" placeholder="Select Project" @change="onSelectProjectChnage">
            <el-option
              v-for="item in selectProjects"
              :key="item.id"
              :label="item.name"
              :value="item.id"
            />
          </el-select>
        </el-form-item>
      </el-form>

      <el-table
        :data="sprints"
        :stripe="true"
        style="width: 100%"
        border
      >
        <el-table-column prop="id" align="center" width="200" label="Sprint ID" />
        <el-table-column prop="name" align="center" label="Name" />
        <el-table-column prop="desc" align="center" width="650" label="Description" />
        <el-table-column prop="creator" align="center" width="300" label="Creator" />
        <el-table-column prop="create_time" align="center" label="CreateTime" />
        <el-table-column label="操作" align="center">
          <template slot-scope="scope">
            <el-button class="op-button" type="primary" icon="el-icon-edit" @click="handleEdit(scope.row)" />
            <el-switch v-model="scope.row.enabled" class="op-button" @change="handleSwitch(scope.row)" />
            <el-button
              class="op-button"
              type="danger"
              icon="el-icon-delete"
              @click="handleDelete(scope.row)"
            />
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>

import BoardTitle from '@/components/Board/BoardTitle.vue'

export default {
  name: 'Sprint',
  components: {
    BoardTitle
  },
  data() {
    return {
      title: 'Sprint List',
      selectProjects: [],
      sprints: [],
      selectProjectId: ''
    }
  },
  created() {
    this.getSelectProject()
    this.getSprints()
  },
  methods: {
    onSelectProjectChnage(value) {
      console.info(value)
    },
    getSelectProject() {
      this.selectProjects = [
        { id: 1, name: 'project 1' },
        { id: 2, name: 'project 2' }
      ]
    },
    getSprints(projectId) {
      this.sprints = [
        {
          id: 1,
          project_id: 1,
          name: 'sprint 1',
          desc: 'sprint 1 desc',
          creator: 'mike',
          start_time: '2020-01-01 00:00:00',
          end_time: '2020-01-02 00:00:00',
          create_time: '2020-01-01 00:00:00'
        },
        {
          id: 2,
          project_id: 1,
          name: 'sprint 2',
          desc: 'sprint 2 desc',
          creator: 'amy',
          start_time: '2020-01-02 00:00:00',
          end_time: '2020-01-03 00:00:00',
          create_time: '2020-01-02 00:00:00'
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
