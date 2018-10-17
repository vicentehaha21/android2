package com.example.lucas.todoapplication.integration

import com.example.lucas.todoapplication.domain.ErrorData

interface KotlinResponseInterface <T> {
    fun onSuccess(data: T)
    fun onError(data: ErrorData)
}