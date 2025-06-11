package com.gruposv.microservice_purchasing.modules.supplier.service;

import com.gruposv.microservice_purchasing.modules.supplier.dto.SupplierDTO;
import com.gruposv.microservice_purchasing.modules.supplier.mapper.SupplierMapper;
import org.springframework.stereotype.Service;

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

    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }
}
