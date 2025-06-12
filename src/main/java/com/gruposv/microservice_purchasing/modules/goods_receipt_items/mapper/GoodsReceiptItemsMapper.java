package com.gruposv.microservice_purchasing.modules.goods_receipt_items.mapper;

import com.gruposv.microservice_purchasing.modules.goods_receipt_items.dto.GoodsReceiptItemsDTO;
import com.gruposv.microservice_purchasing.modules.goods_receipt_items.entity.GoodsReceiptItemsEntity;
import com.gruposv.microservice_purchasing.modules.goods_receipts.entity.GoodsReceiptsEntity;
import com.gruposv.microservice_purchasing.modules.purchase_order_items.entity.PurchaseOrderItemsEntity;
import org.springframework.stereotype.Component;

@Component
public class GoodsReceiptItemsMapper {

    public GoodsReceiptItemsDTO toDTO(GoodsReceiptItemsEntity entity) {
        if (entity == null) return null;

        return new GoodsReceiptItemsDTO(
                entity.getId(),
                entity.getGoodsReceipt().getId(),
                entity.getPurchaseOrderItem().getId(),
                entity.getQuantityReceived(),
                entity.getUnitPrice(),
                entity.getTotalPrice()
        );
    }

    public GoodsReceiptItemsEntity toEntity(GoodsReceiptItemsDTO dto) {
        if (dto == null) return null;

        GoodsReceiptItemsEntity entity = new GoodsReceiptItemsEntity();
        entity.setId(dto.getId());

        GoodsReceiptsEntity receipt = new GoodsReceiptsEntity();
        receipt.setId(dto.getGoodsReceiptId());
        entity.setGoodsReceipt(receipt);

        PurchaseOrderItemsEntity orderItem = new PurchaseOrderItemsEntity();
        orderItem.setId(dto.getPurchaseOrderItemId());
        entity.setPurchaseOrderItem(orderItem);

        entity.setQuantityReceived(dto.getQuantityReceived());
        entity.setUnitPrice(dto.getUnitPrice());
        entity.setTotalPrice(dto.getTotalPrice());

        return entity;
    }
}
