package com.gruposv.microservice_purchasing.modules.po_approvals.controller;

import com.gruposv.microservice_purchasing.modules.po_approvals.entity.PoApprovalsEntity;
import com.gruposv.microservice_purchasing.modules.po_approvals.service.PoApprovalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/po-approvals")
public class PoApprovalsController {

    private final PoApprovalsService service;

    @Autowired
    public PoApprovalsController(PoApprovalsService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PoApprovalsEntity> create(@RequestBody PoApprovalsEntity approval) {
        PoApprovalsEntity saved = service.save(approval);
        return ResponseEntity.ok(saved);
    }
}
