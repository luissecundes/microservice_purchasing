package com.gruposv.microservice_purchasing.modules.goods_receipt_items.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsReceiptItemsDTO {
    private Long id;
    private Long goodsReceiptId;
    private Long purchaseOrderItemId;
    private BigDecimal quantityReceived;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;
}
