package br.com.cwi.crescer.aula8.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import br.com.cwi.crescer.aula8.entity.Idioma;
/**
 * @author Carlos H. Nonnemacher
 */
public interface IdiomaRepository extends PagingAndSortingRepository<Idioma, Long>{

    
}
