package ar.com.estudiocs.controller;


import ar.com.estudiocs.entities.Especialidades;
import ar.com.estudiocs.services.IEspecialidadesService;
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
public class EspecialidadesController {

    @Autowired
    IEspecialidadesService especialidadesService;

    @RequestMapping(value = "/especialidades", method = RequestMethod.GET)
    public String list(Model model, Pageable pageable) {
        Page<Especialidades> centroPage = especialidadesService.findAll(pageable);
        PageWrapper<Especialidades> page = new PageWrapper<Especialidades>(centroPage, "/especialidades");
        model.addAttribute("entities", page.getContent());
        model.addAttribute("page", page);
        model.addAttribute("entity", new Especialidades());
        return "../especialidades/index";
    }

    @RequestMapping("especialidades/refresh")
    public String refresh() {
        return "redirect:/especialidades";
    }

    @RequestMapping(value = "especialidades/search", method = RequestMethod.POST)
    public String search(Model model, Especialidades entity) {
        if (entity.getEspecialidad().equals("")) {
            return refresh();
        }
        model.addAttribute("entities", especialidadesService.findByEspecialidad(entity.getEspecialidad()));
        model.addAttribute("entity", new Especialidades());
        model.addAttribute("page", null);
        return "../especialidades/index";
    }

    @RequestMapping("especialidades/create/{id}")
    public String create(@PathVariable Integer id, Model model) {
        model.addAttribute("entity", new Especialidades());
        return "../especialidades/edit";
    }

    @RequestMapping("especialidades/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("entity", especialidadesService.get(id));
        return "../especialidades/edit";
    }

    @RequestMapping(value = "especialidades", method = RequestMethod.POST)
    public String save(Model model, @Validated Especialidades entity) {
        if (entity.getEspecialidad().equals("")) {
            model.addAttribute("message", "Descripción Incorrecta");
            model.addAttribute("entity", entity);
            return "../especialidades/edit";
        }

        especialidadesService.save(entity);
        return "redirect:/especialidades";
    }

    @RequestMapping("especialidades/delete/{id}")
    public String delete(@PathVariable Integer id, Model model, Pageable pageable) {
        try {
            Especialidades entity = especialidadesService.get(id);
            especialidadesService.delete(entity);
            return "redirect:/especialidades";
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage().toString());
            Page<Especialidades> centroPage = especialidadesService.findAll(pageable);
            PageWrapper<Especialidades> page = new PageWrapper<Especialidades>(centroPage, "/especialidades");
            model.addAttribute("entities", page.getContent());
            model.addAttribute("page", page);
            model.addAttribute("entity", new Especialidades());
            return "../especialidades/index";
        }
    }

}
