package com.weslleycabral.workshopmongodb.resources;import com.weslleycabral.workshopmongodb.dto.UserDTO;import com.weslleycabral.workshopmongodb.entities.User;import com.weslleycabral.workshopmongodb.services.UserService;import jakarta.servlet.http.HttpServlet;import jakarta.servlet.http.HttpServletRequest;import jakarta.websocket.server.PathParam;import jdk.javadoc.doclet.Taglet;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.http.ResponseEntity;import org.springframework.web.bind.annotation.*;import org.springframework.web.context.support.HttpRequestHandlerServlet;import org.springframework.web.servlet.support.ServletUriComponentsBuilder;import java.net.URI;import java.util.List;import java.util.Locale;@RestController@RequestMapping(value = "/users")public class UserResource {    @Autowired    private UserService service;    @GetMapping    public ResponseEntity<List<UserDTO>> findAll() {        return ResponseEntity.ok().body(service.findAll());    }    @GetMapping(value = "/{id}")    public ResponseEntity<UserDTO> findById(@PathVariable String id) {        return ResponseEntity.ok().body(service.findById(id));    }    @PostMapping    public ResponseEntity<Void> create(@RequestBody UserDTO userDTO) {        var obj = service.create(service.fromDTO(userDTO));        URI uri =                ServletUriComponentsBuilder.fromCurrentRequest()                        .path("/{id}")                        .buildAndExpand(obj.getId())                        .toUri();        return ResponseEntity.created(uri).build();    }}