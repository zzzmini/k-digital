$(function(){
  $(".outer").mouseover(function () { 
    console.log("Outer MouseOver Event....")
  });
  $(".outer").hover(function () { 
    console.log("Outer Hover Event .....")
  });
});