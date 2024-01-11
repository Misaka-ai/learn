<script setup>
import {ref,reactive} from "vue";

const tableData = ref([
  {
    "name": "Tom",
    "age": 20,
    "gender": 1,
    "score": 78
  },
  {
    "name": "Rose",
    "age": 18,
    "gender": 2,
    "score": 86
  },
  {
    "name": "Jerry",
    "age": 26,
    "gender": 1,
    "score": 90
  },
  {
    "name": "Tony",
    "age": 30,
    "gender": 1,
    "score": 52
  }
])
import HelloWorld from "../App.vue";

const removeItem = function (index) {
  tableData.value.splice(index, 1)
}
const currentPage4 = ref(4)
const pageSize4 = ref(100)
const small = ref(false)
const background = ref(false)
const disabled = ref(false)
const handleSizeChange = (number) => {
  console.log(`${val} items per page`)
}
const handleCurrentChange = (number) => {
  console.log(`current page: ${val}`)
}
const dialogVisible = ref(false)
const form = reactive({
  name: '',
  region: '',
  date1: '',
  date2: '',
  delivery: false,
  type: [],
  resource: '',
  desc: '',
})
</script>
<template>
  <h1>hello-world</h1>
  <el-row class="mb-4">
    <el-button>Default</el-button>
    <el-button type="primary">Primary</el-button>
    <el-button type="success">Success</el-button>
    <el-button type="info">Info</el-button>
    <el-button type="warning">Warning</el-button>
    <el-button type="danger">Danger</el-button>
  </el-row>

  <br>
  <el-table :data="tableData" style="width: 100%">
    <el-table-column label="Num" width="180">
      <template #default="scope">
        {{ scope.$index + 1 }}
      </template>
    </el-table-column>
    <el-table-column prop="name" label="Name" width="180"/>
    <el-table-column prop="age" label="Age" width="180"/>
    <el-table-column prop="gender" label="Gender" width="180">
      <template #default="scope">
        <span v-if=" scope.row.gender===1">男</span>
        <span v-if="scope.row.gender===2">女</span>
      </template>
    </el-table-column>
    <el-table-column prop="score" label="Score" width="180"/>
    <el-table-column prop="lv" label="LV" width="180">
      <template #default="scope">
        <span v-if=" scope.row.score<60">不及格</span>
        <span v-if="scope.row.score>=60&&scope.row.score<85">及格</span>
        <span v-if="scope.row.score>85">优秀</span>
      </template>
    </el-table-column>
    <el-table-column label="Opration" width="180">
      <template #default="scope">
        <el-button type="danger" @click="removeItem(scope.$index)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>

  <br>
  <el-pagination
      v-model:current-page="currentPage4"
      v-model:page-size="pageSize4"
      :page-sizes="[100, 200, 300, 400]"
      :small="small"
      :disabled="disabled"
      :background="background"
      layout="total, sizes, prev, pager, next, jumper"
      :total="400"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
  />

  <!--  对话框-->

{{ form}}}
  <el-form :model="form" label-width="120px">
    <el-form-item label="Activity name">
      <el-input v-model="form.name" />
    </el-form-item>
    <el-form-item label="Activity zone">
      <el-select v-model="form.region" placeholder="please select your zone">
        <el-option label="Zone one" value="shanghai" />
        <el-option label="Zone two" value="beijing" />
      </el-select>
    </el-form-item>
    <el-form-item label="Activity time">
      <el-col :span="11">
        <el-date-picker
            v-model="form.date1"
            type="date"
            placeholder="Pick a date"
            style="width: 100%"
        />
      </el-col>
      <el-col :span="2" class="text-center">
        <span class="text-gray-500">-</span>
      </el-col>
      <el-col :span="11">
        <el-time-picker
            v-model="form.date2"
            placeholder="Pick a time"
            style="width: 100%"
        />
      </el-col>
    </el-form-item>
    <el-form-item label="Instant delivery">
      <el-switch v-model="form.delivery" />
    </el-form-item>
    <el-form-item label="Activity type">
      <el-checkbox-group v-model="form.type">
        <el-checkbox label="Online activities" name="type" />
        <el-checkbox label="Promotion activities" name="type" />
        <el-checkbox label="Offline activities" name="type" />
        <el-checkbox label="Simple brand exposure" name="type" />
      </el-checkbox-group>
    </el-form-item>
    <el-form-item label="Resources">
      <el-radio-group v-model="form.resource">
        <el-radio label="Sponsor" />
        <el-radio label="Venue" />
      </el-radio-group>
    </el-form-item>
    <el-form-item label="Activity form">
      <el-input v-model="form.desc" type="textarea" />
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">Create</el-button>
      <el-button>Cancel</el-button>
    </el-form-item>
  </el-form>


</template>

<style scoped>

</style>