// JavaScript Document
var qualificationRowIndex=0;
$(document).ready(function(){
      $("#add").click(function(){
		
      $("#passwordBtn").button();
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
 			
 			"securityQuestion" : {
 		        required : true
 		   },
  			
  			"securityAnswer" : {
  		        required : true
  		   },
  			"user.firstName" : {
  		        required : true
  		   },
  			"user.lastName" : {
  		        required : true
  		   },
  			"user.phone" : {
  		        required : true
  		   },
  		   messages: {
  			   
  		     }
  		   }
  		 
  	});
});




function validateForm(){
	var isValid = $("#registrationForm").valid();
	console.log('Form Valid...',isValid);
	var userId = $("#user\\.id").val();
	console.log('...value...',userId);
	if(isValid){
		if(userId == null || userId==undefined || userId == ""){
			$("#registrationForm").attr("action",webContextPath+"/manage/forgotpassword");
		}
	}
}
});