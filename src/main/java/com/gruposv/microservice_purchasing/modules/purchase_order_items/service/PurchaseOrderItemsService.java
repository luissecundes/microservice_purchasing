package com.gruposv.microservice_purchasing.modules.purchase_order_items.service;

import com.gruposv.microservice_purchasing.modules.purchase_order_items.dto.PurchaseOrderItemsDTO;
import com.gruposv.microservice_purchasing.modules.purchase_order_items.entity.PurchaseOrderItemsEntity;
import com.gruposv.microservice_purchasing.modules.purchase_order_items.mapper.PurchaseOrderItemsMapper;
import com.gruposv.microservice_purchasing.modules.purchase_order_items.repository.PurchaseOrderItemsRepository;
import com.gruposv.microservice_purchasing.modules.purchase_orders.entity.PurchaseOrdersEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderItemsService {

    private final PurchaseOrderItemsRepository repository;
    private final PurchaseOrderItemsMapper mapper;

    @Autowired
    public PurchaseOrderItemsService(PurchaseOrderItemsRepository repository, PurchaseOrderItemsMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public PurchaseOrderItemsDTO save(PurchaseOrderItemsDTO dto) {
        PurchaseOrderItemsEntity entity = mapper.toEntity(dto);
        PurchaseOrderItemsEntity saved = repository.save(entity);
        return mapper.toDTO(saved);
    }

    public List<PurchaseOrderItemsDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Transactional
    public PurchaseOrderItemsDTO updatePurchaseOrderItem(Long id, PurchaseOrderItemsDTO updatedDTO) {
        PurchaseOrderItemsEntity existingItem = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item não encontrado com id: " + id));

        existingItem.setProductId(updatedDTO.getProductId());
        existingItem.setDescription(updatedDTO.getDescription());
        existingItem.setQuantity(updatedDTO.getQuantity());
        existingItem.setUnitPrice(updatedDTO.getUnitPrice());
        existingItem.setLineTotal(updatedDTO.getLineTotal());

        if (!existingItem.getPurchaseOrder().getId().equals(updatedDTO.getPurchaseOrderId())) {
            PurchaseOrdersEntity newPurchaseOrder = new PurchaseOrdersEntity();
            newPurchaseOrder.setId(updatedDTO.getPurchaseOrderId());
            existingItem.setPurchaseOrder(newPurchaseOrder);
        }

        PurchaseOrderItemsEntity savedEntity = repository.save(existingItem);

        return mapper.toDTO(savedEntity);
    }

    @Transactional
    public void deleteById(Long id) {
        PurchaseOrderItemsEntity existingItem = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item não encontrado com id: " + id));

        existingItem.setDeletedAt(java.time.LocalDateTime.now());
        repository.save(existingItem);
    }
}
