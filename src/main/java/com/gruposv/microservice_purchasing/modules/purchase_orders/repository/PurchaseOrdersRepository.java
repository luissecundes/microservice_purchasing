package com.gruposv.microservice_purchasing.modules.purchase_orders.repository;

import com.gruposv.microservice_purchasing.modules.purchase_orders.entity.PurchaseOrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gruposv.microservice_purchasing.modules.supplier.entity.SupplierEntity;

@Repository
public interface PurchaseOrdersRepository extends JpaRepository<PurchaseOrdersEntity, Long> {
}