package com.gruposv.microservice_purchasing.modules.goods_receipts.controller;

import com.gruposv.microservice_purchasing.modules.goods_receipts.entity.GoodsReceiptsEntity;
import com.gruposv.microservice_purchasing.modules.goods_receipts.service.GoodsReceiptsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/goods-receipts")
public class GoodsReceiptsController {

    private final GoodsReceiptsService service;

    @Autowired
    public GoodsReceiptsController(GoodsReceiptsService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<GoodsReceiptsEntity> create(@RequestBody GoodsReceiptsEntity receipt) {
        GoodsReceiptsEntity saved = service.save(receipt);
        return ResponseEntity.ok(saved);
    }
}
