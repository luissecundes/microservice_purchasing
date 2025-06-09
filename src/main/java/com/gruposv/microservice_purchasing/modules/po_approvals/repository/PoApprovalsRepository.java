package com.gruposv.microservice_purchasing.modules.po_approvals.repository;

import com.gruposv.microservice_purchasing.modules.po_approvals.entity.PoApprovalsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoApprovalsRepository extends JpaRepository<PoApprovalsEntity, Long> {
}
