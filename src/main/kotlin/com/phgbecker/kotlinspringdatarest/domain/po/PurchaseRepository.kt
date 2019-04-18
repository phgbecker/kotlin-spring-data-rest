package com.phgbecker.kotlinspringdatarest.domain.po

import org.springframework.data.jpa.repository.JpaRepository

interface PurchaseRepository : JpaRepository<PurchaseOrder, Int>