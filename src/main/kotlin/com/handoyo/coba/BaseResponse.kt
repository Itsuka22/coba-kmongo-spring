package com.handoyo.coba

class BaseResponse<T> (
    var status: Boolean = false,
    var message: String = "",
    var data: T? = null
)

