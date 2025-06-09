package com.gruposv.microservice_purchasing.modules.supplier.service;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gruposv.microservice_purchasing.modules.supplier.entity.SupplierEntity;
import com.gruposv.microservice_purchasing.modules.supplier.repository.SupplierRepository;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public SupplierEntity saveSupplier(SupplierEntity supplier) {
        return supplierRepository.save(supplier);
    }

     // GET ALL
     public List<SupplierEntity> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    // DELETE
    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }
}
