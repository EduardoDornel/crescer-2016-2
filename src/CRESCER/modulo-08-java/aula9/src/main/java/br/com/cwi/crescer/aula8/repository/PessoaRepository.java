package br.com.cwi.crescer.aula8.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import br.com.cwi.crescer.aula8.entity.Pessoa;
/**
 * @author Carlos H. Nonnemacher
 */
public interface PessoaRepository extends PagingAndSortingRepository<Pessoa, Long>{

    
}
