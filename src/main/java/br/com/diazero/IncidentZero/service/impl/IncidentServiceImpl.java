package br.com.diazero.IncidentZero.service.impl;

import br.com.diazero.IncidentZero.repository.IncidentRepository;
import br.com.diazero.IncidentZero.repository.entity.Incident;
import br.com.diazero.IncidentZero.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class IncidentServiceImpl implements IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;

    @Override
    public Incident createIncident(Incident incident) {

        incident.setCreateAt(new Date());
        return incidentRepository.save(incident);
    }

    @Override
    public List<Incident> listAllIncidents() {
        return incidentRepository.findAll();
    }

    @Override
    public Incident updateIncident(Incident incident) {

        Incident updateIncident = incidentRepository.findIncidentById(incident.getIdIncident());

        updateIncident.setDescriptionIncident(incident.getDescriptionIncident());
        updateIncident.setIdIncident(incident.getIdIncident());
        updateIncident.setName(incident.getName());
        updateIncident.setUpdateAt(new Date());

        return incidentRepository.saveAndFlush(updateIncident);
    }

    @Override
    public Incident closeIncident(Incident incident) {

        Incident updateIncident = incidentRepository.findIncidentById(incident.getIdIncident());

        updateIncident.setClosedAt(new Date());
        return incidentRepository.saveAndFlush(updateIncident);
    }

    @Override
    public void deleteIncidentById(Long idIncident) {
        incidentRepository.deleteById(idIncident);
    }

    @Override
    public Incident findIncidentById(Long idIncident) {
        return incidentRepository.findIncidentById(idIncident);
    }
}
