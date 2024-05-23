$(function(){
  // $("#a").fadeIn();
  $("#btn_fadeIn").on({
    click : function(){
      $("div#a").fadeIn(1000);
      $("div#b").fadeIn('slow', function(){
        alert("다 끝났어요");});
      $("div#c").fadeIn('fast');
  }});

  $("#btn_fadeOut").on({
    click : function(){
      $("div#a").fadeOut(1000);
      $("div#b").fadeOut('slow', function(){
        alert("다 끝났어요");});
      $("div#c").fadeOut('fast');
  }})

  $("#btn_fadeToggle").on({
    click : function(){
      $("#a").fadeToggle();
    }
  })

  $("#btn_fadeTo").on({
    click : function(){
      // $("#a").fadeTo('slow', 0.5);
      $("#a").fadeTo(3000, 0);
    }
  })
})