package com.gruposv.microservice_purchasing.modules.goods_receipts.mapper;

import com.gruposv.microservice_purchasing.modules.goods_receipts.dto.GoodsReceiptsDTO;
import com.gruposv.microservice_purchasing.modules.goods_receipts.entity.GoodsReceiptsEntity;
import com.gruposv.microservice_purchasing.modules.purchase_orders.entity.PurchaseOrdersEntity;
import org.springframework.stereotype.Component;

@Component
public class GoodsReceiptsMapper {

    public GoodsReceiptsDTO toDTO(GoodsReceiptsEntity entity) {
        if (entity == null) {
            return null;
        }

        return new GoodsReceiptsDTO(
                entity.getId(),
                entity.getPurchaseOrder().getId(),
                entity.getReceiptDate(),
                entity.getInvoiceNumber(),
                entity.getInvoiceAmount(),
                entity.getStatus()
        );
    }

    public GoodsReceiptsEntity toEntity(GoodsReceiptsDTO dto) {
        if (dto == null) {
            return null;
        }

        GoodsReceiptsEntity entity = new GoodsReceiptsEntity();
        entity.setId(dto.getId());

        PurchaseOrdersEntity purchaseOrder = new PurchaseOrdersEntity();
        purchaseOrder.setId(dto.getPurchaseOrderId());
        entity.setPurchaseOrder(purchaseOrder);
        entity.setReceiptDate(dto.getReceiptDate());
        entity.setInvoiceNumber(dto.getInvoiceNumber());
        entity.setInvoiceAmount(dto.getInvoiceAmount());
        entity.setStatus(dto.getStatus());

        return entity;
    }
}
