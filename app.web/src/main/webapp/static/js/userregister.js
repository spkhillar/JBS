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
				'<td><input type="number" name="user.qualifications['+ currentIndex +'].yearOfPassing" autofocus required/></td>'+
				'<td><input type="number" name="user.qualifications['+ currentIndex +'].percentage" autofocus required/></td>'+
				'</tr>');
			qualificationRowIndex = currentIndex;
		});
      $("#user\\.dateOfBirth").datepicker({dateFormat: "dd/mm/yy" });
      $("#registerBtn").button();
  	$("#registrationForm").validate( {
  	    success : "valid",
  	    ignoreTitle : true,
  	    rules : {
  			"user.userName" : {
  		        required : true,
  		      userNameCheck: true
  		   },
  			"user.email" : {
  		        required : true,
  		        email:true
  		   },
  			"user.password" : {
  		        required : true
  		   },
  			"confirmPassword" : {
  		        required : true,
  		        equalTo: "#user\\.password"
  		   },
  			"securityAnswer" : {
  		        required : true
  		   },
  			"user.firstName" : {
  		        required : true
  		   },
  			"user.address.addressLine1" : {
  		        required : true
  		   },
  			"user.address.city" : {
  		        required : true
  		   },
  			"user.phone" : {
  		        required : true
  		   },
  			"user.address.pin" : {
  		        required : true
  		   },
  			"user.skill.skills" : {
  		        required : true
  		   },
  		   "terms" : {
  		        required : true
  		   }
  	    },
  	    messages: {
  	    	confirmPassword: {
  				equalTo: "Please enter the same password as above"
  			},
  			"terms":{
  				required: "You must agree to terms and condition of JobsBySMS.com."
  			}
  		}
  	});
});


jQuery.validator.addMethod('userNameCheck', function(inputValue) {
	var unqiueUserName = checkUniqueUserName(inputValue);
	console.log('..unqiueUserName...',unqiueUserName);
	return !unqiueUserName;
}, "Username already exists. Please use different username");
function checkUniqueUserName(value){
	var retValue = false;
	$.ajax({
		type : "get",
		url : webContextPath + '/register/checkUserName/'+value,
		async : false,
		success : function(data, textStatus) {
			console.log("...checkUserName...",data);
			retValue = data;
		}
	});
	
	return retValue;
}

function registerUser(){
	var isValid = $("#registrationForm").valid();
	console.log('Form Valid...',isValid);
	var userId = $("#user\\.id").val();
	console.log('...value...',userId);
	if(isValid){
		if(userId == null || userId==undefined || userId == ""){
			$("#registrationForm").attr("action",webContextPath+"/register/newuser");
		}else{
			$("#registrationForm").attr("action",webContextPath+"/register/updateuser");
		}
	}
}

