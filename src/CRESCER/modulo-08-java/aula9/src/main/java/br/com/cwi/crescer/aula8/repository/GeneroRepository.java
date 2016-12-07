package br.com.cwi.crescer.aula8.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import br.com.cwi.crescer.aula8.entity.Genero;
/**
 * @author Carlos H. Nonnemacher
 */
public interface GeneroRepository extends PagingAndSortingRepository<Genero, Long>{

    
}
