<template>
  <Post v-for="post in postData" 
    :key="post" :post="post"/>
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
    }
}
</script>

<style>

</style>
