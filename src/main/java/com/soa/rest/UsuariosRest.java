/**
 * 
 */
package com.soa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soa.business.UsuariosBusiness;
import com.soa.dto.Request;
import com.soa.dto.Respuesta;
import com.soa.dto.Usuario;
import com.soa.enums.Crud;

/**
 * 
 */
@RestController
public class UsuariosRest {

    @Autowired
    private UsuariosBusiness usuariosBusiness;

    @GetMapping("/usuario/{login}")
    public ResponseEntity<Respuesta> consultar(@PathVariable String login) {
        ResponseEntity<Respuesta> re = null;

        Request request = new Request();
        Usuario usuario = new Usuario();
        usuario.setLogin(login);
        request.setUsuario(usuario);
        request.setOperacion(Crud.READ.getValue());

        Respuesta respuesta = usuariosBusiness.procesar(request);

        re = new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);

        return re;
    }

    /**
     * Implementacion de alta con post
     * 
     * @param usuario Usuario a modificar
     * @return Resuesta informando el resultado
     */
    @RequestMapping(method = RequestMethod.POST, path = "/usuario")
    public ResponseEntity<Respuesta> crear(@RequestBody Usuario usuario) {
        ResponseEntity<Respuesta> re = null;

        Request request = new Request();
        request.setUsuario(usuario);
        request.setOperacion(Crud.CREATE.getValue());

        Respuesta respuesta = usuariosBusiness.procesar(request);

        re = new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
        return re;
    }

    /**
     * Implementacion de baja con Delete
     * 
     * @param usuario Usuario a modificar
     * @return Resuesta informando el resultado
     */
    @RequestMapping(method = RequestMethod.DELETE, path = "/usuario")
    public ResponseEntity<Respuesta> borrar(@RequestBody Usuario usuario) {
        ResponseEntity<Respuesta> re = null;

        Request request = new Request();
        request.setUsuario(usuario);
        request.setOperacion(Crud.DELETE.getValue());

        Respuesta respuesta = usuariosBusiness.procesar(request);

        re = new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
        return re;
    }

    /**
     * Implementacion de modificar con PUT.
     * @param usuario Usuario a modificar
     * @return Resuesta informando el resultado
     */
    @RequestMapping(method = RequestMethod.PUT, path = "/usuario")
    public ResponseEntity<Respuesta> modificar(@RequestBody Usuario usuario) {
        ResponseEntity<Respuesta> re = null;

        Request request = new Request();
        request.setUsuario(usuario);
        request.setOperacion(Crud.UPDATE.getValue());

        Respuesta respuesta = usuariosBusiness.procesar(request);

        re = new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
        return re;
    }

}
