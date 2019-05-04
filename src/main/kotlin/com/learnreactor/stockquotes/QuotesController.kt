package com.learnreactor.stockquotes

import com.learnreactor.stockquotes.dto.Quote
import org.springframework.http.MediaType
import org.springframework.http.MediaType.APPLICATION_STREAM_JSON
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class QuotesController(private val quotesGenerator: QuotesGenerator) {

    @GetMapping("/stock-quotes")
    fun getQuotes(): Flux<Quote> {
        return quotesGenerator.generateQuoteStrem()
    }
}