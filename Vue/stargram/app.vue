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

  <Container :postData="postData" />
  <!-- 더보기 버튼 생성 -->
  <button @click="more">더보기</button>

  <div class="footer">
    <ul class="footer-button-plus">
      <input type="file" id="file" class="inputfile">
      <label for="file" class="input-plus">+</label>
    </ul>
  </div>
</template>

<script>
import postData from './assets/vuestargramData.js';
import Container from './components/Container.vue';
import axios from 'axios';

export default {
  name: 'App',
  data() {
    return {
      postData : postData,
    }
  },
  components: {
    Container,
  },
  methods: {
    more(){
      axios.get('http://43.200.87.25/api/more')
      .then((result)=>{
        // console.log(result.data);
        let rData = result.data;
        for(let i=0; i<rData.length; i++){
          this.postData.push(rData[i]);
        }

      })
    }
  },
}
</script>

<style>
@import './assets/css/app.css';
</style>
