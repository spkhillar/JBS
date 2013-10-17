$(document).ready(function() {	
		$("#job\\.postedAt").datepicker({dateFormat: "dd/mm/yy" });
		$("#save").button();
		$("#jobForm").validate( {
		    success : "valid",
		    ignoreTitle : true,
		    rules : {
				"job.jobTitle" : {
			        required : true,
			        lettersonly: true,
			        maxlength: 100
			     },
				"job.companyName" : {
			        required : true,
			        number: false,
			        lettersonly: true,
			        maxlength: 200,
			        
			   },
				"job.companyUrl" : {
			        url : true,
			        maxlength: 200
			   },
				"job.companyJobUrl" : {
			        url : true,
			        maxlength: 200
			   },
				"job.jobCode" : {
					maxlength:50
			   },
				"job.postedAt" : {
			        required : true,
			        date:true
			   },
				"job.qualification" : {
			        required : true
			   },
				"job.salary" : {
			        required : true,
			        maxlength: 50,
			        numericHyphenCheck: true
			        
			   },
				"designation" : {
			        required : true,
			        lettersonly: true,
			        maxlength: 100
			        
			   },
				"job.experiance" : {
			        required : true
			   },
				"job.location" : {
			        required : true,
			        lettersonly: true,
			        maxlength: 200
			      
			   },
				"job.skill" : {
			        required : true,
			        maxlength: 500
			   },
			   "job.keyword" : {
			       maxlength: 2000
			   }, 
				"job.jobDescription" : {
			        required : true,
			        maxlength: 5000
			   }, 
			     "selectedDegreeList" : {
			        required : true
			   }, 
			     "otherDesignation" : {
			    	 maxlength: 2000
			   },
			   "job.jobValidDuration": {
			    	 max: 100
			   },
			   "job.ageLimit": {
			    	 maxlength: 20,
			    	 numericHyphenCheck: true
			   }
		    }
		});
		
		handleSelectedQualification();
	});
	function postJob(){
		$("#selectedDegreeList > option").each(function(index, option) {
		    $(this).attr("selected",true);   
		});
		var isValid = $("#jobForm").valid();
		console.log('Form Valid...',isValid);
		
		if(isValid){
			$("#jobForm").attr("action",webContextPath+"/admin/job/post");
			$("#jobForm").submit();
		}
		
	}
	
	function handleSelectedQualification(){
		$("#btnRight").button();
		$("#btnLeft").button();
		 $('#btnRight').click(function(e) {
		        var selectedOpts = $('#degreeList option:selected');
		        if (selectedOpts.length == 0) {
		            alert("Nothing to move.");
		            e.preventDefault();
		        }

		        $('#selectedDegreeList').append($(selectedOpts).clone());
		        $(selectedOpts).remove();
		        e.preventDefault();
		    });

		    $('#btnLeft').click(function(e) {
		        var selectedOpts = $('#selectedDegreeList option:selected');
		        if (selectedOpts.length == 0) {
		            alert("Nothing to move.");
		            e.preventDefault();
		        }

		        $('#degreeList').append($(selectedOpts).clone());
		        $(selectedOpts).remove();
		        e.preventDefault();
		    });
	}
	
	jQuery.validator.addMethod("lettersonly", function(value, element) {
		  return this.optional(element) || /^[a-zA-Z]+$/i.test(value);
		}, "Only Letters are allowed"); 
	
	jQuery.validator.addMethod("numericHyphenCheck", function(value, element) {
		  return this.optional(element) || /^[a-zA-Z0-9-]+$/i.test(value);
		}, "Numeric and hyphens");
	