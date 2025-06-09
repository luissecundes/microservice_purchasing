package com.gruposv.microservice_purchasing.modules.purchase_orders.service;

import com.gruposv.microservice_purchasing.modules.purchase_orders.entity.PurchaseOrdersEntity;
import com.gruposv.microservice_purchasing.modules.purchase_orders.repository.PurchaseOrdersRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseOrdersService {

    private final PurchaseOrdersRepository purchaseOrdersRepository;

    @Autowired
    public PurchaseOrdersService(PurchaseOrdersRepository purchaseOrdersRepository) {
        this.purchaseOrdersRepository = purchaseOrdersRepository;
    }

    public PurchaseOrdersEntity savePurchaseOrder(PurchaseOrdersEntity purchaseOrder) {
        return purchaseOrdersRepository.save(purchaseOrder);
    }

    public List<PurchaseOrdersEntity> getAll() {
        return purchaseOrdersRepository.findAll();
    }

    public Optional<PurchaseOrdersEntity> getById(Long id) {
        return purchaseOrdersRepository.findById(id);
    }



    public void delete(Long id) {
        purchaseOrdersRepository.deleteById(id);
    }
}