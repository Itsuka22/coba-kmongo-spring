package com.handoyo.coba.user.entity

import java.util.*


data class Product (
    var id: String = UUID.randomUUID().toString(),
    var product: String
    )