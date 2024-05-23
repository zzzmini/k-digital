$(function(){
  // $("h1").mouseenter(function (e) { 
  //   e.preventDefault();
  //   //submit만 하고, 새로고침 되지 않는 상태 
  //   //(= 이름이 고대로 적어진 상태)로 만들기 위해 
  //   //preventDefault를 사용!
  //   $(this).css("background-color", "yellow");
  // });
  // $("h1").mouseleave(function () { 
  //   $(this).css("background-color", "green");
  // });
  $("h1").on({
    click      : function (){$(this).css("background-color", "red")},
    mouseenter : function (){$(this).css("background-color", "yellow")},
    mouseleave : function (){$(this).css("background-color", "pink")}
  })

  

});