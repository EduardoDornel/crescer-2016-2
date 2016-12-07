/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.controller;

import br.com.cwi.crescer.aula8.entity.Elenco;
import br.com.cwi.crescer.aula8.service.AtorService;
import br.com.cwi.crescer.aula8.service.ElencoService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Eduardo
 */
@Controller
@RequestMapping("/elenco")
public class ElencoController {

    @Autowired
    ElencoService service;
    
    @Autowired
    AtorService atorService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model, @RequestParam(required = false) Long id, Pageable p) {
        Pageable pageable = new PageRequest(p.getPageNumber(), 5, p.getSort());

        Elenco elenco = new Elenco();
        if (id != null) {
            elenco = service.findOne(id);
            pageable = null;
        }
        if (pageable == null) {
            pageable = new PageRequest(0, 10);
        }
        model.addAttribute("elenco", elenco);
        model.addAttribute("atores", atorService.findAll());
        model.addAttribute("elencos", service.findAll(pageable));
        return "elenco";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@Valid Elenco elenco, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (!bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("msg", "Registro salvo com sucesso!");
            service.save(elenco);
            return "redirect:elenco";
        }
        return "elenco";
    }
}
