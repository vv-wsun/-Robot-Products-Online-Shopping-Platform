
jQuery(document).ready(function() {
	
    /*
        Fullscreen background
    */
    $.backstretch("img/backgrounds/1.jpg");
    
    /*
        Form validation
    */
    $('.login-form input[type="text"], .login-form input[type="password"], .login-form textarea').on('focus', function() {
    	$(this).removeClass('input-error');
    });
    
    $('.login-form').on('submit', function(e) {
    	
    	$(this).find('input[type="text"], input[type="password"], textarea').each(function(){
			$(".text-danger").hide();
    		if( $(this).val() == "" ) {
    			e.preventDefault();
    			$(this).addClass('input-error');
    		}
    		else {
    			$(this).removeClass('input-error');
    		}
    	});
		$("#form-email").each(function() {
				var str = $("#form-email").val();
		reg=/^\w{3,}@\w+(\.\w+)+$/;  
			if(reg.test(str)){
				$(".text-danger").hide();
			}
			else {
				var wr = "<div class='text-danger text-left'><label> Your email address is wrong! check it.</label></div>"
				$("#form-email").after(wr);
			}
	});
		
    });
	
	/*
	checking email by using zhengzebiaodashi
	*/
    
});
