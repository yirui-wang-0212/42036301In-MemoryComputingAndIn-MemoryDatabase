var control_timeout, footerHeight;

$(document).ready(function(){
	$("html").niceScroll({ autohidemode: false });
	$('#menu').localScroll({hash:true, onAfterFirst:function(){$('html, body').scrollTo( {top:'-=25px'}, 'fast' );}});
	$('#about-menu').localScroll({hash:true, onAfterFirst:function(){$('html, body').scrollTo( {top:'-=25px'}, 'fast' );}});
	$('.logo').localScroll({hash:true});	
	$('.read-on').localScroll({hash:true});
	
	is_ipad = navigator.userAgent.toLowerCase().indexOf('ipad') > -1;
	if(is_ipad){
		$('.menu-dropdown').removeClass('hidden');
		$('#menu').addClass('hidden');
	}
	else{
		$('.menu-dropdown').addClass('hidden');
		$('#menu').removeClass('hidden');
	}
	$('#submit').click(function(event){
		event.preventDefault();
		if (valemail($('#email').attr('value')) && $('#name').attr('value')!=''){
			$('html, body').scrollTo( $('#contact'), 'fast' );
			$.ajax({
				type: 'POST',
				url: 'send_form_email.php',
				data: $('#contact_form').serialize(),
				success: function(html) {
					if($(window).width()>=768){
						divHeight = getDivHeight('form') - 80;
						$('#thanks').css('height',divHeight)
						$('#form').removeClass('shadow');
						$('#thanks').removeClass('hidden');
						$('.bottom-shadow').addClass('hidden');
						$('.no-shadow').removeClass('hidden');
						$('#client_name').html($('#name').attr('value'));
						var msg = '';
						if(html.success=='1')
						{
							msg = '<h1>Your message has been sent successfully</h1>';							
							$("#form").flip({
								direction: 'lr',
								color: '#FDFCF6',
								bgcolor: '#FDFCF6',
								speed: 200,
								content: msg
							});
						}
						else
							show_error_msg();
						
					}
					else
					{
						if(html.success=='1')
						{
							var msg = '<h1>Your message has been sent successfully</h1>';
							$('#client_name').html($('#name').attr('value'));							
							$("#form").html(msg);
						}
						else
							show_error_msg();
					}
				},
				error: function(){
					show_error_msg();
				}
			});
		} else {
			show_error_msg();
		}
	});

	init_scroll();

	control_timeout = setTimeout("no_run()",1350);

	$('.menu-btn').click(function(){
		$('html, body').animate({ scrollTop: $(document).height() }, 'fast');
	});
	
	paddFooter();
	
});

$(window).resize(function(){
	init_scroll ();	
	$('#footer').css('padding-bottom','0');
	paddFooter();
});


function paddFooter(){
	if ($(window).width()<=590) {
		topHeight = getDivHeight('top') ;
		footerHeight = getDivHeight('footer');
		$('#footer').css('padding-bottom', ($(window).height() - footerHeight) - topHeight + 'px');
	}
	else{
		$('#footer').css('padding-bottom','0');
	}
}
function init_scroll () {

	if($(window).width()>=768){
		nScroll = 4;
		nVisible = 4;
	}else{
		if(($(window).width()<768) && ($(window).width()>=480)){
			nScroll = 2;
			nVisible = 2;
		}else{
			nScroll = 1;
			nVisible = 1;
		}
	}

	$('#slide-wrapper ul').carouFredSel({
		responsive: true,
		width: '100%',
		height: '71px',
		scroll: nScroll,
		items: {
			width: 192,
			visible: nVisible
		},
		swipe: {
			onMouse: true,
			onTouch: true
		},
		pagination  : "#foo2_pag"

	});

}

function no_run(){
	clearTimeout(control_timeout);
}

function valemail(email) {
    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
}

function show_error_msg() {
	$('#ajax-message').css('display','block').html('Your message can not be sent at the moment, please try again later!');	
}
function getDivHeight(objName) {
    return boxHeight = document.getElementById(objName).clientHeight;
}