package com.gruposv.microservice_purchasing.modules.po_approvals.mapper;

import com.gruposv.microservice_purchasing.modules.po_approvals.dto.PoApprovalsDTO;
import com.gruposv.microservice_purchasing.modules.po_approvals.entity.PoApprovalsEntity;
import com.gruposv.microservice_purchasing.modules.purchase_orders.entity.PurchaseOrdersEntity;
import org.springframework.stereotype.Component;

@Component
public class PoApprovalsMapper {

    public PoApprovalsDTO toDTO(PoApprovalsEntity entity) {
        if (entity == null) {
            return null;
        }

        return new PoApprovalsDTO(
                entity.getId(),
                entity.getPurchaseOrder().getId(),
                entity.getApprovedBy(),
                entity.getApprovalDate(),
                entity.getStatus(),
                entity.getComments()
        );
    }

    public PoApprovalsEntity toEntity(PoApprovalsDTO dto) {
        if (dto == null) {
            return null;
        }

        PoApprovalsEntity entity = new PoApprovalsEntity();
        entity.setId(dto.getId());

        PurchaseOrdersEntity purchaseOrder = new PurchaseOrdersEntity();
        purchaseOrder.setId(dto.getPurchaseOrderId());
        entity.setPurchaseOrder(purchaseOrder);
        entity.setApprovedBy(dto.getApprovedBy());
        entity.setApprovalDate(dto.getApprovalDate());
        entity.setStatus(dto.getStatus());
        entity.setComments(dto.getComments());

        return entity;
    }
}
