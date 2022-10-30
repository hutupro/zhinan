<template>
    <div class="left-side">
        <div class="side-content ps-container">
            <ul class="left-nav">
                <li class="no-child" :key="'collection-collect'">
                    <a :href="'#collection'" @click="changeMenu('collection')">
                        <i class="fa fa-bars" style="font-size:15px;margin:0 6px 0 6px"></i>
                        集合管理
                    </a>
                    <i class="open fa fa-plus fa-rotate-135"></i>

                </li>
                <li class="no-child" :key="'collection-category'"  @click="changeMenu('category')">
                    <a :href="'#category'">
                        <i class="fa fa-bars" style="font-size:15px;margin:0 6px 0 6px"></i>
                        分类管理
                    </a>
                    <i class="open fa fa-plus fa-rotate-135"></i>

                </li>
                <li class="no-child" :key="'collection-record'"  @click="changeMenu('record')">
                    <a :href="'#index'">
                        <i class="fa fa-bars" style="font-size:15px;margin:0 6px 0 6px"></i>
                        索引管理
                    </a>
                    <i class="open fa fa-plus fa-rotate-135"></i>

                </li>

            </ul>

        </div>

    </div>
</template>

<script>
    import axios from 'axios'
    import md5 from 'js-md5'

    export default {
        name: 'LeftSide',
        props: {
            menu: String
        },
        data() {
            return {
                categories: {},
                page: 'record'
            }
        },
        mounted: function () {
            let that = this;
            axios.get("/category/all-collect").then(function (response) {
                that.categories = response.data;
            })
        },
        methods: {
            changeMenu(menuName) {
                this.$emit("transMenu", menuName)
            }
        }
    }
</script>

<style scoped>
    @import "../../assets/css/base.css";
</style>
