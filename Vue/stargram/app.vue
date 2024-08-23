<template>
  <div class="header">
    <ul class="header-button-left">
      <li>Cancle</li>
    </ul>
    <ul class="header-button-right">
      <li>Next</li>
    </ul>
    <img class="logo" alt="Vue logo" src="./assets/logo.png">
  </div>
  <Container />
  <div class="footer">
    <ul class="footer-button-plus">
      <input type="file" id="file" class="inputfile">
      <label for="file" class="input-plus">+</label>
    </ul>
  </div>
</template>

<script>

export default {
  name: 'App',
  components: {
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  box-sizing: border-box;
  margin-top: 60px;
  width: 100%;
  max-width: 460px;
  margin: auto;
  position: relative;
  border-right: 1px solid #eee;
  border-left: 1px solid #eee;
}
body{
  margin: 0;
}
ul {
  padding: 5px;
  list-style: none;
}
.logo{
  width: 22px;
  margin: auto;
  display: block;
  position: absolute;
  left: 0;
  right: 0;
  top: 13px;
}
.header {
  width: 100%;
  height: 40px;
  background-color: white;
  padding-bottom: 8px;
  position: sticky;
  top: 0;
}
.header-button-left {
  color : skyblue;
  float : left;
  width: 50px;
  padding-left: 20px;
  cursor: pointer;
  margin-top: 10px;
}
.header-button-right {
  color : skyblue;
  float : right;
  width: 50px;
  cursor: pointer;
  margin-top: 10px;
}
.footer {
  width: 100%;
  position: sticky;
  bottom: 0;
  padding-bottom: 10px;
  background-color: white;
}
.footer-button-plus{
  width: 80px;
  margin: auto;
  text-align: center;
  cursor: pointer;
  font-size: 24px;
  padding-top: 12px;
}
.inputfile{
  display: none;
}
</style>
