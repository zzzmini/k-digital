$(function(){
  $("#btn_1").dblclick(function(){
    $("p").hide();
  })
  $("p.enter").mouseenter(function () { 
    $(this).css("background-color", "gold");
  });
  $("p.enter").mouseleave(function () { 
    $(this).css("background-color", "white");
  });

  $("p.mouse").mousedown(function () { 
    $(this).css("background-color", "pink");
  });

  $("p.mouse").mouseup(function () { 
    $(this).css("background-color", "gray");
  });
});