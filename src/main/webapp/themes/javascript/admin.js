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
});

function hideComponent(){
	$('.actioncomponent').hide();
}