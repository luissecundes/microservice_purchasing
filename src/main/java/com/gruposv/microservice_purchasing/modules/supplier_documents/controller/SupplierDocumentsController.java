package com.gruposv.microservice_purchasing.modules.supplier_documents.controller;

import java.util.List;

import com.gruposv.microservice_purchasing.modules.supplier_documents.dto.SupplierDocumentsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gruposv.microservice_purchasing.modules.supplier_documents.entity.SupplierDocumentsEntity;
import com.gruposv.microservice_purchasing.modules.supplier_documents.service.SupplierDocumentsService;

@RestController
@RequestMapping("/api/suppliers-documents")
public class SupplierDocumentsController {

    private final SupplierDocumentsService supplierDocumentsService;

    @Autowired
    public SupplierDocumentsController(SupplierDocumentsService supplierDocumentsService) {
        this.supplierDocumentsService = supplierDocumentsService;
    }

    @PostMapping
    public ResponseEntity<SupplierDocumentsEntity> createSupplier(@RequestBody SupplierDocumentsEntity supplierDocuments) {
        SupplierDocumentsEntity savedSupplier = supplierDocumentsService.saveSupplierDocuments(supplierDocuments);
        return ResponseEntity.ok(savedSupplier);
    }


    @GetMapping
    public ResponseEntity<List<SupplierDocumentsDTO>> getAllSupplierDocuments() {
        List<SupplierDocumentsDTO> documents = supplierDocumentsService.getAllSupplierDocumentsDTO();
        return ResponseEntity.ok(documents);
    }


    // DELETE com mensagem
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSupplierDocuments(@PathVariable Long id) {
        supplierDocumentsService.deleteSupplierDocuments(id);
        return ResponseEntity.ok("Documento do fornecedor com id " + id + " deletado com sucesso.");
    }
}
