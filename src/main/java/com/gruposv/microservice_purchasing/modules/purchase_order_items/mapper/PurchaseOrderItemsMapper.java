package com.gruposv.microservice_purchasing.modules.purchase_order_items.mapper;

import com.gruposv.microservice_purchasing.modules.purchase_order_items.dto.PurchaseOrderItemsDTO;
import com.gruposv.microservice_purchasing.modules.purchase_order_items.entity.PurchaseOrderItemsEntity;
import com.gruposv.microservice_purchasing.modules.purchase_orders.entity.PurchaseOrdersEntity;
import org.springframework.stereotype.Component;

@Component
public class PurchaseOrderItemsMapper {

    public PurchaseOrderItemsDTO toDTO(PurchaseOrderItemsEntity entity) {
        if (entity == null) {
            return null;
        }

        return new PurchaseOrderItemsDTO(
                entity.getId(),
                entity.getPurchaseOrder().getId(),
                entity.getProductId(),
                entity.getDescription(),
                entity.getQuantity(),
                entity.getUnitPrice(),
                entity.getLineTotal()
        );
    }

    public PurchaseOrderItemsEntity toEntity(PurchaseOrderItemsDTO dto) {
        if (dto == null) {
            return null;
        }

        PurchaseOrderItemsEntity entity = new PurchaseOrderItemsEntity();
        entity.setId(dto.getId());

        PurchaseOrdersEntity purchaseOrder = new PurchaseOrdersEntity();
        purchaseOrder.setId(dto.getPurchaseOrderId());
        entity.setPurchaseOrder(purchaseOrder);
        entity.setProductId(dto.getProductId());
        entity.setDescription(dto.getDescription());
        entity.setQuantity(dto.getQuantity());
        entity.setUnitPrice(dto.getUnitPrice());
        entity.setLineTotal(dto.getLineTotal());

        return entity;
    }
}
