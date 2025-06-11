package com.gruposv.microservice_purchasing.modules.supplier_documents.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDocumentsDTO {
    private Long id;
    private Long supplierId;
    private String documentType;
    private LocalDate validUntil;
    private String filePath;
}
