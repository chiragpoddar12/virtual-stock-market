
// Stock Market Interaction
// ===============================================================================
function getAllStocks(){
    $.ajax({
        type: "GET",
        url: "http://localhost:8092/stockUpdates",
        async: false,
        success: successAllStocks,
        error: errorAllStocks
    });
    // $('div.feedback-box').html(feedback);
}

function successAllStocks(response){
    console.log("success Stocks");
    console.log(response.stockName);
    // $('#here').html(response.age);
    var table = "<table class='table' id='stockTable'>"+
                    "<thead>"+
                        "<tr>"+
                            "<th>Name</th>"+
                            "<th>Price</th>"+
                        "</tr>"+
                    "</thead>"+
                    "<tbody>";
                    for(var i=0; i<response.length; i++){
                        table = table + "<tr>"+
                                    "<td>"+JSON.parse(response[i]).stockName+
                                    "<td>"+JSON.parse(response[i]).stockPrice+
                                "</tr>";
                    }
                table=table+"</tbody>"+
                "</table>";
    $('#allStocksTable').html(table)
    setTimeout(function(){getAllStocks();}, 10000);
}

function errorAllStocks(response){

    console.log("Error Stocks");
    setTimeout(function(){getAllStocks();}, 10000);
}


// Bank Interaction
// ===============================================================================

function getPlayerDetails(){
    $.ajax({
        type: "GET",
        url: "http://localhost:8091/Bank?id=chi",
        async: false,
        success: successPlayerDetails,
        error: errorPlayerDetails
    });
}

function successPlayerDetails(response){
    console.log("success Player Details");
    console.log(response.stockName);
    // $('#here').html(response.age);
    var table = "<table class='table' id='stockTable'>"+
                    "<thead>"+
                        "<tr>"+
                            "<th>Share Name</th>"+
                            "<th>Quantity</th>"+
                        "</tr>"+
                    "</thead>"+
                    "<tbody>";
                    for(var i=0; i<response.length; i++){
                        table = table + "<tr>"+
                                    "<td>"+JSON.parse(response[i]).ShareName+
                                    "<td>"+JSON.parse(response[i]).ShareQty+
                                "</tr>";
                    }
                table=table+"</tbody>"+
                "</table>";
    $('#myStocksTable').html(table)
    setTimeout(function(){getPlayerDetails();}, 10000);
}

function errorPlayerDetails(response){

    console.log("Error Player Details");
    setTimeout(function(){getPlayerDetails();}, 10000);
}
// ================================================================================

getAllStocks();
// getPlayerDetails();