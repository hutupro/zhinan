<template>
    <div class="left-side">
        <div class="side-content ps-container">
            <ul class="left-nav">
                <li class="no-child" :key="'collection-collect'">
                    <a :href="'#'">
                        <i class="fa fa-bars" style="font-size:15px;margin:0 6px 0 6px"></i>
                        集合管理
                    </a>
                    <i class="open fa fa-plus fa-rotate-135"></i>

                </li>
                <li class="no-child" :key="'collection-category'">
                    <a :href="'#'">
                        <i class="fa fa-bars" style="font-size:15px;margin:0 6px 0 6px"></i>
                        分类管理
                    </a>
                    <i class="open fa fa-plus fa-rotate-135"></i>

                </li>
                <li class="no-child" :key="'collection-record'">
                    <a :href="'#'">
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
            msg: String
        },
        data() {
            return {
                categories: {}
            }
        },
        mounted: function () {
            let that = this;
            axios.get("/category/all-collect").then(function (response) {
                that.categories = response.data;
            })
        },
        methods: {
            md5
        }
    }
</script>

<style scoped>
    @import "../../assets/css/base.css";
</style>
