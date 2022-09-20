package ar.com.estudiocs.controller;

import ar.com.estudiocs.entities.Categorias;
import ar.com.estudiocs.services.ICategoriasService;
import ar.com.estudiocs.utiles.PageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class CategoriasController {

        @Autowired
        ICategoriasService categoriasService;

        @RequestMapping(value = "/categorias", method = RequestMethod.GET)
        public String list(Model model, Pageable pageable) {
            Page<Categorias> centroPage = categoriasService.findAll(pageable);
            PageWrapper<Categorias> page = new PageWrapper<Categorias>(centroPage, "/categorias");
            model.addAttribute("entities", page.getContent());
            model.addAttribute("page", page);
            model.addAttribute("entity", new Categorias());
            return "../categorias/index";
        }

        @RequestMapping("categorias/refresh")
        public String refresh() {
            return "redirect:/categorias";
        }

        @RequestMapping(value = "categorias/search", method = RequestMethod.POST)
        public String search(Model model, Categorias entity) {
            if (entity.getDescripcion().equals("")) {
                return refresh();
            }
            model.addAttribute("entities", categoriasService.findByDescripcion(entity.getDescripcion()));
            model.addAttribute("entity", new Categorias());
            model.addAttribute("page", null);
            return "../categorias/index";
        }

        @RequestMapping("categorias/create/{id}")
        public String create(@PathVariable Integer id, Model model) {
            model.addAttribute("entity", new Categorias());
            return "../categorias/edit";
        }

        @RequestMapping("categorias/edit/{id}")
        public String edit(@PathVariable Integer id, Model model) {
            model.addAttribute("entity", categoriasService.get(id));
            return "../categorias/edit";
        }

        @RequestMapping(value = "categorias", method = RequestMethod.POST)
        public String save(Model model, @Validated Categorias entity) {
            if (entity.getDescripcion().equals("")) {
                model.addAttribute("message", "Descripción Incorrecta");
                model.addAttribute("entity", entity);
                return "../categorias/edit";
            }

            categoriasService.save(entity);
            return "redirect:/categorias";
        }

        @RequestMapping("categorias/delete/{id}")
        public String delete(@PathVariable Integer id, Model model, Pageable pageable) {
            try {
                Categorias entity = categoriasService.get(id);
                categoriasService.delete(entity);
                return "redirect:/categorias";
            } catch (Exception e) {
                model.addAttribute("message", e.getMessage().toString());
                Page<Categorias> centroPage = categoriasService.findAll(pageable);
                PageWrapper<Categorias> page = new PageWrapper<Categorias>(centroPage, "/categorias");
                model.addAttribute("entities", page.getContent());
                model.addAttribute("page", page);
                model.addAttribute("entity", new Categorias());
                return "../categorias/index";
            }
        }

    }