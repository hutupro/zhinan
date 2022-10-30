<template>
    <div class="right-side">
        <div>
            <div class="xxx">
                <el-button size="small" round @click="createBtn">创建</el-button>
                <el-table :data="collections">
                    <el-table-column prop="name" label="名称" width="200"></el-table-column>
                    <el-table-column prop="info" label="描述" width="400"></el-table-column>
                    <el-table-column prop="weight" label="权重" width="100"></el-table-column>
                    <el-table-column
                            label="操作"
                            width="240">
                        <template slot-scope="scope">
                            <el-button @click.native.prevent="queryRow(collections[scope.$index])" type="text" size="small">
                                查看
                            </el-button>
                            <el-button @click.native.prevent="modifyBtn(collections[scope.$index])" type="text" size="small">
                                修改
                            </el-button>
                            <el-button @click.native.prevent="deleteRow(collections[scope.$index])" type="text" size="small">
                                删除
                            </el-button>
                        </template>
                    </el-table-column>
                </el-table>
            </div>

            <div>

                <el-dialog
                        :title="dialogName()"
                        :visible.sync="dialogVisible"
                        width="30%">
                    <div>
                        <el-form ref="collection" :model="collection" label-width="80px">
                            <el-form-item label="集合">
                                <el-input v-model="collection.name" :disabled="nameDisabled"></el-input>
                            </el-form-item>

                            <el-form-item label="描述">
                                <el-input type="textarea" v-model="collection.info" :disabled="inputDisabled"></el-input>
                            </el-form-item>
                            <el-form-item
                                    label="权重"
                                    prop="weight"
                                    :rules="[{ type: 'number', message:' '}]">
                                <el-input v-model.number="collection.weight" autocomplete="off" :disabled="inputDisabled"></el-input>
                            </el-form-item>
                        </el-form>
                    </div>
                    <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="save" v-if="operation !== 2">{{dialogName()}}</el-button>
  </span>
                </el-dialog>
            </div>

        </div>
    </div>
</template>

<script>
    import 'font-awesome/css/font-awesome.min.css'
    import axios from 'axios'

    export default {
        name: 'RightSide',
        props: {
            msg: String,
        },
        data() {
            return {
                collection: {
                    name: "",
                    info: "",
                    weight: 1
                },
                collections: [],
                dialogVisible: false,
                nameDisabled: false,
                inputDisabled:false,
                operation:1 // 1创建，2查看，3修改
            }
        },
        mounted: function () {
            let that = this;
            axios.get("/collection/all").then(function (response) {
                that.collections = response.data;
            })
        },
        methods: {
            createBtn: function () {
                this.dialogVisible = true;
                this.inputDisabled = false;
                this.nameDisabled = false;
                this.operation = 1
            },
            modifyBtn: function (row) {
                this.dialogVisible = true;
                this.inputDisabled = false;
                this.nameDisabled = true;
                this.collection = this.copy(row);
                this.operation = 3
            },
            save: function () {
                this.dialogVisible = false;
                let that = this;
                let collectionName = this.collection.name;
                axios.post("/collection/save", this.collection).then(function (response) {
                    if (response.data.code === 1) {
                        that.$notify({
                            title: '保存成功',
                            message: '集合' + collectionName + "保存成功",
                            type: 'success'
                        });
                        that.clearCollection();
                    } else {
                        that.$notify({
                            title: '保存失败',
                            message: '集合' + collectionName + "保存失败",
                            type: 'error'
                        });
                    }
                });
                this.inputDisabled = false;
                this.nameDisabled = false;
            },
            clearCollection: function() {
                this.collection = {
                    name: "",
                    info: "",
                    weight: 1
                }
            },
            copy: function (collection) {
                return {
                    name: collection.name,
                    info: collection.info,
                    weight: collection.weight,
                }
            },
            queryRow: function (row) {
                this.collection = JSON.parse(JSON.stringify(row));
                this.dialogVisible = true;
                this.inputDisabled = true;
                this.nameDisabled = true;
                this.operation = 2;
            },
            deleteRow: function (row) {
                console.log(row['name']);
                let that = this;
                let collectName = row['name'];
                axios.get("/collection/delete", {params: {name: collectName}}).then(function (response) {
                    if (response.data.code === 1) {
                        that.$notify({
                            title: '删除成功',
                            message: '集合' + collectName + "成功被删除",
                            type: 'success'
                        });
                    } else {
                        that.$notify({
                            title: '删除失败',
                            message: '集合' + collectName + "删除失败",
                            type: 'error'
                        });
                    }
                })
            },
            dialogName: function () {
                switch (this.operation) {
                    case 1: return '创建';
                    case 2: return '查看';
                    case 3: return '修改';
                    default: return '';
                }
            }
        }
    }
</script>

<style scoped>

</style>
