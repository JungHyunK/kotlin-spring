package com.learn.kotlinspring.dbtest.repo.entity

import javax.persistence.*

@Entity
@Table(name = "product")
class Product(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    val price: Long
): BasicEntity()
