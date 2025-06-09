package com.gruposv.microservice_purchasing.modules.purchase_order_items.service;

import com.gruposv.microservice_purchasing.modules.purchase_order_items.entity.PurchaseOrderItemsEntity;
import com.gruposv.microservice_purchasing.modules.purchase_order_items.repository.PurchaseOrderItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderItemsService {

    private final PurchaseOrderItemsRepository repository;

    @Autowired
    public PurchaseOrderItemsService(PurchaseOrderItemsRepository repository) {
        this.repository = repository;
    }

    public PurchaseOrderItemsEntity save(PurchaseOrderItemsEntity item) {
        return repository.save(item);
    }

    public List<PurchaseOrderItemsEntity> findAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
