/**
 * Created by tonir on 6/24/2017.
 */

var ws;
(function(ws) {
    "use strict";
    if (window.WebSocket) {
        console.log("WebSocket object is supported in your browser");
        console.log(window.location)
        ws = new WebSocket("ws://localhost:8888/ws/handler");
        ws.onopen = function() {
            console.log("onopen");
            ws.send("Hi");
        };
        ws.onmessage = function(e) {
            console.log("echo from server : " + e.data);
            if(e.data == "9")
                ws.close();
        };
        ws.onclose = function() {
                console.log("onclose");
        };
        ws.onerror = function() {
            console.log("onerror");
        };

    } else {
        console.log("WebSocket object is not supported in your browser");
    }
})(ws);
