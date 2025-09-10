package app.code.verse.domain.model;

import java.time.LocalDate;
import java.util.List;

public class Invoice {
    private String idInvoice;
    private String idPatient;
    private String patientName;
    private String doctorName;
    private String insuranceCompany;
    private String policyNumber;
    private LocalDate issueDate;
    private double totalAmount;
    private double copayAmount;
    private double insuranceCoverage;
    private List<String> servicesIncluded;

    public Invoice() {
    }

    public String getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(String idInvoice) {
        this.idInvoice = idInvoice;
    }

    public String getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(String idPatient) {
        this.idPatient = idPatient;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getCopayAmount() {
        return copayAmount;
    }

    public void setCopayAmount(double copayAmount) {
        this.copayAmount = copayAmount;
    }

    public double getInsuranceCoverage() {
        return insuranceCoverage;
    }

    public void setInsuranceCoverage(double insuranceCoverage) {
        this.insuranceCoverage = insuranceCoverage;
    }

    public List<String> getServicesIncluded() {
        return servicesIncluded;
    }

    public void setServicesIncluded(List<String> servicesIncluded) {
        this.servicesIncluded = servicesIncluded;
    }
}