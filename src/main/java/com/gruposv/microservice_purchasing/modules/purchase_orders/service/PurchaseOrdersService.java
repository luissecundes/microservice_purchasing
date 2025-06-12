package com.gruposv.microservice_purchasing.modules.purchase_orders.service;

import com.gruposv.microservice_purchasing.modules.purchase_orders.dto.PurchaseOrderDTO;
import com.gruposv.microservice_purchasing.modules.purchase_orders.entity.PurchaseOrdersEntity;
import com.gruposv.microservice_purchasing.modules.purchase_orders.mapper.PurchaseOrderMapper;
import com.gruposv.microservice_purchasing.modules.purchase_orders.repository.PurchaseOrdersRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.gruposv.microservice_purchasing.modules.supplier.repository.SupplierRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseOrdersService {

    private final PurchaseOrdersRepository purchaseOrdersRepository;
    private final PurchaseOrderMapper purchaseOrderMapper;
    private final SupplierRepository supplierRepository;


    @Autowired
    public PurchaseOrdersService(PurchaseOrdersRepository purchaseOrdersRepository,
                                 PurchaseOrderMapper purchaseOrderMapper,
                                 SupplierRepository supplierRepository) {
        this.purchaseOrdersRepository = purchaseOrdersRepository;
        this.purchaseOrderMapper = purchaseOrderMapper;
        this.supplierRepository = supplierRepository;
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

    @Transactional
    public PurchaseOrderDTO updatePurchaseOrder(Long id, PurchaseOrderDTO updatedDTO) {
        PurchaseOrdersEntity existingOrder = purchaseOrdersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido de compra não encontrado com id: " + id));

        // Atualizar campos
        existingOrder.setOrderNumber(updatedDTO.getOrderNumber());
        existingOrder.setOrderDate(updatedDTO.getOrderDate());
        existingOrder.setExpectedDeliveryDate(updatedDTO.getExpectedDeliveryDate());
        existingOrder.setStatus(updatedDTO.getStatus());
        existingOrder.setTotalAmount(updatedDTO.getTotalAmount());
        existingOrder.setCurrency(updatedDTO.getCurrency());
        existingOrder.setPaymentTerms(updatedDTO.getPaymentTerms());

        // Atualizar Supplier de forma correta
        if (!existingOrder.getSupplier().getId().equals(updatedDTO.getSupplierId())) {
            var newSupplier = supplierRepository.findById(updatedDTO.getSupplierId())
                    .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado com id: " + updatedDTO.getSupplierId()));
            existingOrder.setSupplier(newSupplier);
        }

        PurchaseOrdersEntity savedEntity = purchaseOrdersRepository.save(existingOrder);

        return purchaseOrderMapper.toDTO(savedEntity);
    }



    @Transactional
    public void delete(Long id) {
        PurchaseOrdersEntity purchaseOrder = purchaseOrdersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido de compra não encontrado com id: " + id));
        purchaseOrder.setDeletedAt(LocalDateTime.now());
        purchaseOrdersRepository.save(purchaseOrder);
    }

}