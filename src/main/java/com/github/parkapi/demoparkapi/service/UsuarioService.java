package com.github.parkapi.demoparkapi.service;

import com.github.parkapi.demoparkapi.entity.Usuario;
import com.github.parkapi.demoparkapi.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    public Usuario buscarPorId(Long id) {
        return this.usuarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado!")
        );
    }

    @Transactional
    public Usuario editarSenha(Long id, String senhaAtual,String novaSenha, String confirmaSenha) {
        if(!novaSenha.equals(confirmaSenha)){
             throw new RuntimeException("Nova senha não confere com confirmação de senha.");
        }

        Usuario user = buscarPorId(id);

        if(!user.getPassword().equals(senhaAtual)){
            throw new RuntimeException("Sua senha não confere");
        }

        user.setPassword(novaSenha);
        return user;
    }

    public List<Usuario> listarUsuarios(){
        List<Usuario> listUsers =  this.usuarioRepository.findAll();
        if(listUsers.isEmpty()){
            throw new RuntimeException("Usuarios não localizados!");
        }
        return listUsers;
    }
}
