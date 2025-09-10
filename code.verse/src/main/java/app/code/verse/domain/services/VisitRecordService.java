package app.code.verse.domain.services;

import app.code.verse.domain.model.VisitRecord;
import app.code.verse.domain.ports.VisitRecordRepositoryPort;
import app.code.verse.domain.ports.VisitRecordServicePort;
import java.time.LocalDate;
import java.util.Map;

public class VisitRecordService implements VisitRecordServicePort {
    private final VisitRecordRepositoryPort repository;

    public VisitRecordService(VisitRecordRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public VisitRecord createVisitRecord(VisitRecord record) {
        validatePatient(record.getIdPatient());
        validateDate(record.getIdPatient(), record.getDate());
        validateDoctor(record.getIdDoctor());
        validateReason(record.getReason());
        validateVitalSigns(record.getVitalSigns());
        validateDiagnosisRules(record);
        repository.save(record.getIdPatient(), record);
        return record;
    }

    @Override
    public VisitRecord getVisitByDate(String idPatient, String dateKey) {
        return repository.findByDate(idPatient, dateKey);
    }

    private void validatePatient(String idPatient) {
        if (idPatient == null || idPatient.isEmpty()) {
            throw new IllegalArgumentException("La visita debe estar asociada a un idPatient válido.");
        }
    }

    private void validateDate(String idPatient, LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("La visita debe tener una fecha.");
        }
        VisitRecord existing = repository.findByDate(idPatient, date.toString());
        if (existing != null) {
            throw new IllegalArgumentException("Ya existe una visita registrada para este paciente en esa fecha.");
        }
    }

    private void validateDoctor(String doctorId) {
        if (doctorId == null || doctorId.isEmpty()) {
            throw new IllegalArgumentException("La visita debe estar asociada a un médico válido.");
        }
    }

    private void validateReason(String reason) {
        if (reason == null || reason.isEmpty()) {
            throw new IllegalArgumentException("El motivo de la consulta es obligatorio.");
        }
    }

    private void validateVitalSigns(Map<String, String> vitalSigns) {
        if (vitalSigns == null || vitalSigns.isEmpty()) {
            throw new IllegalArgumentException("Se deben registrar signos vitales en la visita.");
        }
        if (!vitalSigns.containsKey("pressure") ||
                !vitalSigns.containsKey("temperature") ||
                !vitalSigns.containsKey("pulse") ||
                !vitalSigns.containsKey("oxygen")) {
            throw new IllegalArgumentException("Los signos vitales deben incluir presión, temperatura, pulso y oxígeno.");
        }
    }

    private void validateDiagnosisRules(VisitRecord record) {
        boolean hasDiagnosis = record.getDiagnosis() != null && !record.getDiagnosis().isEmpty();

        if (!hasDiagnosis && (record.getSymptoms() != null && !record.getSymptoms().isEmpty())) {
            throw new IllegalArgumentException("Si la visita es solo por ayuda diagnóstica, no puede incluir medicamentos ni procedimientos.");
        }
    }
}
