$(function(){
  $("[type = 'password']").focus(function () { 
    $(this).css("background-color", "pink");
  });
  $("[type]").blur(function () { 
    $(this).css("background-color", "");
  });
})