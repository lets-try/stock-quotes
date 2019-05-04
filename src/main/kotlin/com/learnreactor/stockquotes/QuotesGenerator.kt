package com.learnreactor.stockquotes

import com.learnreactor.stockquotes.dto.Quote
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import java.time.Duration
import java.time.Instant
import kotlin.streams.toList

@Component
class QuotesGenerator {

     fun generateQuoteStrem(): Flux<Quote> {
     return  Flux.interval(Duration.ofMillis(200))
             .map { getUpdatedPrices()}
             .flatMapIterable { quotes -> quotes  }
             .share()


    }

    companion object  {
       private val quotes = listOf(Quote("AMN",23.5), Quote("XYZ", 25.7), Quote("RTY",567.4),
                Quote("WERTY",456.7), Quote("FGHJ",1234.345))

         fun getUpdatedPrices() : List<Quote> {
            return quotes.stream().map {
                val priceChange = it.price * 0.05 * (0..9).random()
                Quote(it.stockName, (it.price + priceChange) , Instant.now())
            }.toList()
        }
    }


}
