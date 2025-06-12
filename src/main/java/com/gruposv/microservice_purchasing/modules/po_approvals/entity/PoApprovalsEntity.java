package com.gruposv.microservice_purchasing.modules.po_approvals.entity;

import com.gruposv.microservice_purchasing.domain.TimestampEntity;
import com.gruposv.microservice_purchasing.modules.po_approvals.enums.PoApprovalStatus;
import com.gruposv.microservice_purchasing.modules.purchase_orders.entity.PurchaseOrdersEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_po_approvals")
public class PoApprovalsEntity extends TimestampEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_order_id", nullable = false)
    private PurchaseOrdersEntity purchaseOrder;

    @Column(name = "approved_by", length = 100)
    private String approvedBy;

    @Column(name = "approval_date")
    private LocalDateTime approvalDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20)
    private PoApprovalStatus status;

    @Column(name = "comments", columnDefinition = "TEXT")
    private String comments;

}
