package com.gruposv.microservice_purchasing.modules.goods_receipts.repository;

import com.gruposv.microservice_purchasing.modules.goods_receipts.entity.GoodsReceiptsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsReceiptsRepository extends JpaRepository<GoodsReceiptsEntity, Long> {
}
