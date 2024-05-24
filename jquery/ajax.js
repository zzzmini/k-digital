$(function(){
  $("#null").on("click", function(){
    $("#display1").load("./outer.txt");
  })
  $("#load_data").on("click", function () {
    $("#display1").load("./news.html #first");
    $("#display2").load("./news.html #second");
    $("#display3").load("./news.html .third");
  });

  // $("#post").on("click", function(){
  //   $("#display1").load("./news.html",
  //     {
  //       "name" : "장원영",
  //       "age" : 20
  //     },function(responsText, statusText, xhr){
  //       if(statusText == 'error'){
  //         alert("오류가 발생했습니다.")
  //       }
  //       console.log(xhr.statusText);
  //     }
  //   );
  // })
  $("#post").on("click", function(){
    $("#display1").load("./news.html",function(responsText, statusText, xhr){
        if(statusText == 'error'){
          alert("요청하신 페이지가 없습니다.")
        } else {
          alert("정상 처리 되었습니다.")
        }
        console.log(xhr.statusText);
      }
    );
  })
})