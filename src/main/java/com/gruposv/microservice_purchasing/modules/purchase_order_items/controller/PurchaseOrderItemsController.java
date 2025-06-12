package com.gruposv.microservice_purchasing.modules.purchase_order_items.controller;

import com.gruposv.microservice_purchasing.modules.purchase_order_items.dto.PurchaseOrderItemsDTO;
import com.gruposv.microservice_purchasing.modules.purchase_order_items.entity.PurchaseOrderItemsEntity;
import com.gruposv.microservice_purchasing.modules.purchase_order_items.service.PurchaseOrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/purchase-order-items")
public class PurchaseOrderItemsController {

    private final PurchaseOrderItemsService service;

    @Autowired
    public PurchaseOrderItemsController(PurchaseOrderItemsService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PurchaseOrderItemsDTO> create(@RequestBody PurchaseOrderItemsDTO dto) {
        PurchaseOrderItemsDTO saved = service.save(dto);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<PurchaseOrderItemsDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PurchaseOrderItemsDTO> update(@PathVariable Long id, @RequestBody PurchaseOrderItemsDTO updatedDTO) {
        PurchaseOrderItemsDTO updatedItem = service.updatePurchaseOrderItem(id, updatedDTO);
        return ResponseEntity.ok(updatedItem);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        service.deleteById(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Item com id " + id + " foi deletado com sucesso.");
        return ResponseEntity.ok(response);
    }
}
