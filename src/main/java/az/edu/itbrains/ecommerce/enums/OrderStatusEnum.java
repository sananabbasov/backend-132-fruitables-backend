package az.edu.itbrains.ecommerce.enums;

public enum OrderStatusEnum {
    PENDING,        // Order has been placed but not yet processed
    PROCESSING,     // Order is being prepared
    SHIPPED,        // Order has been shipped
    DELIVERED,      // Order has been delivered to the customer
    CANCELLED,      // Order was cancelled before shipping
    RETURNED,       // Order was returned by the customer
    FAILED          // Order failed due to payment or system issue
}