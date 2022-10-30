<template>
  <div id="app">
    <HeaderPage />

    <div class="main">
      <LeftSide />
      <RightSide />
    </div>
  </div>

</template>

<script>
import HeaderPage from "./components/header";
import LeftSide from "./components/left";
import RightSide from "./components/right";

export default {
  name: 'App',
  components: {
    HeaderPage,
    LeftSide,
    RightSide
  }
}
</script>

<style>


</style>
