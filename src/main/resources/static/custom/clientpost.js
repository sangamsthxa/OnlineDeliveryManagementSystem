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
        }, {
            data: "source"
        }, {
            data: "destination"
        }, {
            data: "distances"
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