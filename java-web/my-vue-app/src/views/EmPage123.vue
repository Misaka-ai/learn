<script setup>
import {reactive, ref, onMounted} from 'vue'
import axios from "axios";
const tableData = ref([]);


onMounted(() => {
  axios.get("https://mock.apifox.com/m1/2893111-0-default/depts").then((res) => {
    alert(res.data)
    tableData.value = res.data
  })
})
const value2 = ref('')
const onSubmit = () => {
  console.log('submit!')
}
const formInline = reactive({
  deptName: '',
  updateTime: '',
})
// const tableData = reactive([
//   {
//     id:"1",
//     deptName:"教研部",
//     updateTime:"2022-07-22 11:23:00",
//
//
//   },
//   {
//     id:"1",
//     deptName:"教研部",
//     updateTime:"2022-07-22 11:23:00",
//   },
//   {
//     id:"1",
//     deptName:"教研部",
//     updateTime:"2022-07-22 11:23:00",
//   },
//   {
//     id:"1",
//     deptName:"教研部",
//     updateTime:"2022-07-22 11:23:00",
//   },
//   {
//     id:"1",
//     deptName:"教研部",
//     updateTime:"2022-07-22 11:23:00",
//   },
//   {
//     id:"1",
//     deptName:"教研部",
//     updateTime:"2022-07-22 11:23:00",
//   },
//   {
//     id:"1",
//     deptName:"教研部",
//     updateTime:"2022-07-22 11:23:00",
//   },
// ])
const currentPage4 = ref(4)
const pageSize4 = ref(100)
const small = ref(false)
const background = ref(false)
const disabled = ref(false)

// 添加删除功能
const removeItem = function (index) {
  tableData.value.splice(index, 1)
}
</script>
<template>
  <div class="common-layout">
    <el-container>
      <el-header><h2>tlias智能学习辅助系统</h2></el-header>
      <el-container>
        <el-aside width="200px">
          <el-scrollbar>
            <el-menu :default-openeds="['1', '3']">
              <el-sub-menu index="1">
                <template #title>
                  <el-icon>
                    <message/>
                  </el-icon>
                  <h3>班级学生管理</h3>
                </template>
                <el-menu-item-group>
                  <template #title></template>
                  <el-menu-item index="1-1">班级管理</el-menu-item>
                  <el-menu-item index="1-2">学生管理</el-menu-item>
                </el-menu-item-group>
              </el-sub-menu>
              <el-sub-menu index="2">
                <template #title>
                  <el-icon>
                    <Menu/>
                  </el-icon>
                  <h3>系统信息管理</h3>
                </template>
                <el-menu-item-group>
                  <template #title></template>
                  <el-menu-item index="2-1">
                    <router-link to="/dept">部门管理</router-link>
                  </el-menu-item>
                  <el-menu-item index="2-2">
                    <router-link to="/emp">员工管理</router-link>
                  </el-menu-item>
                </el-menu-item-group>
              </el-sub-menu>
              <el-sub-menu index="3">
                <template #title>
                  <el-icon>
                    <setting/>
                  </el-icon>
                  <h3>数据统计管理</h3>
                </template>
                <el-menu-item-group>
                  <template #title></template>
                  <el-menu-item index="3-1">员工信息统计</el-menu-item>

                </el-menu-item-group>
              </el-sub-menu>
            </el-menu>
          </el-scrollbar>
        </el-aside>
        <el-main>
          <!--表单-->
          <el-form :inline="true" :model="formInline" class="demo-form-inline">
            <el-form-item label="姓名">
              <el-input v-model="formInline.user" placeholder="请输入姓名" clearable/>
            </el-form-item>
            <el-form-item label="性别">
              <el-select
                  v-model="formInline.sex"
                  placeholder="请选择性别"
                  clearable
              >
                <el-option label="男" value="1"/>
                <el-option label="女" value="2"/>
              </el-select>
            </el-form-item>
            <el-form-item :model="formInline.date" label="入职时间">
              <!--日期选择器-->
              <el-date-picker
                  v-model="value2"
                  type="datetimerange"
                  start-placeholder="开始时间"
                  end-placeholder="结束时间"
                  format="YYYY-MM-DD HH:mm:ss"
                  date-format="YYYY/MM/DD ddd"
                  time-format="A hh:mm:ss"
              />
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="onSubmit">查询</el-button>
            </el-form-item>
          </el-form>

          <el-button type="success">+新增员工</el-button>
          <el-button type="success">-批量删除</el-button>
          <!--表格-->
          <el-table
              ref="multipleTableRef"
              :data="tableData"
              style="width: 100%"
              @selection-change="handleSelectionChange"
          >
            <el-table-column type="selection" width="55"/>
            <el-table-column property="id" label="序号" width="120">
              <template #default="scope">
                {{ scope.$index + 1 }}
              </template>
            </el-table-column>
            <el-table-column property="deptName" label="部门" show-overflow-tooltip/>
            <el-table-column property="updateTime" label="最后操作时间" show-overflow-tooltip/>
            <el-table-column label="操作" width="180">
              <template #default="scope">
                <el-button style="color: red" type="text" @click="removeItem(scope.$index)">删除</el-button>
                <el-button type="text" @click="addItem(scope.$index)">添加</el-button>
              </template>
            </el-table-column>

          </el-table>
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
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>
<style>

</style>