package com.gruposv.microservice_purchasing.modules.supplier.service;

import com.gruposv.microservice_purchasing.modules.supplier.dto.SupplierDTO;
import com.gruposv.microservice_purchasing.modules.supplier.mapper.SupplierMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gruposv.microservice_purchasing.modules.supplier.entity.SupplierEntity;
import com.gruposv.microservice_purchasing.modules.supplier.repository.SupplierRepository;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;

    @Autowired
    public SupplierService(SupplierRepository supplierRepository,
                           SupplierMapper supplierMapper) {
        this.supplierRepository = supplierRepository;
        this.supplierMapper = supplierMapper;
    }

    public SupplierEntity saveSupplier(SupplierEntity supplier) {
        return supplierRepository.save(supplier);
    }

    public List<SupplierDTO> getAllSuppliersDTO() {
        List<SupplierEntity> entities = supplierRepository.findAll();
        return entities.stream()
                .map(supplierMapper::toDTO)
                .toList();
    }

    @Transactional
    public SupplierDTO updateSupplier(Long id, SupplierEntity updatedSupplierData) {
        SupplierEntity existingSupplier = supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado com id: " + id));

        existingSupplier.setName(updatedSupplierData.getName());
        existingSupplier.setDocumentNumber(updatedSupplierData.getDocumentNumber());
        existingSupplier.setAddress(updatedSupplierData.getAddress());
        existingSupplier.setContactPhone(updatedSupplierData.getContactPhone());
        existingSupplier.setContactEmail(updatedSupplierData.getContactEmail());
        existingSupplier.setPaymentTerms(updatedSupplierData.getPaymentTerms());
        existingSupplier.setBankAccountInfo(updatedSupplierData.getBankAccountInfo());
        existingSupplier.setSupplierRating(updatedSupplierData.getSupplierRating());

        SupplierEntity savedEntity = supplierRepository.save(existingSupplier);

        return supplierMapper.toDTO(savedEntity); // aqui a mágica: retorna DTO!
    }



    @Transactional
    public void deleteSupplier(Long id) {
        SupplierEntity supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado com id: " + id));

        supplier.setDeletedAt(LocalDateTime.now());
        supplierRepository.save(supplier);
    }

}
