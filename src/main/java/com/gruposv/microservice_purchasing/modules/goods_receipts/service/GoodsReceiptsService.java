package com.gruposv.microservice_purchasing.modules.goods_receipts.service;

import com.gruposv.microservice_purchasing.modules.goods_receipts.dto.GoodsReceiptsDTO;
import com.gruposv.microservice_purchasing.modules.goods_receipts.entity.GoodsReceiptsEntity;
import com.gruposv.microservice_purchasing.modules.goods_receipts.mapper.GoodsReceiptsMapper;
import com.gruposv.microservice_purchasing.modules.goods_receipts.repository.GoodsReceiptsRepository;

import java.util.List;

import com.gruposv.microservice_purchasing.modules.purchase_orders.entity.PurchaseOrdersEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsReceiptsService {

    private final GoodsReceiptsRepository repository;
    private final GoodsReceiptsMapper mapper;

    @Autowired
    public GoodsReceiptsService(GoodsReceiptsRepository repository, GoodsReceiptsMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public GoodsReceiptsDTO save(GoodsReceiptsDTO dto) {
        GoodsReceiptsEntity entity = mapper.toEntity(dto);
        GoodsReceiptsEntity saved = repository.save(entity);
        return mapper.toDTO(saved);
    }

    public List<GoodsReceiptsDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Transactional
    public GoodsReceiptsDTO update(Long id, GoodsReceiptsDTO updatedDTO) {
        GoodsReceiptsEntity existingReceipt = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("GoodsReceipt não encontrado com id: " + id));

        existingReceipt.setReceiptDate(updatedDTO.getReceiptDate());
        existingReceipt.setInvoiceNumber(updatedDTO.getInvoiceNumber());
        existingReceipt.setInvoiceAmount(updatedDTO.getInvoiceAmount());
        existingReceipt.setStatus(updatedDTO.getStatus());

        if (!existingReceipt.getPurchaseOrder().getId().equals(updatedDTO.getPurchaseOrderId())) {
            var newPurchaseOrder = new PurchaseOrdersEntity();
            newPurchaseOrder.setId(updatedDTO.getPurchaseOrderId());
            existingReceipt.setPurchaseOrder(newPurchaseOrder);
        }

        GoodsReceiptsEntity savedEntity = repository.save(existingReceipt);

        return mapper.toDTO(savedEntity);
    }

    @Transactional
    public void delete(Long id) {
        GoodsReceiptsEntity receipt = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("GoodsReceipt não encontrado com id: " + id));

        receipt.setDeletedAt(java.time.LocalDateTime.now());
        repository.save(receipt);
    }
}
