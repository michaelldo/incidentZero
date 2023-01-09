package br.com.diazero.IncidentZero.rest;

import br.com.diazero.IncidentZero.repository.entity.Incident;
import br.com.diazero.IncidentZero.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IncidentRestController {

    @Autowired
    private IncidentService incidentService;

    @ResponseBody
    @PostMapping(value = "createIncident")
    public ResponseEntity<Incident> createIncident(@RequestBody Incident incident){
         Incident result = incidentService.createIncident(incident);
         return new ResponseEntity<Incident>(result, HttpStatus.CREATED);
    }

    @ResponseBody
    @GetMapping(value = "incidents")
    public ResponseEntity<List<Incident>> incidentList(){
        List<Incident> incidents = incidentService.listAllIncidents();
        return new ResponseEntity<List<Incident>>(incidents, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(value = "/updateIncident")
    public ResponseEntity<?> updateIncident(@RequestBody Incident incident){

        if (incident.getIdIncident() == null){
            return new ResponseEntity<String>("Houve um problema para Atualizar o Incidente: ID não informado!",
                    HttpStatus.OK);
        }
        Incident updated = incidentService.updateIncident(incident);
        return new ResponseEntity<Incident>(updated, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(value = "/closeIncident")
    public ResponseEntity<?> closeIncident(@RequestBody Incident incident){

        if (incident.getIdIncident() == null){
            return new ResponseEntity<String>("Houve um problema para Atualizar o Incidente: ID não informado!",
                    HttpStatus.OK);
        }
        Incident closed = incidentService.closeIncident(incident);
        return new ResponseEntity<Incident>(closed, HttpStatus.OK);
    }

    @ResponseBody
    @DeleteMapping(value = "/deleteIncident/{id}")
    public ResponseEntity<String> deleteIncidentById(@PathVariable Long id){
        incidentService.deleteIncidentById(id);
        return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping(value = "/incidentById/{id}")
    public ResponseEntity<Incident> incidentById(@PathVariable Long id){
        Incident incident = incidentService.findIncidentById(id);
        return new ResponseEntity<Incident>(incident, HttpStatus.OK);
    }
}
