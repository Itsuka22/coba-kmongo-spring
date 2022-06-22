package com.handoyo.coba.user.repository

import com.handoyo.coba.user.entity.Product
import com.mongodb.client.result.DeleteResult
import com.mongodb.client.result.UpdateResult

interface ProductRepository {
    fun getUserByName(name: String): Product?
    fun getUsers(): List<Product>
    fun addUser(name: String): List<Product>
    fun deleteProductbyName(name: String): DeleteResult
    fun updateProductbyName (name: String, update:String ): UpdateResult
}