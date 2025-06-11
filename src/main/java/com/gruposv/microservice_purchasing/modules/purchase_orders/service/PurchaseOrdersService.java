package com.gruposv.microservice_purchasing.modules.purchase_orders.service;

import com.gruposv.microservice_purchasing.modules.purchase_orders.dto.PurchaseOrderDTO;
import com.gruposv.microservice_purchasing.modules.purchase_orders.entity.PurchaseOrdersEntity;
import com.gruposv.microservice_purchasing.modules.purchase_orders.mapper.PurchaseOrderMapper;
import com.gruposv.microservice_purchasing.modules.purchase_orders.repository.PurchaseOrdersRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseOrdersService {

    private final PurchaseOrdersRepository purchaseOrdersRepository;
    private final PurchaseOrderMapper purchaseOrderMapper;

    @Autowired
    public PurchaseOrdersService(PurchaseOrdersRepository purchaseOrdersRepository,
                                 PurchaseOrderMapper purchaseOrderMapper) {
        this.purchaseOrdersRepository = purchaseOrdersRepository;
        this.purchaseOrderMapper = purchaseOrderMapper;
    }


    public PurchaseOrdersEntity savePurchaseOrder(PurchaseOrdersEntity purchaseOrder) {
        return purchaseOrdersRepository.save(purchaseOrder);
    }

    public List<PurchaseOrderDTO> getAllDTO() {
        List<PurchaseOrdersEntity> entities = purchaseOrdersRepository.findAll();
        return entities.stream()
                .map(purchaseOrderMapper::toDTO)
                .toList();
    }

        public void delete(Long id) {
        purchaseOrdersRepository.deleteById(id);
    }
}