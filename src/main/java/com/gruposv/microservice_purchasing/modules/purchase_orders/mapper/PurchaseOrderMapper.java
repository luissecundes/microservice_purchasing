package com.gruposv.microservice_purchasing.modules.purchase_orders.mapper;

import com.gruposv.microservice_purchasing.modules.purchase_orders.dto.PurchaseOrderDTO;
import com.gruposv.microservice_purchasing.modules.purchase_orders.entity.PurchaseOrdersEntity;
import org.springframework.stereotype.Component;

@Component
public class PurchaseOrderMapper {

    public PurchaseOrderDTO toDTO(PurchaseOrdersEntity entity) {
        if (entity == null) {
            return null;
        }

        return new PurchaseOrderDTO(
                entity.getId(),
                entity.getSupplier().getId(),
                entity.getOrderNumber(),
                entity.getOrderDate(),
                entity.getExpectedDeliveryDate(),
                entity.getStatus(),
                entity.getTotalAmount(),
                entity.getCurrency(),
                entity.getPaymentTerms()
        );
    }

    public PurchaseOrdersEntity toEntity(PurchaseOrderDTO dto) {
        if (dto == null) {
            return null;
        }

        PurchaseOrdersEntity entity = new PurchaseOrdersEntity();
        entity.setId(dto.getId());

        var supplier = new com.gruposv.microservice_purchasing.modules.supplier.entity.SupplierEntity();
        supplier.setId(dto.getSupplierId());
        entity.setSupplier(supplier);
        entity.setOrderNumber(dto.getOrderNumber());
        entity.setOrderDate(dto.getOrderDate());
        entity.setExpectedDeliveryDate(dto.getExpectedDeliveryDate());
        entity.setStatus(dto.getStatus());
        entity.setTotalAmount(dto.getTotalAmount());
        entity.setCurrency(dto.getCurrency());
        entity.setPaymentTerms(dto.getPaymentTerms());

        return entity;
    }
}
