package com.github.parkapi.demoparkapi.web.controller;

import com.github.parkapi.demoparkapi.entity.Usuario;
import com.github.parkapi.demoparkapi.service.UsuarioService;
import com.github.parkapi.demoparkapi.web.controller.dto.UsuarioCreateDto;
import com.github.parkapi.demoparkapi.web.controller.dto.UsuarioSenhaDto;
import com.github.parkapi.demoparkapi.web.controller.dto.mapper.UsuarioMapper;
import com.github.parkapi.demoparkapi.web.controller.dto.mapper.UsuarioResponseDto;
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
    public ResponseEntity<UsuarioResponseDto> create(@RequestBody UsuarioCreateDto createDto) {
        Usuario user = this.usuarioService.salvar(UsuarioMapper.toUsuario(createDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> getById(@PathVariable Long id) {
        Usuario user = this.usuarioService.buscarPorId(id);
        return ResponseEntity.ok(UsuarioMapper.toDto(user));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updatePassword(@PathVariable Long id, @RequestBody UsuarioSenhaDto senhaDto) {
        Usuario user = this.usuarioService.editarSenha(id, senhaDto.getSenhaAtual(), senhaDto.getNovaSenha(), senhaDto.getConfirmaSenha());
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> getAll(){
        List<Usuario> users = this.usuarioService.listarUsuarios();
        return ResponseEntity.ok(UsuarioMapper.toListDto(users));
    }
}
