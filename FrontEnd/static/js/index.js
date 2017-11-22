function getAllStocks(){
    $.ajax({
        type: "GET",
        url: "http://193.1.166.84:9001/stockprice",
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
    console.log(response);
    // $('#here').html(response.age);
    var table = "<table class='table' id='stockTable'>"+
                    "<thead>"+
                        "<tr>"+
                            "<th>Name</th>"+
                            "<th>Age</th>"+
                        "</tr>"+
                    "</thead>"+
                    "<tbody>";
                    for(oneResponse in response){
                        table = table + "<tr>"+
                                    "<td>"+oneResponse[stockName]+
                                    "<td>"+oneResponse[stockPrice]+
                                "</tr>";
                    }
                table=table+"</tbody>"+
                "</table>";
    $('#allStocksTable').html(table)
    setTimeout(function(){getAllStocks();}, 1000);
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
    setTimeout(function(){getAllPlayers();}, 1000);
}

function errorAllPlayers(response){

    console.log("Error Players");
}
getAllStocks();
getAllPlayers();