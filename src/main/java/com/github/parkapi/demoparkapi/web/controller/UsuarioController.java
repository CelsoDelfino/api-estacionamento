package com.github.parkapi.demoparkapi.web.controller;

import com.github.parkapi.demoparkapi.entity.Usuario;
import com.github.parkapi.demoparkapi.service.UsuarioService;
import com.github.parkapi.demoparkapi.web.controller.dto.UsuarioCreateDto;
import com.github.parkapi.demoparkapi.web.controller.dto.mapper.UsuarioMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody UsuarioCreateDto createDto) {
        Usuario user = this.usuarioService.salvar(UsuarioMapper.toUsuario(createDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Long id) {
        Usuario user = this.usuarioService.buscarPorId(id);
        return ResponseEntity.ok(user);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Usuario> updatePassword(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario user = this.usuarioService.editarSenha(id, usuario.getPassword());
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll(){
        List<Usuario> users = this.usuarioService.listarUsuarios();
        return ResponseEntity.ok(users);
    }
}
