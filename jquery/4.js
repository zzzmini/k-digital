$(function(){
  $(".outer").mouseover(function () { 
    console.log("Outer MouseOver Event....")
  });
  $(".outer").mouseenter(function () { 
    console.log("Outer MounseEnter Event .....")
  });

  $(".inner").mouseover(function () { 
    console.log("inner MouseOver Event....")
  });
  $(".inner").mouseenter(function () { 
    console.log("inner MounseEnter Event .....")
  });
});