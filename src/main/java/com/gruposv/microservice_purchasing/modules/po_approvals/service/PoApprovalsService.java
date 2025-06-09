package com.gruposv.microservice_purchasing.modules.po_approvals.service;

import com.gruposv.microservice_purchasing.modules.po_approvals.entity.PoApprovalsEntity;
import com.gruposv.microservice_purchasing.modules.po_approvals.repository.PoApprovalsRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PoApprovalsService {

    private final PoApprovalsRepository repository;

    @Autowired
    public PoApprovalsService(PoApprovalsRepository repository) {
        this.repository = repository;
    }

    public PoApprovalsEntity save(PoApprovalsEntity approval) {
        return repository.save(approval);
    }

    // GET ALL
    public List<PoApprovalsEntity> getAll() {
        return repository.findAll();
    }

    // DELETE
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
