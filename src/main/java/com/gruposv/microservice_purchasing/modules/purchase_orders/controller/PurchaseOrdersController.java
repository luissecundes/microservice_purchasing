package com.gruposv.microservice_purchasing.modules.purchase_orders.controller;


import com.gruposv.microservice_purchasing.modules.purchase_orders.entity.PurchaseOrdersEntity;
import com.gruposv.microservice_purchasing.modules.purchase_orders.service.PurchaseOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
}