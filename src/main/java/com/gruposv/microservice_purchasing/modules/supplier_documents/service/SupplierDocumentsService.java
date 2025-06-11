package com.gruposv.microservice_purchasing.modules.supplier_documents.service;

import com.gruposv.microservice_purchasing.modules.supplier.entity.SupplierEntity;
import com.gruposv.microservice_purchasing.modules.supplier_documents.dto.SupplierDocumentsDTO;
import com.gruposv.microservice_purchasing.modules.supplier_documents.mapper.SupplierDocumentsMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gruposv.microservice_purchasing.modules.supplier_documents.entity.SupplierDocumentsEntity;
import com.gruposv.microservice_purchasing.modules.supplier_documents.repository.SupplierDocumentsRepository;

@Service
public class SupplierDocumentsService {

    private final SupplierDocumentsRepository supplierDocumentsRepository;
    private final SupplierDocumentsMapper supplierDocumentsMapper;

    @Autowired
    public SupplierDocumentsService(SupplierDocumentsRepository supplierDocumentsRepository, SupplierDocumentsMapper supplierDocumentsMapper) {
        this.supplierDocumentsRepository = supplierDocumentsRepository;
        this.supplierDocumentsMapper = supplierDocumentsMapper;
    }

    public SupplierDocumentsEntity saveSupplierDocuments(SupplierDocumentsEntity supplierDocuments) {
        return supplierDocumentsRepository.save(supplierDocuments);
    }


    public List<SupplierDocumentsDTO> getAllSupplierDocumentsDTO() {
        List<SupplierDocumentsEntity> entities = supplierDocumentsRepository.findAll();
        return entities.stream()
                .map(supplierDocumentsMapper::toDTO)
                .toList();
    }

    @Transactional
    public SupplierDocumentsDTO updateSupplierDocuments(Long id, SupplierDocumentsDTO updatedDTO) {
        SupplierDocumentsEntity existingDocument = supplierDocumentsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Documento não encontrado com id: " + id));

        existingDocument.setDocumentType(updatedDTO.getDocumentType());
        existingDocument.setValidUntil(updatedDTO.getValidUntil());
        existingDocument.setFilePath(updatedDTO.getFilePath());

        if (!existingDocument.getSupplier().getId().equals(updatedDTO.getSupplierId())) {
            SupplierEntity newSupplier = new SupplierEntity();
            newSupplier.setId(updatedDTO.getSupplierId());
            existingDocument.setSupplier(newSupplier);
        }

        SupplierDocumentsEntity savedEntity = supplierDocumentsRepository.save(existingDocument);

        return supplierDocumentsMapper.toDTO(savedEntity);
    }


    @Transactional
    public void deleteSupplierDocuments(Long id) {
        SupplierDocumentsEntity document = supplierDocumentsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Documento não encontrado com id: " + id));

        document.setDeletedAt(LocalDateTime.now());
        supplierDocumentsRepository.save(document);
    }

}
