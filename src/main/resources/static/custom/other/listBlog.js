$(document).ready(function () {

    var a = $("#blogList").DataTable({
        ajax: {
            url: "/list/blog",
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
        },
        , {
            data: null,
            className: "center",
            defaultContent: '<div class="fa fa-edit" style="color:green;font-size: xx-large;" ></div> / <div  class="fa fa-trash" style="color:red;font-size: xx-large;"></div>'
        } ],
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