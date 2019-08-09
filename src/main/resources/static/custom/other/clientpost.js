$(document).ready(function () {
    var a = $("#serviceList").DataTable({
        ajax: {
            url: "/get/clientpost/",
            dataSrc: ""
        },
        columnDefs: [{
            searchable: false,
            orderable: false,
            targets: 0
        }],
        columns: [{
            data: "id"
        },
        {
            data: "createdBy"
        },{
            data: "source"
        }, 
        {
            data: "destination"
        },
        {
            data: "distances"
        },
         {
			data: "enable",
			"render": function(data, type, row) {
				if (row.enable === true) {
					return '<div class="template-demo">\
															<button type="button" class="btn btn-success" id="active">Accept</button><div>';
				} else {
					return '<div class="template-demo">\
														      <button type="button" class="btn btn-danger" id="deactive">Done</button></div>';
				}
			}
		}],
        order: [0, "asc"]
    });
    a.on("order.dt search.dt", function () {
        a.column(0, {
            search: "applied",
            order: "applied"
        }).nodes().each(function (a, b) {
            a.innerHTML = "00" + (b + 1);
        });
    }).draw();
    
    
    
    
	$("#serviceList tbody").on("click", "button#active", function() {
		var b = a.row($(this).parents("tr")).data();
		swal({
			title: "Are you sure?",
			text: "Are You Sure, You are going to Deactivate This Account",
			icon: "warning",
			buttons: true,
			dangerMode: true,
		}).then((Delete) => {
			if (Delete) {
				$.ajax({
					type: "GET",
					contentType: "application/json",
					url: '/deactive/account?status=' + false + '&id=' + b.id,
					success: function(result) {
						swal('Success', "Deactive Account " + result.message, 'success');
						$('#serviceList').DataTable().ajax.reload();
					},
					error: function(error) {
						swal('Error', "Error in Deactive Account", 'Error');
					}
				})
			} else {
				swal("Account Is Not Deactive!");
			}
		});
	})
	$("#serviceList tbody").on("click", "button#deactive", function() {
		var b = a.row($(this).parents("tr")).data();
		swal({
			title: "Are you sure?",
			text: "Are You Sure, You are going to Active This Account",
			icon: "warning",
			buttons: true,
			dangerMode: true,
		}).then((Delete) => {
			if (Delete) {
				$.ajax({
					type: "GET",
					contentType: "application/json",
					url: '/active/account?status=' + true + '&id=' + b.id,
					success: function(result) {
						swal('Success', "Active Account " + result.message, 'success');
						$('#serviceList').DataTable().ajax.reload();
					},
					error: function(error) {
						swal('Error', "Error in Active Account", 'Error');
					}
				})
			} else {
				swal("Account Is Not Active!");
			}
		});
	})



});