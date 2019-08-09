$(document).ready(function(){
	
	$("#blog").on("click", function(){
		console.log("here")
	}
		addBlogInfo();
		function addBlogInfo(){
			
			var formData= {
					var title= $("#title").val(),
					var description=$("#description").val()
			}
			
			$.ajax({
				type : "POST",
	            url : "/admin/save/blog",
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
	            		
	            		Swal.fire("Error during saving");
	            	}
			
		}
		
		
		
	});
		}
	
});