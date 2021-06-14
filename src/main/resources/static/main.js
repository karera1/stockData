var stock = null;
var stompClient = null;
function connect(event) {
    stock = document.querySelector('#stockname').value.trim();
    if(stock){
    var socket=new SockJS('/stockdata');
    stompClient=Stomp.over(socket);
    stompClient.connect({},onConnected, onError);
    }
    }
function onConnected() {
    stompClient.subscribe('/topic/public', onMessageReceived);


}
function addStock(){
    stompClient.send("/stock.addStock",
        {},
        JSON.stringify({stock})
    )
    connectingElement.classList.add('hidden');
}
function removeStock(){
	
}


function onError(error) {
    connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
    connectingElement.style.color = 'red';
}
    