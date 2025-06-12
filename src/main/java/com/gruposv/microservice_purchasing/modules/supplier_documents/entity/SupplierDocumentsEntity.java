package com.gruposv.microservice_purchasing.modules.supplier_documents.entity;

import com.gruposv.microservice_purchasing.domain.TimestampEntity;
import com.gruposv.microservice_purchasing.modules.supplier.entity.SupplierEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_suppliers_documents")
@Where(clause = "deleted_at IS NULL")
public class SupplierDocumentsEntity extends TimestampEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id", nullable = false)
    private SupplierEntity supplier;

    @Column(name = "document_type", length = 100)
    private String documentType;

    @Column(name = "valid_until")
    private LocalDate validUntil;

    @Column(name = "file_path", length = 255)
    private String filePath;
}
