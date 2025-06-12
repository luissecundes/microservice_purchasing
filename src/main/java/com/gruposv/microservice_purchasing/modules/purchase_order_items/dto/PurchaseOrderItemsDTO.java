package com.gruposv.microservice_purchasing.modules.purchase_order_items.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrderItemsDTO {
    private Long id;
    private Long purchaseOrderId;
    private Long productId;
    private String description;
    private BigDecimal quantity;
    private BigDecimal unitPrice;
    private BigDecimal lineTotal;
}
