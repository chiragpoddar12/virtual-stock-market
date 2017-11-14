function getAllStocks(){
    $.ajax({
        type: "GET",
        url: "http://localhost:9000/allStocks",
        async: false,
        success: successAllStocks,
        error: errorAllStocks
    });
    // $('div.feedback-box').html(feedback);
}

function getAllPlayers(){
    $.ajax({
        type: "GET",
        url: "http://localhost:9000/allPlayers",
        async: false,
        success: successAllPlayers,
        error: errorAllPlayers
    });
    // $('div.feedback-box').html(feedback);
}

function successAllStocks(response){
    console.log("success Stocks");
    // $('#here').html(response.age);
    var table = "<table class='table' id='stockTable'>"+
                    "<thead>"+
                        "<tr>"+
                            "<th>Name</th>"+
                            "<th>Age</th>"+
                        "</tr>"+
                    "</thead>"+
                    "<tbody>"+
                        "<tr>"+
                            "<td>"+response.name+
                            "<td>"+response.age+
                        "</tr>"+
                        "<tr>"+
                            "<td>xya"+
                            "<td>xya"+
                        "</tr>"+
                    "</tbody>"+
                "</table>";
    $('#allStocksTable').html(table)
    setTimeout(function(){getAllStocks();}, 10000);
}

function errorAllStocks(response){

    console.log("Error Stocks");
}

function successAllPlayers(response){
    console.log("success Players");
    var table = "<table class='table' id='playerTable'>"+
                    "<thead>"+
                        "<tr>"+
                            "<th>Name</th>"+
                            "<th>Age</th>"+
                        "</tr>"+
                    "</thead>"+
                    "<tbody>"+
                        "<tr>"+
                            "<td>"+response.name+
                            "<td>"+response.age+
                        "</tr>"+
                        "<tr>"+
                            "<td>xya"+
                            "<td>xya"+
                        "</tr>"+
                    "</tbody>"+
                "</table>";
    $('#allPlayersTable').html(table);
    setTimeout(function(){getAllPlayers();}, 10000);
}

function errorAllPlayers(response){

    console.log("Error Players");
}
getAllStocks();
getAllPlayers();