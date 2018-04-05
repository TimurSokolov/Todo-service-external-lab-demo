$(document).ready(function() {
    var form = $('#loginForm');
    var input = $('input#login', form)

    input.change(function(event) {
	value = input.val();
	if (value.length > 3) {
	    console.log("if (value.length > 3) {");
	    
	    $.getJSON('/checkloginexist', {
		login : value
	    }, function(response) {
		console.log("response " + response);
		if (response == true) {
		    $('#loginForm label').css({"color":"red"});
		} else {
		    $('#loginForm label').css({"color":"black"});
		}
	    });
	}
    });
});