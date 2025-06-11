package com.gruposv.microservice_purchasing.modules.supplier_documents.mapper;

import org.springframework.stereotype.Component;

import com.gruposv.microservice_purchasing.modules.supplier_documents.dto.SupplierDocumentsDTO;
import com.gruposv.microservice_purchasing.modules.supplier_documents.entity.SupplierDocumentsEntity;

@Component
public class SupplierDocumentsMapper {

    public SupplierDocumentsDTO toDTO(SupplierDocumentsEntity entity) {
        if (entity == null) {
            return null;
        }

        return new SupplierDocumentsDTO(
                entity.getId(),
                entity.getSupplier().getId(),
                entity.getDocumentType(),
                entity.getValidUntil(),
                entity.getFilePath()
        );
    }

    public SupplierDocumentsEntity toEntity(SupplierDocumentsDTO dto) {
        if (dto == null) {
            return null;
        }

        SupplierDocumentsEntity entity = new SupplierDocumentsEntity();
        entity.setId(dto.getId());

        // Aqui você vai precisar associar o SupplierEntity em outro ponto,
        // porque com o DTO você só tem o supplierId.
        // Em um Service ou Controller, você pode fazer um findById(supplierId)
        // e associar o SupplierEntity na hora de salvar.

        entity.setDocumentType(dto.getDocumentType());
        entity.setValidUntil(dto.getValidUntil());
        entity.setFilePath(dto.getFilePath());

        return entity;
    }
}
