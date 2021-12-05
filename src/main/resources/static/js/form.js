$('.signUpBtn').click(function(){
    $('.login').hide();
    $('.signUp').show();
    $('.signUpBtn').css({'border-bottom' : '2px solid #ff4141'});
    $('.loginBtn').css({'border-style' : 'none'});
})

$('.loginBtn').click(function(){
    $('.login').show();
    $('.signUp').hide();
    $('.loginBtn').css({'border-bottom' : '2px solid #ff4141'});
    $('.signUpBtn').css({'border-style' : 'none'});
})