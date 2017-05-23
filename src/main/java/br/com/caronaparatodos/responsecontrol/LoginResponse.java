package br.com.caronaparatodos.responsecontrol;

public class LoginResponse {

    private String motivo;
    private String erro;

    public LoginResponse(String erro, String motivo) {
        this.motivo = motivo;
        this.erro = erro;
    }

}
