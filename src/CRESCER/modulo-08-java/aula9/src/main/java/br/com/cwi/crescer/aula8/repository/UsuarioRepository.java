package br.com.cwi.crescer.aula8.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import br.com.cwi.crescer.aula8.entity.Usuario;
/**
 * @author Carlos H. Nonnemacher
 */
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long>{

    
}
