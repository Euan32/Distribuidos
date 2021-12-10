/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (window, document, JSON) {
    'use strict';
    var url = 'ws://' + window.location.host + '/proyectoSalud/chat',
            ws = new WebSocket(url),
            mensajes = document.getElementById('conversacion'),
            boton = document.getElementById('boton'),
            nombre = document.getElementById('usuario'),
            mensaje = document.getElementById('mensaje');
//            solicitud = 'El sistema de salud, hace una solicitud del expendiente medico del paciente, es necesario\n\
//la autorizacion del mismo en un mensaje, al igual es necesario el nombre del paciente',
//            btn = document.getElementById('btn');

    ws.onopen = onOpen;
    ws.onclose = onClose;
    ws.onmessage = onMessage;

    boton.addEventListener('click', enviar);
//    btn.addEventListener('click', Solicitud);
    function onOpen() {
        console.log('Conectando...');
    }
    function onClose() {
        console.log('Desconectando...');
    }
    function onMessage(evt) {
        var obj = JSON.parse(evt.data),
                msj = 'Nombre: ' + obj.nombre + '<br/>' + 'Petición: ' + obj.mensaje;
        mensajes.innerHTML += '<br/>' + msj;
    }

    function enviar() {
        var msj = {
            nombre: nombre.value,
            mensaje: mensaje.value
        };
        ws.send(JSON.stringify(msj));
    }
   
//    function Solicitud() {
//        var msj ={
//          solicitud: solicitud.value  
//        };
//        ws.send(JSON.stringify(msj));
//    }
})(window, document, JSON);
