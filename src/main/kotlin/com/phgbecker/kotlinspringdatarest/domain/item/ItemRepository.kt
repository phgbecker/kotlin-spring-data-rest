package com.phgbecker.kotlinspringdatarest.domain.item

import org.springframework.data.jpa.repository.JpaRepository

interface ItemRepository : JpaRepository<ItemOrder, Int>