package com.gruposv.microservice_purchasing.modules.purchase_orders.enums;

public enum PurchaseOrderStatus {
    CRIADO("Criado"),
    APROVADO("Aprovado"),
    ENVIADO("Enviado"),
    RECEBIDO("Recebido"),
    CANCELADO("Cancelado");

    private final String descricao;

    PurchaseOrderStatus(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
