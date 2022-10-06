<template>
    <div class="left-side">
        <div class="side-content ps-container">
            <ul class="left-nav">
                <li class="no-child"><a href="#top-links"><i class="fa fa-bars"
                                                                       style="font-size:15px;margin:0 6px 0 6px"></i>常用</a><i
                        class="open fa fa-plus fa-rotate-135"></i>
                    <ul style="display: block;">
                        <li><a href="#" target="_blank"><i class="fa fa-caret-right"></i>分类1</a></li>
                        <li><a href="#" target="_blank"><i class="fa fa-caret-right"></i>分类2</a></li>
                    </ul>
                </li>

            </ul>

        </div>

    </div>
</template>

<script>
    export default {
        name: 'LeftSide',
        props: {
            msg: String
        }
    }
</script>

<style scoped>
    .left-side {
        position: fixed;
        top: 50px;
        left: 0;
        width: 180px;
        background: #2a393c;
        height: 100%;
    }

    a {
        text-decoration: none;
    }

    .left-side .side-content {
        overflow: hidden;
        position: absolute;
        width: 100%;
        height: 100%;
        left: 0;
    }

    ul, ol {
        list-style: none;
    }

    .left-nav li {
        position: relative;
    }

    .left-nav>li>a {
        display: block;
        padding: 0 12px;
        height: 36px;
        line-height: 36px;
        font-size: 14px;
        color: #31c193;
        text-decoration: none;
        text-shadow: 0 1px 0 #293334;
    }

    .left-nav ul li a {
        display: block;
        padding: 8px 10px 8px 17px;
        color: #b4c8ce;
        margin-bottom: 4px;
        border-radius: 3px;
    }

    .left-nav a>i:first-child {
        color: #708985;
    }

    .left-nav ul li a i {
        margin-right: 14px;
    }

    .open {
        z-index: 1;
        position: absolute;
        top: 0;
        right: 0;
        padding: 11px 16px 10px;
        opacity: .5;
        color: #708985;
        cursor: pointer;
    }

    ul.left-nav {
        padding: 5px;
        margin: 0 0 10px;
    }
</style>
