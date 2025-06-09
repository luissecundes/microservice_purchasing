package com.gruposv.microservice_purchasing.modules.purchase_order_items.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gruposv.microservice_purchasing.modules.purchase_order_items.entity.PurchaseOrderItemsEntity;

@Repository
public interface PurchaseOrderItemsRepository extends JpaRepository<PurchaseOrderItemsEntity, Long> {
}
