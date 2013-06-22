$(document).ready(function(){
	
	$('#appreciation').on('click', function(){
		hideComponent();
		$('#appreciationlist').show();
	});
	
	$('#accounts').on('click', function(){
		hideComponent();
		$('#accountsform').show();
	});
	
	$('#activities').on('click', function(){
		hideComponent();
		$('#activitiesform').show();
	});
	
	$('#user').on('click', function(){
		hideComponent();
		$('#memberlist').show();
	});
});

function hideComponent(){
	$('.actioncomponent').hide();
}