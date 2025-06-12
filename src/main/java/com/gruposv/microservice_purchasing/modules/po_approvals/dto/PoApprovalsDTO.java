package com.gruposv.microservice_purchasing.modules.po_approvals.dto;

import com.gruposv.microservice_purchasing.modules.po_approvals.enums.PoApprovalStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PoApprovalsDTO {
    private Long id;
    private Long purchaseOrderId;
    private String approvedBy;
    private LocalDateTime approvalDate;
    private PoApprovalStatus status;
    private String comments;
}
