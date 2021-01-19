<template>
  <div id="app">
    <el-container style="height: 100%; border: 1px solid #eee" >


      <el-aside class="el-aside" width="0%" >
        <el-menu router :default-openeds="['0', '1']" >
          <el-submenu v-for="(item,index) in $router.options.routes" :index="index+''" v-if="item.show">
            <template slot="title">{{item.name}}</template>
            <el-menu-item v-for="(item2,index2) in item.children" :index="item2.path"
                          :class="$route.path==item2.path?'is-active':''">{{item2.name}}</el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>

      <el-container style="width: 100%;">
        <el-header style="text-align: center; font-size: 30px; background-color: dodgerblue">
          <span>test系统模板</span>

        </el-header>

        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>
<style>
.el-aside {
  background-color: rgb(238, 241, 246);
}

</style>

<script>
export default {
  data() {
    const item = {
      date: '2016-05-02',
      name: '王小虎',
      address: '上海市普陀区金沙江路 1518 弄'
    }
    return {
      tableData: Array(20).fill(item)
    }
  }
}
</script>
