$(document).ready(function () {
	console.log("here")
    var a = $("#userList").DataTable({
        ajax: {
            url: "/list/users",
            dataSrc: ""
        },
        columnDefs: [{
            searchable: false,
            orderable: false,
            targets: 0
        }],
        columns: [{
            data: "id"
        }, {
            data: "firstName"
        }, 
        {
            data: "lastName"
        },
        {
            data: "email"
        },
        {
            data: "contactNo"
        },{
            data: "userName"
        },
        {
            data: "roleName"
        },{
            data: "address"
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



});