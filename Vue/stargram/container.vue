<template>
  <!-- 시작 페이지 : 글 전체 목록 -->
   <div v-if="step == 0">
    <Post v-for="post in postData" 
    :key="post" :post="post"/>
   </div>
  
  <!-- 두번째 페이지 : 이미지Up & Filter -->
   <div v-if="step == 1">
    <div class="upload-image" 
    :style="{backgroundImage : `url(${strUrl})`}"></div>
    <div class="filters">
        <div class="filter-1"></div>
        <div class="filter-1"></div>
        <div class="filter-1"></div>
        <div class="filter-1"></div>
        <div class="filter-1"></div>
    </div>
   </div>
  
  <!-- 세번째 페이지 : 이미지 + 글쓰기 -->  
   <div v-if="step == 2">
    <div class="upload-image" :style="{backgroundImage : `url(${strUrl})`}"></div>
    <div class="write">
        <textarea 
        @change="$emit('write', $event.target.value)" 
        class="write-box">write!</textarea>
    </div>
   </div>  
  
</template>

<script>
import Post from './Post.vue';

export default {
    name : 'ContainerVue',
    components : {
        Post,
    },
    props : {
        postData : Array,
        step : Number,
        strUrl : String,
    }
}
</script>

<style>
.upload-image{
width: 100%;
height: 450px;
background: cornflowerblue;
background-size : cover;
}
.filters{
overflow-x:scroll;
white-space: nowrap;
}
.filter-1 {
width: 100px;
height: 100px;
background-color: cornflowerblue;
margin: 10px 10px 10px auto;
padding: 8px;
display: inline-block;
color : white;
background-size: cover;
}
.filters::-webkit-scrollbar {
height: 5px;
}
.filters::-webkit-scrollbar-track {
background: #f1f1f1; 
}
.filters::-webkit-scrollbar-thumb {
background: #888; 
border-radius: 5px;
}
.filters::-webkit-scrollbar-thumb:hover {
background: #555; 
}
.write-box {
border: none;
width: 90%;
height: 100px;
padding: 15px;
margin: auto;
display: block;
outline: none;
}
</style>
