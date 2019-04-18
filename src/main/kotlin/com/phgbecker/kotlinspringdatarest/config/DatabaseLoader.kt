package com.phgbecker.kotlinspringdatarest.config

import com.phgbecker.kotlinspringdatarest.domain.item.ItemOrder
import com.phgbecker.kotlinspringdatarest.domain.item.ItemRepository
import com.phgbecker.kotlinspringdatarest.domain.po.PurchaseOrder
import com.phgbecker.kotlinspringdatarest.domain.po.PurchaseRepository
import com.phgbecker.kotlinspringdatarest.domain.product.Product
import com.phgbecker.kotlinspringdatarest.domain.product.ProductRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class DatabaseLoader(
        private val productRepository: ProductRepository,
        private val purchaseRepository: PurchaseRepository,
        private val itemRepository: ItemRepository
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        saveProducts()
        savePurchases()
        saveItems()
    }

    fun saveProducts() {
        val products = mutableListOf<Product>().apply {
            add(Product(1, description = "Samsung 500GB SSD"))
            add(Product(2, description = "DELL Laptop 4k"))
            add(Product(3, description = "Motorola moto one smartphone"))
        }

        productRepository.saveAll(products)
    }

    fun savePurchases() {
        val purchases = mutableListOf<PurchaseOrder>().apply {
            add(PurchaseOrder(customer = "John Doe"))
            add(PurchaseOrder(customer = "Mary Poppins"))
            add(PurchaseOrder(customer = "Axel Rose"))
        }

        purchaseRepository.saveAll(purchases)
    }

    fun saveItems() {
        val items = mutableListOf<ItemOrder>().apply {
            add(ItemOrder(
                    product = Product(id = 1),
                    quantity = 1,
                    purchaseOrder = PurchaseOrder(id = 4),
                    value = BigDecimal("128.90")
            ))
            add(ItemOrder(
                    product = Product(id = 2),
                    quantity = 1,
                    purchaseOrder = PurchaseOrder(id = 5),
                    value = BigDecimal("1256.99")
            ))
            add(ItemOrder(
                    product = Product(id = 3),
                    quantity = 2,
                    purchaseOrder = PurchaseOrder(id = 6),
                    value = BigDecimal("300.99")
            ))
        }

        itemRepository.saveAll(items)

    }


}