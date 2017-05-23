package br.com.caronaparatodos.repositorio;

import br.com.caronaparatodos.entidades.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDao extends CrudRepository<Usuario, Integer> {

    Usuario findByLogin(String login);

}
