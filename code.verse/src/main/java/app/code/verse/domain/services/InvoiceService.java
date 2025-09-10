package app.code.verse.domain.services;

import app.code.verse.domain.model.Invoice;
import java.util.List;
import java.util.UUID;

public class InvoiceService {
    private boolean hasServices(List<String> servicesIncluded) {
        return servicesIncluded != null && !servicesIncluded.isEmpty();
    }
    private double calculateCopay(double totalAmount, boolean policyActive) {
        if (!policyActive) {
            return totalAmount;
        }
        return Math.min(50000, totalAmount);
    }

    private boolean hasExceededAnnualCopayLimit(double accumulatedCopays, int year) {
        return accumulatedCopays >= 1_000_000;
    }

    private boolean isNewYear(int lastInvoiceYear, int currentYear) {
        return lastInvoiceYear < currentYear;
    }

    private boolean validateInvoiceData(Invoice invoice) {
        return invoice.getIdInvoice() != null &&
                invoice.getPatientName() != null &&
                invoice.getDoctorName() != null &&
                invoice.getIssueDate() != null &&
                hasServices(invoice.getServicesIncluded());
    }

    private void addServiceDetails(Invoice invoice, List<String> services) {
        invoice.setServicesIncluded(services);
    }

    private String generateInvoiceId() {
        return UUID.randomUUID().toString();
    }
}
