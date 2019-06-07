$(document).ready(function(){
	console.log("hello");
	$("#userForm") .bootstrapValidator({
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
				passwordConfirm:$("#passwordConfirm").val(),
				firstName:$("#firstName").val(),
				lastName:$("#lastName").val(),
				email:$("#email").val(),
				contactNo:$("#contactNo").val(),
				gender:$("input[name='gender']:checked").val(),
				address:$("#address").val(),
				dob:$("#dob").val()
		}
		console.log(formData)
		$.ajax({
			type : "POST",
            url : "/save/registration",
            contentType:"application/json",
            data : JSON.stringify(formData),
            success : function(result) {
            	console.log(result)
            	if(result.status == true && result.statusCode ==200){
            		
            		$.toast({
            		    heading: result.message,
            		    text: 'User Info Save Successfully',
            		    position: 'top-right',
            		    hideAfter: 5000 ,
            		    icon: 'success',
            		    stack: true
            		});
            		location.reload();
            	}
            },
            error:function(error){
            	console.log(error)
            	if(error.responseJSON.status == false && error.responseJSON.statusCode ==400){
            		$("span#email").hide();
            		$("span#contactNo").hide();
            		$.toast({
            		    heading: error.responseJSON.message,
            		    text: 'Please Provide Valid Customer Information',
            		    position: 'top-right',
            		    hideAfter: 5000 ,
            		    icon: 'error',
            		    stack: false
            		})
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
            		$.toast({
            		    heading: error.responseJSON.message,
            		    text: 'Please Provide Valid Customer Information',
            		    position: 'top-right',
            		    hideAfter: 5000 ,
            		    icon: 'error',
            		    stack: false
            		})
            	}
            }
		})
	}
	
	
	
})