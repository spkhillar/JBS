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
	var rolesUrl = webContextPath + "/user/roles";
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
	console.log('role response..', roleResponse);
	return roleResponse;
}
