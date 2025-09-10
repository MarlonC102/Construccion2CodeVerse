package app.code.verse.domain.model;

public abstract class OrderItem {
        protected int itemNumber;
        protected double cost;

        public OrderItem(int itemNumber, double cost) {
            this.itemNumber = itemNumber;
            this.cost = cost;
        }

        public int getItemNumber() { return itemNumber; }
        public double getCost() { return cost; }
    }

}