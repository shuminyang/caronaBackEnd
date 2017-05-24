package br.com.caronaparatodos.restfacade;

import br.com.caronaparatodos.entidades.Usuario;
import br.com.caronaparatodos.repositorio.UsuarioDao;
import br.com.caronaparatodos.responsecontrol.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginApi {

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public LoginResponse logar(@RequestBody Usuario u) {

        Usuario usuario = usuarioDao.findByLogin(u.getLogin());

        if (usuario == null) {
            return new LoginResponse("Erro no login.", "Login não encontrado");
        } else {
            String salt = usuario.getSenha().split(",")[1];
            String senhaHash = encriptarSenha(u, salt);

            if (!usuario.getSenha().equals(senhaHash + "," + salt)) {
                return new LoginResponse("Erro no login.", "Senha incorreta");
            }

            return new LoginResponse(null,"Login permitido.");
        }
    }

    private String encriptarSenha(Usuario u, String salt) {
        String hash_pass = BCrypt.hashpw(u.getSenha(), salt);
        return hash_pass;
    }
}
