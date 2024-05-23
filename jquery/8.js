$(function(){
  $("#rose").on(
    {click : function (){$(this).hide('slow')}});
  $("#btn_show").on(
    {click : function (){$("img").show('fast', 
    function(){
      $("#rose").hide('fast');
    })}});
})