$(document).ready(function(){
	
	$('#appreciations').on('click', function(){
		hideComponent();
		$('#appreciationform').show();
	});
	
	$('#accounts').on('click', function(){
		hideComponent();
		$('#accountsform').show();
	});
	
	$('#activities').on('click', function(){
		hideComponent();
		$('#activitiesform').show();
	});
	
	$('#sendmail').on('click', function(){
		hideComponent();
		$('#sendmailform').show();
	});
		
});

function hideComponent(){
	$('.actioncomponent').hide();
}