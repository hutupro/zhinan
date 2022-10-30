<template>
    <div class="right-side">
        <div>
            <div class="xxx">
                <el-button size="small" round @click="createBtn">创建</el-button>
                <el-table :data="records">
                    <el-table-column prop="title" label="标题" width="200"></el-table-column>
                    <el-table-column prop="link" label="链接" width="200"></el-table-column>
                    <el-table-column prop="info" label="描述" width="400"></el-table-column>
                    <el-table-column prop="weight" label="权重" width="100"></el-table-column>
                    <el-table-column prop="collection" label="集合" width="200"></el-table-column>
                    <el-table-column prop="category" label="分类" width="200"></el-table-column>
                    <el-table-column prop="tag" label="标签" width="200"></el-table-column>
                    <el-table-column
                            label="操作"
                            width="240">
                        <template slot-scope="scope">
                            <el-button @click.native.prevent="queryRow(records[scope.$index])" type="text" size="small">
                                查看
                            </el-button>
                            <el-button @click.native.prevent="modifyBtn(records[scope.$index])" type="text" size="small">
                                修改
                            </el-button>
                            <el-button @click.native.prevent="deleteRow(records[scope.$index])" type="text" size="small">
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
                        <el-form ref="record" :model="record" label-width="80px">
                            <el-form-item label="标题">
                                <el-input v-model="record.title" :disabled="inputDisabled"></el-input>
                            </el-form-item>

                            <el-form-item label="链接">
                                <el-input v-model="record.link" :disabled="inputDisabled"></el-input>
                            </el-form-item>

                            <el-form-item label="描述">
                                <el-input type="textarea" v-model="record.info" :disabled="inputDisabled"></el-input>
                            </el-form-item>
                            <el-form-item
                                    label="权重"
                                    prop="weight"
                                    :rules="[{ type: 'number', message:' '}]">
                                <el-input v-model.number="record.weight" autocomplete="off" :disabled="inputDisabled"></el-input>
                            </el-form-item>
                            <el-form-item label="集合">
                                <el-input v-model="record.collection" :disabled="inputDisabled"></el-input>
                            </el-form-item>
                            <el-form-item label="分类">
                                <el-input v-model="record.category" :disabled="inputDisabled"></el-input>
                            </el-form-item>
                            <el-form-item label="标签">
                                <el-input v-model="record.tag" :disabled="inputDisabled"></el-input>
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
        name: 'RecordManage',
        data() {
            return {
                record: {
                    title: "",
                    link: "",
                    info: "",
                    weight: 1,
                    collection: "",
                    category: "",
                    tag: ""
                },
                records: [],
                dialogVisible: false,
                nameDisabled: false,
                inputDisabled:false,
                operation:1 // 1创建，2查看，3修改
            }
        },
        mounted: function () {
            let that = this;
            axios.get("/record/all").then(function (response) {
                that.records = response.data;
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
                this.record = this.copy(row);
                this.operation = 3
            },
            save: function () {
                this.dialogVisible = false;
                let that = this;
                let recordName = this.record.name;
                axios.post("/record/save", this.record).then(function (response) {
                    if (response.data.code === 1) {
                        that.$notify({
                            title: '保存成功',
                            message: '记录' + recordName + "保存成功",
                            type: 'success'
                        });
                        that.clearRecord();
                    } else {
                        that.$notify({
                            title: '保存失败',
                            message: '记录' + recordName + "保存失败",
                            type: 'error'
                        });
                    }
                });
                this.inputDisabled = false;
                this.nameDisabled = false;
            },
            clearRecord: function() {
                this.record = {
                    title: "",
                    link: "",
                    info: "",
                    weight: 1,
                    collection: "",
                    category: "",
                    tag: ""
                }
            },
            copy: function (record) {
                return {
                    title: record.title,
                    link: record.link,
                    info: record.info,
                    weight: record.weight,
                    collection: record.collection,
                    category: record.category,
                    tag: record.tag,
                }
            },
            queryRow: function (row) {
                this.record = JSON.parse(JSON.stringify(row));
                this.dialogVisible = true;
                this.inputDisabled = true;
                this.nameDisabled = true;
                this.operation = 2;
            },
            deleteRow: function (row) {
                let that = this;
                let recordId = row['id'];
                axios.get("/record/delete", {params: {id: recordId}}).then(function (response) {
                    if (response.data.code === 1) {
                        that.$notify({
                            title: '删除成功',
                            message: '记录' + recordId + "成功被删除",
                            type: 'success'
                        });
                    } else {
                        that.$notify({
                            title: '删除失败',
                            message: '记录' + recordId + "删除失败",
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
