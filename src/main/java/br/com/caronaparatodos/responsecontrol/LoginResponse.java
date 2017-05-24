package br.com.caronaparatodos.responsecontrol;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class LoginResponse implements Serializable{

    private String motivo;
    private String erro;

    public LoginResponse(String erro, String motivo) {
        this.motivo = motivo;
        this.erro = erro;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }
}
