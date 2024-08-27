<template>
  <div 
  @click="changeFilter"
  :class="`${filter} filter-item`"
  :style="{backgroundImage : `url(${strUrl})`}">
        <slot></slot>
        <!-- <button @click="fire">발사</button> -->
  </div>
</template>

<script>
export default {
    name : 'FilterBox',
    props :{
        strUrl : String,
        filter : String,
    },
    methods: {
        changeFilter(){
            this.emitter.emit('changeFilter', this.filter);
        },
        fire(){
            this.emitter.emit('fire', 'FilterBox에서 쏨');
        }
    },
}
</script>

<style>
@import '../assets/css/cssgram.min.css';

    .filter-item {
        width: 100px;
        height: 100px;
        margin: 10px 10px 10px auto;
        padding: 8px;
        color: white;
        display: inline-block;
        background-size: cover;
        background-position: center;
    }
</style>
