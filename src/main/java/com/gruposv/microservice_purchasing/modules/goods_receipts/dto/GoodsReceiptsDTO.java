package com.gruposv.microservice_purchasing.modules.goods_receipts.dto;

import com.gruposv.microservice_purchasing.modules.goods_receipts.enums.GoodsReceiptStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsReceiptsDTO {
    private Long id;
    private Long purchaseOrderId;
    private LocalDate receiptDate;
    private String invoiceNumber;
    private BigDecimal invoiceAmount;
    private GoodsReceiptStatus status;
}
