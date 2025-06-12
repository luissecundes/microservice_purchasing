package com.gruposv.microservice_purchasing.modules.purchase_orders.controller;


import com.gruposv.microservice_purchasing.modules.purchase_orders.dto.PurchaseOrderDTO;
import com.gruposv.microservice_purchasing.modules.purchase_orders.entity.PurchaseOrdersEntity;
import com.gruposv.microservice_purchasing.modules.purchase_orders.service.PurchaseOrdersService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/purchase-orders")
public class PurchaseOrdersController {

    private final PurchaseOrdersService purchaseOrdersService;

    @Autowired
    public PurchaseOrdersController(PurchaseOrdersService purchaseOrdersService) {
        this.purchaseOrdersService = purchaseOrdersService;
    }

    @PostMapping
    public ResponseEntity<PurchaseOrdersEntity> createPurchaseOrder(@RequestBody PurchaseOrdersEntity purchaseOrder) {
        PurchaseOrdersEntity savedPurchaseOrder = purchaseOrdersService.savePurchaseOrder(purchaseOrder);
        return ResponseEntity.ok(savedPurchaseOrder);
    }

    @GetMapping
    public ResponseEntity<List<PurchaseOrderDTO>> getAll() {
        return ResponseEntity.ok(purchaseOrdersService.getAllDTO());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PurchaseOrderDTO> updatePurchaseOrder(@PathVariable Long id, @RequestBody PurchaseOrderDTO updatedDTO) {
        PurchaseOrderDTO updatedOrder = purchaseOrdersService.updatePurchaseOrder(id, updatedDTO);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
    purchaseOrdersService.delete(id);
    Map<String, String> response = new HashMap<>();
    response.put("message", "Pedido de compra com id " + id + " foi deletado com sucesso.");
        return ResponseEntity.ok(response);
}

}