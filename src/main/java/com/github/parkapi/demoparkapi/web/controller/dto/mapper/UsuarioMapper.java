package com.github.parkapi.demoparkapi.web.controller.dto.mapper;

import com.github.parkapi.demoparkapi.entity.Usuario;
import com.github.parkapi.demoparkapi.web.controller.dto.UsuarioCreateDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

public class UsuarioMapper {

    public static Usuario toUsuario(UsuarioCreateDto createDto){
        return new ModelMapper().map(createDto, Usuario.class);
    }

    public static UsuarioCreateDto toUsuario(Usuario usuario){
        String role = usuario.getRole().name().substring("ROLE_".length());
        PropertyMap<Usuario, UsuarioResponseDto> props = new PropertyMap<Usuario, UsuarioResponseDto>() {
            @Override
            protected void configure() {
                map().setRole(role);
            }
        };

        return new ModelMapper().map(createDto, Usuario.class);
    }
}
