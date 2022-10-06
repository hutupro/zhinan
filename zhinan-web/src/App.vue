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
  * {
    margin: 0;
    padding: 0;
  }
#app {
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  margin-top: 60px;
  text-decoration: none;
  color: #39474b;
  font-size: 12px;
  font-family: "Lantinghei SC","Open Sans","Lucida Grande",Helvetica,"PingFang SC",STheiti,Verdana,"microsoft yahei","simsun",Geneva,sans-serif;
}

.main {
  height: 100%;
}

</style>
