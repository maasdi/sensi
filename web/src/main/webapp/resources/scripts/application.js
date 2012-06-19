$(document).ready(function(){
	
	//BIND DROPPER SIDEBAR ACTIONS
	$('.sidebar > ul > li.dropper >figure:first-child').on("click",function(){
		$(this).parent().find('.subDrop').slideToggle(300);
		var ac = $('.sidebar > ul >li.active')[0];
		var par = $(this).parent()[0];
		
		if(typeof ac == 'undefined'){
			$(par).addClass('active');
			var arrow = $(this).find('.icon-circle-arrow-down');
			$(arrow).removeClass('icon-circle-arrow-down');
			$(arrow).addClass('icon-circle-arrow-right');
		}else{
			$(ac).removeClass('active');
			var arrow = $(this).find('.icon-circle-arrow-right');
			$(arrow).removeClass('icon-circle-arrow-right');
			$(arrow).addClass('icon-circle-arrow-down');
		}
	}); 
	
	// tooltip
	$(".navbar a[rel='tooltip']").tooltip({
		placement:'bottom',
		trigger:'hover',
		animation:'true'
	});

        // alert
        $(".alert").alert()
});