package br.com.cwi.crescer.aula8.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import br.com.cwi.crescer.aula8.entity.Filme;
/**
 * @author Carlos H. Nonnemacher
 */
public interface FilmeRepository extends PagingAndSortingRepository<Filme, Long>{

    
}
