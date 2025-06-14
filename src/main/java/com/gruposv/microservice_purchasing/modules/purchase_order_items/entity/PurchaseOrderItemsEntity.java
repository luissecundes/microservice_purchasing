package com.gruposv.microservice_purchasing.modules.purchase_order_items.entity;

import com.gruposv.microservice_purchasing.domain.TimestampEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import com.gruposv.microservice_purchasing.modules.purchase_orders.entity.PurchaseOrdersEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_purchase_order_items")
@Where(clause = "deleted_at IS NULL")
public class PurchaseOrderItemsEntity extends TimestampEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_order_id", nullable = false)
    private PurchaseOrdersEntity purchaseOrder;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "quantity", precision = 10, scale = 2, nullable = false)
    private BigDecimal quantity;

    @Column(name = "unit_price", precision = 12, scale = 2, nullable = false)
    private BigDecimal unitPrice;

    @Column(name = "line_total", precision = 12, scale = 2, nullable = false)
    private BigDecimal lineTotal;
    
}
