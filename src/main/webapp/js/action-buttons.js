$(document).ready(function() {
	var button = $('.add-board-ajax');
	var boardId = 1;

	button.click(function(event) {
		console.log("onclick");
		$.post('/board', {
			id : boardId
		}).done(function(data) {
			console.log("data " + data);
		});
	})
});