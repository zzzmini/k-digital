<template>
  <div class="header">
    <ul class="header-button-left">
      <li v-if="step > 0" @click="step = 0">Cancle</li>
    </ul>
    <ul class="header-button-right">
      <li v-if="step == 1" @click="step++">Next</li>
      <li v-if="step == 2" @click="publish">발행</li>
    </ul>
    <img class="logo" alt="Vue logo" src="./assets/logo.png">
  </div>

  <!-- <div v-if="step == 0">내용 0</div>
  <div v-if="step == 1">내용 1</div>
  <div v-if="step == 2">내용 2</div>
  <button @click="step = 0">버튼 0</button>
  <button @click="step = 1">버튼 1</button>
  <button @click="step = 2">버튼 2</button> -->


  <Container @write="strWrite = $event" :postData="postData" :step="step" 
      :strUrl="strUrl"/>
  <!-- 더보기 버튼 생성 -->
   <div v-if="step==0">
    <button @click="more">더보기</button>
   </div>
  

  <div class="footer">
    <ul class="footer-button-plus">
      <input @change="upload" type="file" id="file" class="inputfile">
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
      step : 0,
      strUrl : '',
      strWrite : '',
    }
  },
  components: {
    Container,
  },
  methods: {
    publish(){
      // data.js 의 객체를 하나 생성 후에 맨 앞에 추가
      // vuestargramData.js
      // [ {}, {}, {}, ....]
      let today = new Date().toDateString();
      let myPosting = {
        name: "김형민",
        userImage: "https://picsum.photos/100?random=3",
        postImage: this.strUrl,
        likes: 0,
        date: today,
        liked: false,
        content: this.strWrite,
        filter: "perpetua"
      };

      this.postData.unshift(myPosting);

      this.step = 0;
    },
    upload(e){
      let imgFile = e.target.files;
      this.strUrl = URL.createObjectURL(imgFile[0]);
      console.log("strUrl = " + this.strUrl);
      this.step = 1;
    },
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
