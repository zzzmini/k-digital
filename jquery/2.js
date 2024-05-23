$(document).ready(function(){
  $(".btn_1").click(function(){
    // $("body").css("background-color","red");
    // $(this).css("background-color","yellow");
    // $("p .intro").css("background-color", "yellow");
    $("p:last").css("background-color", "green");
  });

  $("#btn_1").click(function(){
    $("ul li:first-child").css("background-color", "gold");
  });

  $("#btn_2").click(function(){
    $("a[href != 'www.daum.net']").css("background-color", "gold");
  });

  $("#btn_3").click(function(){
    $("tr:odd").css("background-color", "gold");
  })
});