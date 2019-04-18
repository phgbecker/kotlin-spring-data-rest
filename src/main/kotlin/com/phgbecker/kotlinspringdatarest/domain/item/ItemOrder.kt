package com.phgbecker.kotlinspringdatarest.domain.item

import com.phgbecker.kotlinspringdatarest.domain.po.PurchaseOrder
import com.phgbecker.kotlinspringdatarest.domain.product.Product
import java.math.BigDecimal
import javax.persistence.*

@Entity
data class ItemOrder(
        @Id
        @GeneratedValue
        @Column(name = "item_id")
        var id: Int? = null,

        @ManyToOne
        val product: Product = Product(),

        val quantity: Int = 0,

        val value: BigDecimal = BigDecimal.ZERO,

        @ManyToOne
        val purchaseOrder: PurchaseOrder = PurchaseOrder()
)