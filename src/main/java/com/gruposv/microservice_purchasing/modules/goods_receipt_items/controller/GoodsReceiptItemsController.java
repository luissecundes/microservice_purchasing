package com.gruposv.microservice_purchasing.modules.goods_receipt_items.controller;

import com.gruposv.microservice_purchasing.modules.goods_receipt_items.entity.GoodsReceiptItemsEntity;
import com.gruposv.microservice_purchasing.modules.goods_receipt_items.service.GoodsReceiptItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/goods-receipt-items")
public class GoodsReceiptItemsController {

    private final GoodsReceiptItemsService service;

    @Autowired
    public GoodsReceiptItemsController(GoodsReceiptItemsService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<GoodsReceiptItemsEntity> create(@RequestBody GoodsReceiptItemsEntity item) {
        GoodsReceiptItemsEntity saved = service.save(item);
        return ResponseEntity.ok(saved);
    }
}
