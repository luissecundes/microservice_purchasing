package com.gruposv.microservice_purchasing.modules.supplier.controller;

import java.util.List;

import com.gruposv.microservice_purchasing.modules.supplier.dto.SupplierDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gruposv.microservice_purchasing.modules.supplier.entity.SupplierEntity;
import com.gruposv.microservice_purchasing.modules.supplier.service.SupplierService;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    private final SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping
    public ResponseEntity<SupplierEntity> createSupplier(@RequestBody SupplierEntity supplier) {
        SupplierEntity savedSupplier = supplierService.saveSupplier(supplier);
        return ResponseEntity.ok(savedSupplier);
    }

    @GetMapping
    public ResponseEntity<List<SupplierDTO>> getAllSuppliers() {
        List<SupplierDTO> suppliers = supplierService.getAllSuppliersDTO();
        return ResponseEntity.ok(suppliers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierDTO> updateSupplier(@PathVariable Long id, @RequestBody SupplierEntity updatedSupplier) {
        SupplierDTO savedSupplierDTO = supplierService.updateSupplier(id, updatedSupplier);
        return ResponseEntity.ok(savedSupplierDTO);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return ResponseEntity.ok("Fornecedor com id " + id + " deletado com sucesso.");
    }
}
