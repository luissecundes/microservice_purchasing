package com.gruposv.microservice_purchasing.modules.goods_receipt_items.repository;

import com.gruposv.microservice_purchasing.modules.goods_receipt_items.entity.GoodsReceiptItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsReceiptItemsRepository extends JpaRepository<GoodsReceiptItemsEntity, Long> {
}
