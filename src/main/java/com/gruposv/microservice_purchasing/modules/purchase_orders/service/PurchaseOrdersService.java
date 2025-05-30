package com.gruposv.microservice_purchasing.modules.purchase_orders.service;

import com.gruposv.microservice_purchasing.modules.purchase_orders.entity.PurchaseOrdersEntity;
import com.gruposv.microservice_purchasing.modules.purchase_orders.repository.PurchaseOrdersRepository;
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
}