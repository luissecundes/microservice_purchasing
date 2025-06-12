package com.gruposv.microservice_purchasing.modules.goods_receipt_items.controller;

import com.gruposv.microservice_purchasing.modules.goods_receipt_items.dto.GoodsReceiptItemsDTO;
import com.gruposv.microservice_purchasing.modules.goods_receipt_items.entity.GoodsReceiptItemsEntity;
import com.gruposv.microservice_purchasing.modules.goods_receipt_items.service.GoodsReceiptItemsService;

import java.util.List;

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
    public ResponseEntity<GoodsReceiptItemsDTO> create(@RequestBody GoodsReceiptItemsDTO dto) {
        GoodsReceiptItemsDTO saved = service.save(dto);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<GoodsReceiptItemsDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<GoodsReceiptItemsDTO> update(@PathVariable Long id, @RequestBody GoodsReceiptItemsDTO updatedDTO) {
        GoodsReceiptItemsDTO updated = service.update(id, updatedDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Goods receipt item com id " + id + " deletado com sucesso.");
    }
}
