/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import servidor.comprimirMensaje;
import servidor.descomprimirMensaje;
import javax.websocket.server.ServerEndpoint;
import servidor.mensajes;

/**
 *
 * @author Lorenzo
 */
@ServerEndpoint(value = "/chat", encoders = {comprimirMensaje.class}, decoders = {descomprimirMensaje.class})
public class Chat {

    private static final List<Session> on = new ArrayList<>();

    @OnOpen
    public void inicio(Session session) {
        on.add(session);
    }

    @OnClose
    public void cerrar(Session session) {
        on.remove(session);
    }

    @OnMessage
    public void enviarMensaje(mensajes msj) throws IOException, EncodeException {
        for (Session session : on) {
            session.getBasicRemote().sendObject(msj);
        }
    }
}
