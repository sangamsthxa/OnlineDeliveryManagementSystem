$(document).ready(function () {

    var a = $("#aboutusList").DataTable({
        ajax: {
            url: "/admin/list/about",
            dataSrc: ""
        },
        columnDefs: [{
       	 "className": 'details-control',
         "orderable": false,
         "data": null,
         "searchable":false,
         "defaultContent": ''
        }],
        columns: [{
            data: "id"
        }, {
            data: "title"
        }, 
        {
            data: "description"
        }
         ],
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