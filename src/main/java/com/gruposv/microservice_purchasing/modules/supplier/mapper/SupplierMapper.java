package com.gruposv.microservice_purchasing.modules.supplier.mapper;

import org.springframework.stereotype.Component;

import com.gruposv.microservice_purchasing.modules.supplier.dto.SupplierDTO;
import com.gruposv.microservice_purchasing.modules.supplier.entity.SupplierEntity;

@Component
public class SupplierMapper {

    public SupplierDTO toDTO(SupplierEntity entity) {
        if (entity == null) {
            return null;
        }

        return new SupplierDTO(
                entity.getId(),
                entity.getName(),
                entity.getDocumentNumber(),
                entity.getAddress(),
                entity.getContactPhone()
        );
    }
}
