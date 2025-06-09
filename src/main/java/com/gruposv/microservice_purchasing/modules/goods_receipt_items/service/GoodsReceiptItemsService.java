package com.gruposv.microservice_purchasing.modules.goods_receipt_items.service;

import com.gruposv.microservice_purchasing.modules.goods_receipt_items.entity.GoodsReceiptItemsEntity;
import com.gruposv.microservice_purchasing.modules.goods_receipt_items.repository.GoodsReceiptItemsRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsReceiptItemsService {

    private final GoodsReceiptItemsRepository repository;

    @Autowired
    public GoodsReceiptItemsService(GoodsReceiptItemsRepository repository) {
        this.repository = repository;
    }

    public GoodsReceiptItemsEntity save(GoodsReceiptItemsEntity item) {
        return repository.save(item);
    }

    // GET ALL
    public List<GoodsReceiptItemsEntity> getAll() {
        return repository.findAll();
    }

    // DELETE
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
