/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.service;

import br.com.cwi.crescer.aula8.dominio.Pessoa;
import org.springframework.stereotype.Service;
import br.com.cwi.crescer.aula8.repository.PessoaRepository;

/**
 *
 * @author eduardo.ribas
 */
@Service
public class PessoaService {
    
  //  private List<Pessoa> pessoas;
    private PessoaRepository pessoas;
    
    public Iterable<Pessoa> list() {
        return pessoas.findAll();
    }   
    
    public void add(Pessoa pessoa){
        pessoas.save(pessoa);
    }
    
    
}
