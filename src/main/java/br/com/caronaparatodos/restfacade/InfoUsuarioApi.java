package br.com.caronaparatodos.restfacade;


import br.com.caronaparatodos.entidades.InfoUsuario;
import br.com.caronaparatodos.repositorio.InfoUsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/infousuario")
public class InfoUsuarioApi {

    @Autowired
    private InfoUsuarioDao infoUsuarioDao;


    @RequestMapping(method = RequestMethod.GET)
    public InfoUsuario atualizarInfoUsuario(@RequestBody InfoUsuario iu) {
        return infoUsuarioDao.save(iu);
    }
}
