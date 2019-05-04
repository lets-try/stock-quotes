//package com.learnreactor.stockquotes
//
//import com.learnreactor.stockquotes.dto.Quote
//import com.nhaarman.mockitokotlin2.mock
//import com.nhaarman.mockitokotlin2.verify
//import com.nhaarman.mockitokotlin2.whenever
//import org.junit.Test
//import reactor.core.publisher.Flux
//import java.time.Instant
//
//
//internal class QuotesControllerTest {
//    private val service : QuotesGenerator = mock()
//
//    private val quotesController = QuotesController(service)
//
//    @Test
//    fun `getQuotes should call quotes generator to get quotes` () {
//        val quote = Quote("stock1", 16.0, Instant.now() )
//        whenever(service.getQuotes()).thenReturn(Flux.just(quote))
//
//        val response = quotesController.getQuotes().blockLast()
//
//        verify(service).getQuotes()
//
//
//
//    }
//}