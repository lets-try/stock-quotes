package com.learnreactor.stockquotes.dto

import java.time.Instant

data class Quote(
        val stockName: String,
        val price : Double,
        val instant : Instant? = null

)


