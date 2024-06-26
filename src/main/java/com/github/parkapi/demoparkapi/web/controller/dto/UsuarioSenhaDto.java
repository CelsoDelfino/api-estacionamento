package com.github.parkapi.demoparkapi.web.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioSenhaDto {

    @NotBlank
    @Size(min = 6, max = 6, message = "A senha deve possuir 6 caracteres")
    private String senhaAtual;
    @NotBlank
    @Size(min = 6, max = 6, message = "A senha deve possuir 6 caracteres")
    private String novaSenha;
    @NotBlank
    @Size(min = 6, max = 6, message = "A senha deve possuir 6 caracteres")
    private String confirmaSenha;

    public UsuarioSenhaDto() {
    }

    public UsuarioSenhaDto(String senhaAtual, String novaSenha, String confirmaSenha) {
        this.senhaAtual = senhaAtual;
        this.novaSenha = novaSenha;
        this.confirmaSenha = confirmaSenha;
    }

    public String getSenhaAtual() {
        return senhaAtual;
    }

    public void setSenhaAtual(String senhaAtual) {
        this.senhaAtual = senhaAtual;
    }

    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }
}
