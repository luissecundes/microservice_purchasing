package com.gruposv.microservice_purchasing.modules.goods_receipts.enums;

public enum GoodsReceiptStatus {
    EM_CONFERENCIA("Em Conferência"),
    RECEBIDO("Recebido"),
    RECUSADO_PARCIALMENTE("Recusado Parcialmente");

    private final String statusGoodsReceipt;

    GoodsReceiptStatus(String statusGoodsReceipt) {
        this.statusGoodsReceipt = statusGoodsReceipt;
    }

    public String getStatusGoodsReceipt() {
        return statusGoodsReceipt;
    }
}
