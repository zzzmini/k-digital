$(function(){
  $("#btn_get").on("click", function () {
    alert($("#message").text());
    alert($("#message").html());
  });

  //val()
  $("#getName").on("click", function(){
    //alert($("#name").val())
    alert(document.querySelector('#name').value);
  })

  $("#attr-test").on("click", function () {
    // href 속성값을 변수 daumUrl 로 가져오기
    const daumUrl = $("#daum").attr('href');
    const aTagText = $("#daum").text();
    // input 상자에 넣기
    $("#getDaumUrl").val(daumUrl);
  });
  $("#btn_set").on("click", function () {
    $("#idolName").html("<b>장원영</b>")
  });

  $("#btn_ive").on("click", function () {
    $("#ive").text(function(i, originText){
      return "안녕하세요~ " + originText + "입니다. (" + i + ")"
    });
  });

  $("#btn_girl_group").on("click", function () {
    $(".girl-group").text(function(i, originText){
      return "안녕하세요~ " + originText + "입니다. (" + i + ")";
    })
  });

  $("#btn_change").on("click", function () {
    $("#site").attr('href', 'https://naver.com').text('네이버');
  });
})