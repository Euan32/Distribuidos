/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.IOException;
import java.io.Reader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author Lorenzo
 */
public class descomprimirMensaje implements Decoder.TextStream<mensajes>{

    @Override
    public mensajes decode(Reader reader) throws DecodeException, IOException {
        mensajes msj = new mensajes();
        try(JsonReader JsonRead = Json.createReader(reader)){
            JsonObject json = JsonRead.readObject();
            msj.setNombre(json.getString("nombre"));
            msj.setMensaje(json.getString("mensaje"));
//            msj.setMensaje(json.getString("solicitud"));
        }
        return msj;
    }

    @Override
    public void init(EndpointConfig config) {
     
    }

    @Override
    public void destroy() {
       
    }
    
}
