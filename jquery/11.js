$(function(){
  $("#btn_append").on("click", function () {
    $("p").prepend(' Hi~~~~');
  });
  $("#btn_item_append").on("click", function () {
    $("ul").append('<li>네번째 아이템</li>');
  });
  $("#btn_item_prepend").on("click", function () {
    $("ol").prepend('<li>영번째 아이템</li>');
  });

  $("#img_add").on("click", function () {
    const leftImage = $("<img></img>").attr("src", "./left.jpg");
    //$("<img></img>") == const img = document.createElement('img');
    
    const rightImage = $("<img></img>").attr("src", "./right.jpg");
    $("img").before(leftImage).after(rightImage);
  });

  $("#delete").on("click", function () {
    $("p").remove('.black');
  });
})