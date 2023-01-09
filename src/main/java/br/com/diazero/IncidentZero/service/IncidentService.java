package br.com.diazero.IncidentZero.service;

import br.com.diazero.IncidentZero.repository.entity.Incident;

import java.util.List;

public interface IncidentService {

    Incident createIncident (Incident incident);

    List<Incident> listAllIncidents();

    Incident updateIncident(Incident incident);

    Incident closeIncident(Incident incident);

    void deleteIncidentById(Long idIncident);

    Incident findIncidentById(Long idIncident);

}
