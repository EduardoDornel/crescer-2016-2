package br.com.cwi.crescer.aula8.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import br.com.cwi.crescer.aula8.entity.Classificacao;
/**
 * @author Carlos H. Nonnemacher
 */
public interface ClassificacaoRepository extends PagingAndSortingRepository<Classificacao, Long>{

    
}
