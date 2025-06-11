package com.gruposv.microservice_purchasing.modules.supplier_documents.service;

import com.gruposv.microservice_purchasing.modules.supplier_documents.dto.SupplierDocumentsDTO;
import com.gruposv.microservice_purchasing.modules.supplier_documents.mapper.SupplierDocumentsMapper;
import org.springframework.stereotype.Service;

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



    public void deleteSupplierDocuments(Long id) {
        supplierDocumentsRepository.deleteById(id);
    }
}
