/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.controller;

import br.com.cwi.crescer.aula8.dominio.Pessoa;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RestController;
import br.com.cwi.crescer.aula8.service.PessoaService;

/**
 *
 * @author eduardo.ribas
 */
@RestController
public class PessoaController {

    @Autowired
    private PessoaService service;

    @RequestMapping(value = "/pessoa.json", method = GET)
    public Iterable<Pessoa> list() {
        return service.listAll();
    }

    @RequestMapping(value = "/pessoa.json", method = POST)
    public Iterable<Pessoa> list(@RequestBody Pessoa pessoa) {
        service.add(pessoa);
        return service.listAll();
    }
}
