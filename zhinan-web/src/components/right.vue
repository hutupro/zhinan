<template>
    <div class="right-side">
        <div>
            <div class="box-main">
                <div id="search" class="s-search" style="display: none">
                    <div id="search-list" class="hide-type-list">
                        <div class="s-type"><span></span>
                            <div class="s-type-list"><label for="type-baidu">常用</label></div>
                        </div>
                        <div class="search-group group-a s-current"><span class="type-text">常用</span>
                            <ul class="search-type">
                                <li><input checked="" hidden="" type="radio" name="type" id="type-baidu"
                                           value="https://www.baidu.com/s?wd=" data-placeholder="百度一下"><label
                                        for="type-baidu"><span style="color:#2100E0">百度</span></label></li>
                                <li><input checked="" hidden="" type="radio" name="type" id="type-bing"
                                           value="https://cn.bing.com/search?q=" data-placeholder="必应搜索"><label
                                        for="type-bing"><span style="color:#008373">必应</span></label></li>
                                <li><input type="radio" hidden="" name="type" id="type-google"
                                           value="http://www.google.com.hk/search?q="
                                           data-placeholder="Google search"><label for="type-google"><span
                                        style="color:#3B83FA">G</span><span style="color:#F3442C">o</span><span
                                        style="color:#FFC300">o</span><span style="color:#4696F8">g</span><span
                                        style="color:#2CAB4E">l</span><span style="color:#F54231">e</span></label></li>
                            </ul>
                        </div>
                    </div>
                    <form action="https://www.baidu.com/s?wd=" method="get" target="_blank" id="super-search-fm"
                          style="box-shadow: none;"><input type="text" id="search-text" autocomplete="off"
                                                           placeholder="百度一下" style="outline:none" autofocus="">
                        <button type="submit"><i class="fa fa-search"></i></button>
                    </form>
                    <div class="set-check"><input type="checkbox" id="set-search-blank" class="bubble-3" checked=""
                                                  required=""><label for="set-search-blank"
                                                                     class="green">新窗口打开搜索结果</label></div>
                </div>
                <div class="box-links">
                    <div class="links panel" v-for="(categories, name) in collections" :key="'collection' + name">
                        <div class="panel-heading">
                            <div :id="md5(name).substr(0,3)" style="position: relative;top: -70px;"></div>
                            <i class="fa fa-pinterest"></i>
                            {{name}}
                            <span class="heading-info" style="display: none">Title介绍</span>
                        </div>
                        <div class="panel-body">
                            <dl class="row" v-for="(category, categoryName) in categories" :key="'category' + categoryName
">
                                <dt class="col-sm-3 col-md-2 col-xs-4" :style="'min-height: ' + (50 + parseInt(category.length/5) * 70) + 'px'">
                                    <a target="_blank">{{categoryName}}</a>
                                    <div :id="md5(name + categoryName).substr(0,3)" style="position: relative;top: -110px;"></div>
                                </dt>
                                <dd class="col-sm-3 col-md-2 col-xs-4" v-for="record in category" :key="'record' + record.id + '-' + Math.random()*1000 ">
                                    <a :href="record.link" target="_blank"><i class="link-logo"></i><span class="link-title">{{record.title}}</span><span class="link-info">{{record.info}}</span></a>
                                </dd>
                            </dl>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import 'font-awesome/css/font-awesome.min.css'
    import axios from 'axios'
    import md5 from 'js-md5'

    export default {
        name: 'RightSide',
        props: {
            msg: String,
        },
        data() {
            return {
                collections: {}
            }
        },
        mounted: function () {
            let that = this;
            axios.get("/record/get-all-collect").then(function (response) {
                that.collections = response.data;
            })
        },
        methods: {
            md5
        }
    }
</script>

<style scoped>

</style>
