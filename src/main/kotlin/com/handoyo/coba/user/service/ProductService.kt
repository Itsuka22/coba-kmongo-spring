package com.handoyo.coba.user.service

import com.handoyo.coba.user.entity.Product
import com.mongodb.client.result.DeleteResult
import com.mongodb.client.result.UpdateResult

interface ProductService {

    fun getUserByName(name: String): Product?
    fun getUsers(): List<Product>
    fun addUser(user: Product): List<Product>
    fun getIds(): List<String>
    fun deleteProduct(name:String): DeleteResult
    fun updateProduct(user:String,update:String): UpdateResult

}