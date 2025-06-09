package com.gruposv.microservice_purchasing.modules.purchase_order_items.controller;

import com.gruposv.microservice_purchasing.modules.purchase_order_items.entity.PurchaseOrderItemsEntity;
import com.gruposv.microservice_purchasing.modules.purchase_order_items.service.PurchaseOrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/purchase-order-items")
public class PurchaseOrderItemsController {

    private final PurchaseOrderItemsService service;

    @Autowired
    public PurchaseOrderItemsController(PurchaseOrderItemsService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PurchaseOrderItemsEntity> create(@RequestBody PurchaseOrderItemsEntity item) {
        PurchaseOrderItemsEntity saved = service.save(item);
        return ResponseEntity.ok(saved);
    }
}
