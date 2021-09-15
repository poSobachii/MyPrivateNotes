
function testJS() {
     alert("JS loaded version #5")
        };

function printBasket(){
  var http = new XMLHttpRequest();
  http.open("POST", "http://localhost:8080/responses/printBasketOrder.jsp", true);
  http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
  http.send("param1=null");
  http.onload = function(){
  alert("check console");
  }
};

 function add_to_basket(name, id){
  var http = new XMLHttpRequest();
  http.open("POST", "http://localhost:8080/responses/addBasketResponse.jsp", true);
  http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
  http.send("bla2=" + name + "&blablabla=" + id);
  http.onload = function() {
  alert(http.responseText);
  }
  };

function getPDF(){
 var http = new XMLHttpRequest();
 http.open("POST", "http://localhost:8080/responses/printPDForder.jsp", true);
 http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
 http.send();
 http.onload = function() {
 alert("pdf requested");
 }
};

function getPDF2() {
     alert("JS loaded")
        };



