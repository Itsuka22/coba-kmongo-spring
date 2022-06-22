package com.handoyo.coba.user.service

import com.handoyo.coba.user.entity.Product
import com.handoyo.coba.user.repository.ProductRepository
import com.mongodb.client.result.DeleteResult
import com.mongodb.client.result.UpdateResult
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl : ProductService {
    @Autowired
    private lateinit var productRepository: ProductRepository

    override fun getUserByName(name: String): Product? {
        return productRepository.getUserByName(name)
    }

    override fun getUsers(): List<Product> {
        return productRepository.getUsers()
    }

    override fun addUser(name: Product): List<Product> {
        return productRepository.addUser(name.product)
    }

    override fun getIds(): List<String> {
        return productRepository.getUsers().map { it.id }
    }

    override fun deleteProduct(name: String): DeleteResult {
        return productRepository.deleteProductbyName(name)
    }

    override fun updateProduct(user: String, update: String): UpdateResult {
        return productRepository.updateProductbyName(user,update)

    }


}