package com.softserve.entity;

import java.util.Objects;

public class Order {
private String route;
private float cost;

    public Order(String route, float cost) {
        this.route = route;
        this.cost = cost;
    }

    public String getRoute() {
        return route;
    }

    public float getCost() {
        return cost;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Float.compare(order.cost, cost) == 0 &&
                route.equals(order.route);
    }

    @Override
    public int hashCode() {
        return Objects.hash(route, cost);
    }

    @Override
    public String toString() {
        return "Order{" +
                "route='" + route + '\'' +
                ", cost=" + cost +
                '}';
    }
}
