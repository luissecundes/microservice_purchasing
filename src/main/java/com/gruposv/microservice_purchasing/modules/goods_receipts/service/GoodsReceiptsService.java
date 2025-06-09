package com.gruposv.microservice_purchasing.modules.goods_receipts.service;

import com.gruposv.microservice_purchasing.modules.goods_receipts.entity.GoodsReceiptsEntity;
import com.gruposv.microservice_purchasing.modules.goods_receipts.repository.GoodsReceiptsRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsReceiptsService {

    private final GoodsReceiptsRepository repository;

    @Autowired
    public GoodsReceiptsService(GoodsReceiptsRepository repository) {
        this.repository = repository;
    }

    public GoodsReceiptsEntity save(GoodsReceiptsEntity receipt) {
        return repository.save(receipt);
    }


    // GET ALL
    public List<GoodsReceiptsEntity> getAll() {
        return repository.findAll();
    }

    // DELETE
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
