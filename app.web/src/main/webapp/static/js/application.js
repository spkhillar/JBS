var webContextPath;
var homeDataObject;
var trueOrFalseOption = "true:true;false:false";
var jqgridUserRolesFilter;

$(document).ready(function() {

	jqgridUserRolesFilter = getRoles();
	startTime();
});

function startTime() {
	$('#dateTime').text(getDateTime());
	t = setTimeout(function() {
		startTime();
	}, 500);
}



function getDateTime() {
	var today = new Date();

	var month = today.getMonth() + 1;
	var day = today.getDate();

	var output = today.getFullYear() + '/'
			+ (('' + month).length < 2 ? '0' : '') + month + '/'
			+ (('' + day).length < 2 ? '0' : '') + day;

	var h = today.getHours();
	var m = today.getMinutes();
	var s = today.getSeconds();
	// add a zero in front of numbers<10
	m = checkTime(m);
	s = checkTime(s);
	var finalTime = output + " " + h + ":" + m + ":" + s;
	return finalTime;
}

function checkTime(i) {
	if (i < 10) {
		i = "0" + i;
	}
	return i;
}

function getRoles() {
	/*var rolesUrl = webContextPath + "/user/roles";
	var roleResponse = "";
	$.ajax({
		type : "get",
		url : rolesUrl,
		async : false,
		success : function(data, textStatus) {
			roleResponse = data;
		},
		error : function(textStatus, errorThrown) {
		}
	});
	//console.log('role response..', roleResponse);
	return roleResponse;*/
}

function loadJobDetails(jobId){
	//console.log('..webContextPath+"/mypage/jobdetail"',webContextPath+"/mypage/jobdetail");
	 $.ajax({
		    url: webContextPath+"/admin/job/view/"+jobId,
		    dataType:'html',
		    success: function(data){
		      //construct the data however, update the HTML of the popup div 
		      $('#jobdetailsdiv').html(data);
		      $('#jobdetailsdiv').dialog({
		  		modal: 'true',
		  		height:700,
		  		width:850,
		  		closeOnEscape: true,
		  		buttons: [ { text: "Apply", click: 
			  			function() {
			  				alert("..Will get back to you soon..");
			  				$( this ).dialog( "close" ); 
			  			} 
		  			},
		  				{ text: "Cancel", click: function() 
		  				{
		  					$( this ).dialog( "close" ); 
		  				} 
		  			}]
		      }).show();
		    }
		  });
}

function loadTermsAndConditions(){
	//console.log('..webContextPath+"/mypage/jobdetail"',webContextPath+"/mypage/jobdetail");
	 $.ajax({
		    url: webContextPath+"/register/view/terms/",
		    dataType:'html',
		    success: function(data){
		      //construct the data however, update the HTML of the popup div 
		      $('#termsandconditiondiv').html(data);
		      $('#termsandconditiondiv').dialog({
		  		modal: 'true',
		  		height:700,
		  		width:850,
		  		closeOnEscape: true
		  	  }).show();
		    }
		  });
}
