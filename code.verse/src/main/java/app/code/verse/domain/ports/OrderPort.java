package app.code.verse.domain.ports;

import app.code.verse.domain.model.Order;

public interface OrderPort {
    public void addOrder(Order order);

}
