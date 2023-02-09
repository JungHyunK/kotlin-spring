package com.learn.kotlinspring.dbtest.repo

import com.learn.kotlinspring.common.support.QuerydslCustomRepositorySupport
import com.learn.kotlinspring.dbtest.repo.entity.Product
import org.hibernate.annotations.Comment
import org.springframework.data.jpa.repository.QueryHints
import org.springframework.stereotype.Repository
import javax.persistence.QueryHint
import com.learn.kotlinspring.dbtest.repo.entity.QProduct.product as qProduct

@Repository
class TestRepo: QuerydslCustomRepositorySupport(Product::class.java) {

    @Comment("findById")
    fun findById(id: Long): List<Product> = selectFrom(qProduct)
        .where(qProduct.id.eq(id))
        .fetch()

    fun findAll():List<Product> = selectFrom(qProduct).fetch()

    fun findByIdOne(id: Long): Product? = selectFrom(qProduct)
        .where(qProduct.id.eq(id))
        .fetchOne()
}