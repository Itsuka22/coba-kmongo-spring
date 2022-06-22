package com.handoyo.coba.user.repository

import com.handoyo.coba.database.DatabaseComponent
import com.handoyo.coba.user.entity.Product
import com.mongodb.client.MongoCollection
import com.mongodb.client.result.DeleteResult
import com.mongodb.client.result.UpdateResult
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection
import org.litote.kmongo.setValue
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository


@Repository
class ProductRepositoryImpl : ProductRepository {
    @Autowired
    private lateinit var databaseComponent: DatabaseComponent

    private fun userCollection(): MongoCollection<Product> =
        databaseComponent.database.getDatabase("user").getCollection()

    override fun getUserByName(name: String): Product? {
        return userCollection().findOne(Product::product eq name)
    }

    override fun getUsers(): List<Product> {
        return userCollection().find().toList()
    }

    override fun addUser(name: String): List<Product> {
        val newUser = Product(product = name)
        val insert = userCollection().insertOne(newUser)
        return if (insert.wasAcknowledged()) {
            getUsers()
        } else {
            throw IllegalStateException("insert gagal")
        }
    }

    override fun deleteProductbyName(name: String): DeleteResult {
        return userCollection().deleteOne(Product::id eq name)
    }

    override fun updateProductbyName(name: String, update: String): UpdateResult {
        return userCollection().updateOne(Product::id eq name, setValue(Product::product, update))
    }

}