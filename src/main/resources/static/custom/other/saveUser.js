$(document).ready(function(){
	console.log("hello");
	$("#saveUser") .bootstrapValidator({
		  feedbackIcons: {
			  valid: "far fa-check-circle fa-lg",
		        invalid: "far fa-times-circle fa-lg",
		        validating: "fa fa-refresh"
	        },
		  excluded: [':disabled'],
	        fields: {
	        	firstName: {
	                validators: {
	                    notEmpty: {
	                        message: "The First Name is required."
	                    }
	                }
	            },
	            address: {
                  validators: {
                      notEmpty: {
                          message: 'Address is required'
                      }
                  }
              }, email: {
                  validators: {
                      notEmpty: {
                          message: 'The email address is required and cannot be empty'
                      },
                      emailAddress: {
                          message: 'The email address is not a valid'
                      }
                  }
              },
              contactNo:{
            	  validators:{
            		  notEmpty:{
            			  message:'Contact Number is required'
            		  },
            		  integer: {
                          message: 'The value is not a number'
                      }
//            		  ,
//                      regexp: {
//                          regexp: /\\d{10}|\\d{9}/,
//                          message: 'Contact Number Should be Start with 98** with 10 digit'
//                      },
            	  }
              }
              
	        }
	    }).on('error.field.bv', function(e, data) {
	          if (data.bv.getSubmitButton()) {
	              data.bv.disableSubmitButtons(true);
	          }
	      })
	      .on('success.field.bv', function(e, data) {
	          if (data.bv.getSubmitButton()) {
	              data.bv.disableSubmitButtons(false);
	          }
	      }) 
	      .on('success.form.bv', function (e, data) {
	    	 // Prevent form submission
            e.preventDefault();
            $("span#email").hide();
    		$("span#contactNo").hide();
            addUserInfo();
            
         });
	

	function addUserInfo(){
		var formData ={
				username:$("#username").val(),
				password:$("#password").val(),
				firstName:$("#firstName").val(),
				lastName:$("#lastName").val(),
				email:$("#email").val(),
				contactNo:$("#contactNo").val(),
				gender:$("input[name='gender']:checked").val(),
				address:$("#address").val(),
				dob:$("#dob").val(),
				roles:$("#roles").val()
		}
		console.log(formData)
		$.ajax({
			type : "POST",
            url : "/admin/registration",
            contentType:"application/json",
            data : JSON.stringify(formData),
            success : function(result) {
            	console.log(result)
            	if(result.status == true && result.statusCode ==200){
            		
            	Swal.fire("User Information saved Successfully");
            		location.reload();
            	}
            },
            error:function(error){
            	console.log(error)
            	if(error.responseJSON.status == false && error.responseJSON.statusCode ==400){
            		$("span#email").hide();
            		$("span#contactNo").hide();
            		Swal.fire("Error during saving");
            	}
            	if(error.responseJSON.status == false && error.responseJSON.statusCode == 600){
            		console.log(error.responseJSON.errors.Error)
            		
            		if('email' in error.responseJSON.errors){            			
                		$("span#email").show();
                		$("span#email").html(error.responseJSON.errors.email)
            		}
            		if('contactNo' in error.responseJSON.errors){
            			$("span#contactNo").show();
                		$("span#contactNo").html(error.responseJSON.errors.contactNo)
            		}
            	
            			Swal.fire("Error during saving");
            	
            	}
            }
		})
	}
	
	
	
})