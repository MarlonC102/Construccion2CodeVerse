package app.code.verse.domain.model;

public class MedicineOrderItem extends OrderItem {
            private String medicineName;
            private String dose;
            private String treatmentDuration;

            public MedicineOrderItem(int itemNumber, double cost, String medicineName, String dose, String treatmentDuration) {
                super(itemNumber, cost);
                this.medicineName = medicineName;
                this.dose = dose;
                this.treatmentDuration = treatmentDuration;
            }

            public String getMedicineName() { return medicineName; }
            public String getDose() { return dose; }
            public String getTreatmentDuration() { return treatmentDuration; }
        }