package com.gruposv.microservice_purchasing.modules.goods_receipts.controller;

import com.gruposv.microservice_purchasing.modules.goods_receipts.dto.GoodsReceiptsDTO;
import com.gruposv.microservice_purchasing.modules.goods_receipts.entity.GoodsReceiptsEntity;
import com.gruposv.microservice_purchasing.modules.goods_receipts.service.GoodsReceiptsService;

import java.util.List;

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
    public ResponseEntity<GoodsReceiptsDTO> create(@RequestBody GoodsReceiptsDTO receiptDTO) {
        GoodsReceiptsDTO saved = service.save(receiptDTO);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<GoodsReceiptsDTO>> getAll() {
        List<GoodsReceiptsDTO> list = service.getAll();
        return ResponseEntity.ok(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GoodsReceiptsDTO> update(@PathVariable Long id, @RequestBody GoodsReceiptsDTO updatedDTO) {
        GoodsReceiptsDTO updated = service.update(id, updatedDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Goods receipt com id " + id + " deletado com sucesso.");
    }
}
