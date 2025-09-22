package app.code.verse.infrastructure.persistence.repository;

import app.code.verse.infrastructure.persistence.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface PatientRepository extends JpaRepository<PatientEntity, Long > {
    public PatientEntity findByIdNumber(String document);

    public List<PatientEntity> findAll();
}
