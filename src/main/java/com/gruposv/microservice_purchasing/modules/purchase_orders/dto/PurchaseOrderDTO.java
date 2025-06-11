package com.gruposv.microservice_purchasing.modules.purchase_orders.dto;

import com.gruposv.microservice_purchasing.modules.purchase_orders.enums.PurchaseOrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrderDTO {
    private Long id;
    private Long supplierId;
    private String orderNumber;
    private LocalDate orderDate;
    private LocalDate expectedDeliveryDate;
    private PurchaseOrderStatus status;
    private BigDecimal totalAmount;
    private String currency;
    private String paymentTerms;
}
