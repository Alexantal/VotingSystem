const dishAjaxUrl = "rest/dishes/";
let restId;
let restaurantName;
// https://stackoverflow.com/a/5064235/548473
const ctx = {
    ajaxUrl: dishAjaxUrl
}

/*function clearFilter() {
    $("#filter")[0].reset();
    $.get("profile/meals/", updateTableByData);
}*/

function showMenu(id, restName) {
    const rName = document.getElementById('restaurantName');
    rName.innerHTML="<h5>Меню ресторана " + restName + "</h5>";
    restId = id;
    restaurantName = restName;

    $.ajax({
        type: "GET",
        url: "rest/dishes/menu/" + id
    }).done(function (data) {
        updateTableByData(data);
    });
}

function vote() {
    $.ajax({
        type: "POST",
        url: "rest/profile/votes/" + restId
    }).done(function () {
        successNoty("Вы проголосовали за ресторан " + restaurantName);
    });
}

$(function () {
    makeEditable(
        $("#menuTable").DataTable({
            "ajax": {
                "url": dishAjaxUrl + "/menu/emptyList",
                "dataSrc": ""
            },
            "fnDrawCallback": function () {
                if ($(this).find('.dataTables_empty').length === 1) {
                    $('th').hide();
                    $('#votingBtn').hide();
                    $('.dataTables_empty').
                        html("<span class='label label-danger'><h5 align='center'>Please, choose restaurant</h5></span>");
                } else {
                    $('th').show();
                    $('#votingBtn').show();
                }
            },
            "paging": false,
            "info": false,
            "filter": false,
            "columns": [
                {
                    "data": "name"
                },
                {
                    "data": "price"
                },
            ],
            "order": [
                [
                    0,
                    "asc"
                ]
            ]
        })
    );
});
