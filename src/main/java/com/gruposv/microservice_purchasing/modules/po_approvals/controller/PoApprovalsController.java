package com.gruposv.microservice_purchasing.modules.po_approvals.controller;

import com.gruposv.microservice_purchasing.modules.po_approvals.dto.PoApprovalsDTO;
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
    public ResponseEntity<PoApprovalsDTO> create(@RequestBody PoApprovalsDTO dto) {
        PoApprovalsDTO saved = service.save(dto);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<PoApprovalsDTO>> getAll() {
        List<PoApprovalsDTO> list = service.getAll();
        return ResponseEntity.ok(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PoApprovalsDTO> update(@PathVariable Long id, @RequestBody PoApprovalsDTO updatedDTO) {
        PoApprovalsDTO updatedApproval = service.update(id, updatedDTO);
        return ResponseEntity.ok(updatedApproval);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("PoApproval com id " + id + " deletado com sucesso.");
    }
}
