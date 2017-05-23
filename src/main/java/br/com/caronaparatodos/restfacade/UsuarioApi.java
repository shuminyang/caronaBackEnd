package br.com.caronaparatodos.restfacade;


import br.com.caronaparatodos.entidades.InfoUsuario;
import br.com.caronaparatodos.entidades.Usuario;
import br.com.caronaparatodos.repositorio.InfoUsuarioDao;
import br.com.caronaparatodos.repositorio.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RequestMapping("/api/usuario")
@RestController
public class UsuarioApi {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private InfoUsuarioDao infoUsuarioDao;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Usuario> listarUsuarios() {
        return usuarioDao.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public Usuario criarUsuario(@RequestBody Usuario u) {
        Calendar c = Calendar.getInstance();
        u.getInfoUsuario().setDataInclusao(c.getTime());
        InfoUsuario iu = infoUsuarioDao.save(u.getInfoUsuario());

        u = encriptarSenha(u);
        u.setIdUsuario(iu.getIdInfoUsuario());
        return usuarioDao.save(u);
    }

    private Usuario encriptarSenha(Usuario u) {
        String salt = BCrypt.gensalt();
        String hash_pass = BCrypt.hashpw(u.getSenha(), salt);

        u.setSenha(hash_pass + "," + salt);
        return u;
    }

}
