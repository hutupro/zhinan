<template>
    <div id="app">
        <HeaderPage />
        <LeftSide :menu="menu" @transMenu="transMenu($event)" />
        <CollectionManage v-if="menu === 'collection'" />
        <CategoryManage v-if="menu === 'category'" />
        <RecordManage v-if="menu === 'record'" />
    </div>
</template>

<script>
    import HeaderPage from '../../components/header'
    import LeftSide from "./left";
    import CollectionManage from "./CollectionManage";
    import CategoryManage from "./CategoryManage";
    import RecordManage from "./RecordManage";

    export default {
        name: 'AdminPage',
        data: () => ({
            menu: 'record'
        }),
        components: {
            RecordManage,
            CategoryManage,
            CollectionManage,
            LeftSide,
            HeaderPage
        },
        methods: {
            transMenu(message) {
                this.menu = message
            }
        }
    }
</script>

<style scoped>

</style>