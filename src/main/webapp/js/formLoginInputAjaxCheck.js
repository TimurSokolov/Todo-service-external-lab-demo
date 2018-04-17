$(document).ready(function() {
	var form = $('#registrationForm');
	var input = $('input#login', form)

	input.keyup(function(event) {
		var value = input.val();
		if (value.length > 3) {
			$.getJSON('/checkloginexist', {
				login : value
			}, function(response) {
				if (response == true) {
					$('#registrationForm input#login').css({
						"color" : "red"
					});
				} else {
					$('#registrationForm input#login').css({
						"color" : "black"
					});
				}
			});
		}
	});
});