<template>
    <div class="left-side">
        <div class="side-content ps-container">
            <ul class="left-nav">
                <li class="no-child" v-for="(cates, collectionName) in categories" :key="'collection-' + collectionName">
                    <a :href="'#' + md5(collectionName).substr(0,3)">
                        <i class="fa fa-bars" style="font-size:15px;margin:0 6px 0 6px"></i>
                        {{collectionName}}
                    </a>
                    <i class="open fa fa-plus fa-rotate-135"></i>
                    <ul style="display: block; margin-left: 20px;">
                        <li v-for="cate in cates" :key="'category-' + cate.name">
                            <a :href="'#' + md5(collectionName + cate.name).substr(0,3)"><i class="fa fa-caret-right"></i>{{cate.name}}</a>
                        </li>
                    </ul>
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
    @import "../assets/css/base.css";
</style>
