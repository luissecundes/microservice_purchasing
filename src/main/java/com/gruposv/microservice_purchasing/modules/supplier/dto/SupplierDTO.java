package com.gruposv.microservice_purchasing.modules.supplier.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDTO {
    private Long supplierId;
    private String supplierName;
    private String documentNumber;
}

