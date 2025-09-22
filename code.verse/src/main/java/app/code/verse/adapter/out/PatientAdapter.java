package app.code.verse.adapter.out;

import app.code.verse.domain.model.Patient;
import app.code.verse.domain.ports.PatientPort;
import app.code.verse.infrastructure.persistence.entities.PatientEntity;
import app.code.verse.infrastructure.persistence.mapper.PatientMapper;
import app.code.verse.infrastructure.persistence.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientAdapter implements PatientPort {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient create(Patient patient) throws Exception {
        PatientEntity entitySave = PatientMapper.toEntity(patient);
        PatientEntity save = patientRepository.save(entitySave);
        return PatientMapper.toDomain(save);
    }

    @Override
    public void deleteById(Patient patient) throws Exception {

    }

    @Override
    public void update(Patient patient) throws Exception {

    }

    @Override
    public Patient findByIdNumber(String idNumber) {
        return null;
    }

    @Override
    public List<Patient> findAll() {
        return List.of();
    }
}
