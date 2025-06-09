package com.gruposv.microservice_purchasing.modules.po_approvals.controller;

import com.gruposv.microservice_purchasing.modules.po_approvals.entity.PoApprovalsEntity;
import com.gruposv.microservice_purchasing.modules.po_approvals.service.PoApprovalsService;
import java.util.List;
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

    // GET ALL
    @GetMapping
    public ResponseEntity<List<PoApprovalsEntity>> getAll() {
        List<PoApprovalsEntity> list = service.getAll();
        return ResponseEntity.ok(list);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("PoApproval com id " + id + " deletado com sucesso.");
    }
}
