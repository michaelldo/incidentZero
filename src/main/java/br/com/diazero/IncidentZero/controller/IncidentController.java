package br.com.diazero.IncidentZero.controller;

import br.com.diazero.IncidentZero.repository.entity.Incident;
import br.com.diazero.IncidentZero.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IncidentController {

    @Autowired
    private IncidentService service;

    @RequestMapping("/index")
    public String index(@Autowired Incident incident, Model model){

        incident = new Incident();
        List<Incident> incidentList = service.listAllIncidents();

        model.addAttribute("incidents", incidentList);
        model.addAttribute("incident", incident);
        return "layout/index.html";
    }
}
