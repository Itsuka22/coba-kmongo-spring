package com.handoyo.coba.user.controller

import com.handoyo.coba.BaseResponse
import com.handoyo.coba.user.entity.Product
import com.handoyo.coba.user.service.ProductService
import com.mongodb.client.result.DeleteResult
import com.mongodb.client.result.UpdateResult
import org.litote.kmongo.util.idValue
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("v1/product")
class ProductController {
    @Autowired
    private lateinit var productService: ProductService

    @GetMapping("/{name}")
    fun getUser(@PathVariable(value = "name") userName: String): BaseResponse<Product> {
        return BaseResponse(
            status = true,
            message = "Success",
            data = productService.getUserByName(userName)
        )
    }

    @GetMapping
    fun getUsers(): BaseResponse<List<Product>> {
        return BaseResponse(
            status = true,
            message = "Success",
            data = productService.getUsers()
        )
    }

    @PostMapping
    fun addUser(
        @RequestBody user: Product
    ): BaseResponse<List<Product>> {
        return BaseResponse(
            status = true,
            message = "Success",
            data = productService.addUser(user)
        )
    }

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable(value = "id") userName: String) :BaseResponse<DeleteResult>{
        return BaseResponse(
            status = true,
            message = "Success",
            data = productService.deleteProduct(userName)
        )
    }

    @RequestMapping(method = [RequestMethod.PUT], value = ["/update/{id}"])
    fun updateProduct(@PathVariable(value = "id") userName: String,
                     @RequestBody user: Product ) :BaseResponse<UpdateResult>{
        val update: String = user.product
        println("$update")
        return BaseResponse(
            status = true,
            message = "Success",
            data = productService.updateProduct(userName,update)
        )
    }

}