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
      $("#user\\.dateOfBirth").datepicker({ 
    	      dateFormat: "dd/mm/yy",
    		  changeMonth: true,
              changeYear: true,
              yearRange: '-100y:c+nn',
              maxDate: '-1d',
              onClose: function ageVerification() {
                  var value = document.getElementById('user.dateOfBirth').value;
                  var birthDate = new Date(document.getElementById('user.dateOfBirth').value);
                  var currDate = new Date();
                  var yearDifferential = currDate.getFullYear() - birthDate.getFullYear();

                  var totalMonths = (yearDifferential * 12) + (currDate.getMonth() - birthDate.getMonth());

                  if (value != "") {

                      if (currDate.getDate() < birthDate.getDate()) {
                          totalMonths--;
                      }

                  }
                  else {
                      window.alert("Please enter your date of birth");
                  }

                  var age = parseInt(totalMonths / 12);
                   if (age < 18) {
                      window.alert("You must be 18 or older to register to JOBSbySMS.  ");
                      $(this).val="";

                  }
              }
           
      });
       $("#registerBtn").button();
       $("#registrationForm").validate( {
  	    success : "valid",
  	    ignoreTitle : true,
  	    rules : {
  			"user.userName" : {
  		        required : true,
  		        userNameCheck: true,
  		        minlength: 4,
  		        maxlength: 20,
  		        alphanumeric: true,
  		        notNumber:true
  		      },
  			"user.email" : {
  		        required : true,
  		      emailCheck:true
  		   },
  			"user.password" : {
  		        required : true,
  		        minlength: 4,
  		        maxlength: 20,
  		      alphanumeric: true
  		        
  		   },
  			"confirmPassword" : {
  		        required : true,
  		        equalTo: "#user\\.password"
  		   },
  			"securityAnswer" : {
  		        required : true
  		   },
  		   	"user.dateOfBirth" : {
  		   		required: true,
  		   	 	date: true
		   },
  			"user.firstName" : {
  		        required : true,
  		      lettersonly: true
  		   },
  			"user.address.addressLine1" : {
  		        required : true,
  		      addressvalid: true,
  		      maxlength: 200,
  		   },
  		   "user.address.addressLine2" : {
  			 addressvalid: true,
 	  		 maxlength: 200,
 	  		},
  			"user.address.city" : {
  		        required : true,
  		      notNumber:true,
  		        maxlength: 100,
  		   },
  			"user.phone" : {
  		        required : true,
  		        	number:true,
  		      mobileNumberLength: true
  		   },
  			"user.address.pin" : {
  		        required : true,
  		        number:true,
  		        zipCode:true
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
			$("#registrationForm").attr("action",webContextPath+"/user/updateuser");
		}
	}
}

jQuery.validator.addMethod("alphanumeric", function(value, element) {
	  return this.optional(element) || /^[a-zA-Z0-9_]+$/i.test(value);
	}, "Letters, numbers or underscores only please."); 

jQuery.validator.addMethod("lettersonly", function(value, element) {
	  return this.optional(element) || /^[a-zA-Z]+$/i.test(value);
	}, "Only Letters are allowed"); 

jQuery.validator.addMethod("addressvalid", function(value, element) {
	  return this.optional(element) || /^[a-zA-Z0-9 ,&-]+$/i.test(value);
	}, "Letters, numbers, space, comma are valid entries."); 

jQuery.validator.addMethod("mobileNumberLength", function(value, element) {
	var mobpattern = /^\d{10}$/;
	if (mobpattern.test(value)) {
		return true;
    }
    return false;
}, "Mobile Number Should be of 10 digits");

jQuery.validator.addMethod("zipCode", function(value, element) {
	var pinpattern = /^\d{6}$/;
	if (pinpattern.test(value)) {
        return true;
    }
    return false;
}, "Pin Code should of 6 digits");

jQuery.validator.addMethod("notNumber", function(value, element, param) {
    var reg = /[0-9]/;
    if(reg.test(value)){
          return false;
    }else{
            return true;
    }
}, "Number is not permitted");

jQuery.validator.addMethod("emailCheck", function(value, element) {
	var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
	if (pattern.test(value)) {
        return false;
    }
    return true;
}, "Please enter a valid email address");

