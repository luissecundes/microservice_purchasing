package com.gruposv.microservice_purchasing.modules.po_approvals.enums;

public enum PoApprovalStatus {
    APROVADO("Aprovado"),
    REJEITADO("Rejeitado");

    private final String statusApproval;

    PoApprovalStatus(String statusApproval) {
        this.statusApproval = statusApproval;
    }
    public String getDescricaoApproval() {
        return statusApproval;
    }

}
