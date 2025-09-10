package app.code.verse.domain.model;

public class DiagnosticTestOrderItem extends OrderItem {
    public DiagnosticTestOrderItem() {
            private String testName;
            private int quantity;
            private boolean requiresSpecialist;
            private String specialistType;

            public DiagnosticTestOrderItem(int itemNumber, double cost, String testName, int quantity, boolean requiresSpecialist, String specialistType) {
                super(itemNumber, cost);
                this.testName = testName;
                this.quantity = quantity;
                this.requiresSpecialist = requiresSpecialist;
                this.specialistType = specialistType;
            }

            public String getTestName() { return testName; }
            public int getQuantity() { return quantity; }
            public boolean isRequiresSpecialist() { return requiresSpecialist; }
            public String getSpecialistType() { return specialistType; }
        }

    }
}