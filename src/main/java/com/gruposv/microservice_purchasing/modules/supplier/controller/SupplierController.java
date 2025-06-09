package com.gruposv.microservice_purchasing.modules.supplier.controller;

import java.util.List;

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

     // GET ALL
     @GetMapping
     public ResponseEntity<List<SupplierEntity>> getAllSuppliers() {
         List<SupplierEntity> suppliers = supplierService.getAllSuppliers();
         return ResponseEntity.ok(suppliers);
     }
 
     // DELETE com mensagem de confirmação
     @DeleteMapping("/{id}")
     public ResponseEntity<String> deleteSupplier(@PathVariable Long id) {
         supplierService.deleteSupplier(id);
         return ResponseEntity.ok("Fornecedor com id " + id + " deletado com sucesso.");
     }
}
