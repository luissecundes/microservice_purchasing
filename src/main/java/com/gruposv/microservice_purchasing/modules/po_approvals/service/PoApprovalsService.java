package com.gruposv.microservice_purchasing.modules.po_approvals.service;

import com.gruposv.microservice_purchasing.modules.po_approvals.dto.PoApprovalsDTO;
import com.gruposv.microservice_purchasing.modules.po_approvals.entity.PoApprovalsEntity;
import com.gruposv.microservice_purchasing.modules.po_approvals.mapper.PoApprovalsMapper;
import com.gruposv.microservice_purchasing.modules.po_approvals.repository.PoApprovalsRepository;

import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PoApprovalsService {

    private final PoApprovalsRepository repository;
    private final PoApprovalsMapper mapper;

    @Autowired
    public PoApprovalsService(PoApprovalsRepository repository, PoApprovalsMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public PoApprovalsDTO save(PoApprovalsDTO dto) {
        PoApprovalsEntity entity = mapper.toEntity(dto);
        PoApprovalsEntity saved = repository.save(entity);
        return mapper.toDTO(saved);
    }

    public List<PoApprovalsDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }
    @Transactional
    public PoApprovalsDTO update(Long id, PoApprovalsDTO updatedDTO) {
        PoApprovalsEntity existingApproval = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("PoApproval não encontrado com id: " + id));

        existingApproval.setApprovedBy(updatedDTO.getApprovedBy());
        existingApproval.setApprovalDate(updatedDTO.getApprovalDate());
        existingApproval.setStatus(updatedDTO.getStatus());
        existingApproval.setComments(updatedDTO.getComments());

        if (!existingApproval.getPurchaseOrder().getId().equals(updatedDTO.getPurchaseOrderId())) {
            var newPurchaseOrder = new com.gruposv.microservice_purchasing.modules.purchase_orders.entity.PurchaseOrdersEntity();
            newPurchaseOrder.setId(updatedDTO.getPurchaseOrderId());
            existingApproval.setPurchaseOrder(newPurchaseOrder);
        }

        PoApprovalsEntity savedEntity = repository.save(existingApproval);

        return mapper.toDTO(savedEntity);
    }

    @Transactional
    public void delete(Long id) {
        PoApprovalsEntity approval = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("PoApproval não encontrado com id: " + id));

        approval.setDeletedAt(java.time.LocalDateTime.now());
        repository.save(approval);
    }
}
