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
                            <i class="fa fa-pinterest"></i>
                            {{name}}
                            <span class="heading-info" style="display: none">Title介绍</span>
                        </div>
                        <div class="panel-body">
                            <dl class="row" v-for="(category, categoryName) in categories" :key="'category' + categoryName
">
                                <dt class="col-sm-3 col-md-2 col-xs-4 row2">
                                    <a href="#nogo" target="_blank">{{categoryName}}</a>
                                </dt>
                                <dd class="col-sm-3 col-md-2 col-xs-4" v-for="record in category" :key="'record' + record.id">
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

        }
    }
</script>

<style scoped>
    .right-side {
        margin-left: 180px;
        margin-top: -20px;
        padding-top: 40px;
        padding-bottom: 40px;
        background: #e7eff4  repeat-x 0 0;
        height: 100%;
        fill: red;
    }

    .box-main {
        margin: 0 auto;
        max-width: 1280px;
        padding: 10px 20px 0;
        color: #518193;
        font-size: 15px;
    }

    .panel {
        margin-bottom: 10px;
        padding: 1px;
        border: 0 solid #c5d2db;
        border-radius: 8px;
        background: #fff;
        box-shadow: 0 1px 2px rgb(31 35 37 / 8%);
    }

    .links .panel-heading {
        padding: 12px 24px;
        font-size: 18px;
    }

    .panel-heading {
        padding: 8px;
        border-bottom: 1px solid #e7eff4;
        border-radius: 4px 4px 0 0;
    }

    .heading-info {
        margin: 3px 0 0 20px;
        font-size: 14px;
        color: #f46c0e;
        letter-spacing: 2px;
    }

    .panel-body {
        padding: 10px;
    }

    .links dl:first-child {
        padding-top: 0;
    }
    .links dl {
        border-bottom: 1px solid #f8f8f8;
        padding: 10px 0;
    }
    .links dl:last-child {
        border: 0;
        padding-bottom: 0;
    }
    .row {
        margin-left: -10px;
        margin-right: -10px;
    }

    .links dt.row2 {
        min-height: 110px;
    }

    .links dt a {
        display: inline-block;
        margin: 15px;
        color: #a2a8a2;
        font-size: 16px;
        cursor: default;
    }

    @media (min-width: 992px) {
        .col-md-2 {
            width: 15%
        }

        .col-md-2 {
            float: left;
            min-height: 1px;
            padding-left: 10px;
            padding-right: 10px;
        }
    }

    .panel-heading:after, .row:after {
        clear: both;
        content: '.';
        display: block;
        visibility: hidden;
        height: 0;
    }

    .links dd>a:first-child {
        display: block;
        padding: 15px 15px 13px;
        overflow: hidden;
        border-radius: 5px;
    }
    .links dd a, .open, .expand {
        -webkit-transition: all .2s ease;
        transition: all .2s ease;
    }

    .links dd a:hover {
        background: #edf5fa;
    }

    a:hover, .links dd a:hover .link-title, .links dd a:hover .link-info {
        color: #0065a9;
    }


    a {
        color: #00ad35;
        text-decoration: none;
    }
    .link-info {
        font-size: 12px;
        color: #a2a8a2;
        line-height: 1.5em;
    }
    .link-title, .link-info {
        display: block;
    }
</style>
