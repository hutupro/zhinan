<template>
    <div id="app">
        <HeaderPage />
        <LeftSide />
        <RightSide />
    </div>
</template>

<script>
    import HeaderPage from '../../components/header'
    import LeftSide from "./left";
    import RightSide from "./right";

    export default {
        name: 'AdminPage',
        components: {
            RightSide,
            LeftSide,
            HeaderPage
        }
    }
</script>

<style scoped>

</style>