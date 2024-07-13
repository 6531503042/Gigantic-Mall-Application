package com.gigantic.admin.Config.Specifications;

import java.util.Date;

import com.gigantic.entity.Orders.Order;
import com.gigantic.entity.Orders.OrderStatus;
import com.gigantic.entity.Orders.PaymentMethods;
import org.springframework.data.jpa.domain.Specification;

public class OrderSpecifications {

    //Search By Status
    public static Specification<Order> hasStatus(OrderStatus status) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("status"), status);
    }

    public static Specification<Order> hasCustomerId(Long customerId) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("customer").get("id"), customerId);
    }

    public static Specification<Order> hasPaymentMethod(PaymentMethods paymentMethod) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("paymentMethod"), paymentMethod);
    }

    public static Specification<Order> hasOrderTime(Date orderTime) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("orderTime"), orderTime);
    }

    public static Specification<Order> sortByHighestPrice(float totalPrice) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("totalPrice"), totalPrice);
    }

    public static Specification<Order> sortByLowestPrice(float totalPrice) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("totalPrice"), totalPrice);
    }


}
