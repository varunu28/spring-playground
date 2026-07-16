package com.varunu28.nanoservice.repository

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "person")
class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    @Column(nullable = false)
    var name: String,
    @Column(nullable = false)
    var age: Int,
) {
    override fun hashCode(): Int {
        return id ?: 0
    }
}