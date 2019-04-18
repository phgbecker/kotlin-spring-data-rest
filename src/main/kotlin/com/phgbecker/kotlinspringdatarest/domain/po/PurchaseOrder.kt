package com.phgbecker.kotlinspringdatarest.domain.po

import com.phgbecker.kotlinspringdatarest.domain.item.ItemOrder
import javax.persistence.*

@Entity
data class PurchaseOrder (

    @Id
    @GeneratedValue
    @Column(name = "purchase_id")
    var id: Int? = null,

    val customer: String = "",

    @OneToMany(mappedBy = "purchaseOrder", cascade = [CascadeType.ALL])
    val items: List<ItemOrder> = mutableListOf()

)