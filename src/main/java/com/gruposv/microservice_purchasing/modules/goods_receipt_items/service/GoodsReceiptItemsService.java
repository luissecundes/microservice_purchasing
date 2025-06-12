package com.gruposv.microservice_purchasing.modules.goods_receipt_items.service;

import com.gruposv.microservice_purchasing.modules.goods_receipt_items.dto.GoodsReceiptItemsDTO;
import com.gruposv.microservice_purchasing.modules.goods_receipt_items.entity.GoodsReceiptItemsEntity;
import com.gruposv.microservice_purchasing.modules.goods_receipt_items.mapper.GoodsReceiptItemsMapper;
import com.gruposv.microservice_purchasing.modules.goods_receipt_items.repository.GoodsReceiptItemsRepository;

import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsReceiptItemsService {

    private final GoodsReceiptItemsRepository repository;
    private final GoodsReceiptItemsMapper mapper;

    @Autowired
    public GoodsReceiptItemsService(GoodsReceiptItemsRepository repository, GoodsReceiptItemsMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public GoodsReceiptItemsDTO save(GoodsReceiptItemsDTO dto) {
        GoodsReceiptItemsEntity entity = mapper.toEntity(dto);
        GoodsReceiptItemsEntity saved = repository.save(entity);
        return mapper.toDTO(saved);
    }

    public List<GoodsReceiptItemsDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Transactional
    public GoodsReceiptItemsDTO update(Long id, GoodsReceiptItemsDTO updatedDTO) {
        GoodsReceiptItemsEntity existingItem = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Goods receipt item não encontrado com id: " + id));

        existingItem.setQuantityReceived(updatedDTO.getQuantityReceived());
        existingItem.setUnitPrice(updatedDTO.getUnitPrice());
        existingItem.setTotalPrice(updatedDTO.getTotalPrice());

        if (!existingItem.getGoodsReceipt().getId().equals(updatedDTO.getGoodsReceiptId())) {
            var newGoodsReceipt = new com.gruposv.microservice_purchasing.modules.goods_receipts.entity.GoodsReceiptsEntity();
            newGoodsReceipt.setId(updatedDTO.getGoodsReceiptId());
            existingItem.setGoodsReceipt(newGoodsReceipt);
        }

        if (!existingItem.getPurchaseOrderItem().getId().equals(updatedDTO.getPurchaseOrderItemId())) {
            var newPurchaseOrderItem = new com.gruposv.microservice_purchasing.modules.purchase_order_items.entity.PurchaseOrderItemsEntity();
            newPurchaseOrderItem.setId(updatedDTO.getPurchaseOrderItemId());
            existingItem.setPurchaseOrderItem(newPurchaseOrderItem);
        }

        GoodsReceiptItemsEntity savedEntity = repository.save(existingItem);

        return mapper.toDTO(savedEntity);
    }


    @Transactional
    public void delete(Long id) {
        GoodsReceiptItemsEntity item = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Goods receipt item não encontrado com id: " + id));

        item.setDeletedAt(java.time.LocalDateTime.now());
        repository.save(item);
    }

}
