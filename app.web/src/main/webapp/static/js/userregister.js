// JavaScript Document
var qualificationRowIndex=0;
$(document).ready(function(){
      $("#add").click(function(){
		var currentIndex = qualificationRowIndex+1;
		console.log('currentIndex xxx...',currentIndex);
	 		$('#educationinfotb tr:last')
			.after('<tr>'+
				'<td><input type="text" name="user.qualifications['+ currentIndex +'].certification" autofocus required/></td>'+
				'<td><input type="text" name="user.qualifications['+ currentIndex +'].boardOrUniversity" autofocus required/></td>'+
				'<td><input type="text" name="user.qualifications['+ currentIndex +'].yearOfPassing" autofocus required/></td>'+
				'<td><input type="text" name="user.qualifications['+ currentIndex +'].percentage" autofocus required/></td>'+
				'</tr>');
			qualificationRowIndex = currentIndex;
		});
});
