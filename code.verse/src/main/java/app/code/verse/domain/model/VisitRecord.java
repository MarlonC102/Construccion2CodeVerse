package app.code.verse.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Map;

public class VisitRecord {
    private String idVisitRecord;
    private String idPatient;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate date;
    private String idDoctor;
    private String reason;
    private String symptoms;
    private String diagnosis;
    private Map<String, String> vitalSigns;
    public VisitRecord() {}

    public String getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(String idPatient) {
        this.idPatient = idPatient;
    }

    public String getIdVisitRecord() {
        return idVisitRecord;
    }

    public void setIdVisitRecord(String idVisitRecord) {
        this.idVisitRecord = idVisitRecord;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(String idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Map<String, String> getVitalSigns() {
        return vitalSigns;
    }

    public void setVitalSigns(Map<String, String> vitalSigns) {
        this.vitalSigns = vitalSigns;
    }
}