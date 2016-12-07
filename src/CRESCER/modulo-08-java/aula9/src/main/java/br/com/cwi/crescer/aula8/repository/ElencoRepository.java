package br.com.cwi.crescer.aula8.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import br.com.cwi.crescer.aula8.entity.Elenco;
/**
 * @author Carlos H. Nonnemacher
 */
public interface ElencoRepository extends PagingAndSortingRepository<Elenco, Long>{

    
}
