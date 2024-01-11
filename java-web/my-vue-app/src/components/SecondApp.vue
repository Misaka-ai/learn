<script setup>
import {ref, reactive} from "vue";

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
//删除所点击的行的方法
const removeItem = function (index) {
  tableData.value.splice(index, 1)
}
//设置对话框的可见性，默认为false
const dialogVisible = ref(false)
const addData = function () {
  tableData.value.push(formItem.value)
  dialogVisible.value = false
  formItem.value={

  }
}
const formItem = ref({
  "name": "",
  "age": undefined,
  "gender": undefined,
  "score": undefined
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
  <!-- 设置表-->
  <el-table :data="tableData" style="width: 100%">
    //
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
    <el-table-column label="Opration">
      <template #default="scope">
        <el-button type="danger" @click="removeItem(scope.$index)">删除</el-button>
      </template>
    </el-table-column>
    <el-table-column label="Update" >
      <template #default="scope">
        <!--  根据索引更新      -->
          <el-dialog
            v-model="dialogVisible"
            title="Tips"
            width="70%">
          <el-form :model="formItem" label-width="120px">
            <el-form-item label="姓名">
              <el-input v-model="formItem.name"/>
            </el-form-item>
            <el-form-item label="年龄">
              <el-input v-model="formItem.age"/>
            </el-form-item>
            <el-form-item label="性别">
              <el-input v-model="formItem.gender"/>
            </el-form-item>
            <el-form-item label="分数">
              <el-input v-model="formItem.score"/>
            </el-form-item>
          </el-form>
          <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="updata(scope.$index)">
          提交
        </el-button>
      </span>
          </template>
        </el-dialog>



      </template>
    </el-table-column>
  </el-table>
  <br>


  <!--1.通过dialog-->
  <el-button text @click="dialogVisible = true">
    添加
  </el-button>
<!--添加对话框-->
  <el-dialog
      v-model="dialogVisible"
      title="Tips"
      width="70%">
    <el-form :model="formItem" label-width="120px">
      <el-form-item label="姓名">
        <el-input v-model="formItem.name"/>
      </el-form-item>
      <el-form-item label="年龄">
        <el-input v-model="formItem.age"/>
      </el-form-item>
      <el-form-item label="性别">
        <el-input v-model="formItem.gender"/>
      </el-form-item>
      <el-form-item label="分数">
        <el-input v-model="formItem.score"/>
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="addData">
          提交
        </el-button>
      </span>
    </template>
  </el-dialog>
<!-- 修改对话框-->

</template>

<style scoped>

</style>