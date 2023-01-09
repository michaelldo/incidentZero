package br.com.diazero.IncidentZero.repository;

import br.com.diazero.IncidentZero.repository.entity.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Long> {

    @Query(value = "SELECT  * FROM INCIDENT WHERE ID_INCIDENT = ?1", nativeQuery = true)
    Incident findIncidentById(Long idIncident);

}

