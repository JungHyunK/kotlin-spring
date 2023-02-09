package com.learn.kotlinspring.dbtest.controller

import com.learn.kotlinspring.dbtest.repo.entity.Product
import com.learn.kotlinspring.dbtest.repo.TestRepo
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("")
class TestController {

    val logger = logger<TestController>()

    @Autowired
    private lateinit var testRepo: TestRepo

    @GetMapping("/test")
    fun callTest() = "hello"

    @GetMapping("/log")
    fun logTest(@RequestParam text:String): String {
        var c:Boolean
        logger.info("test Log $text")
        mutableListOf<List<Int>>()
        return "hello"
    }

    @GetMapping("/id")
    fun testRepo(@RequestParam id:Long): Product? = testRepo.findByIdOne(id);

    @GetMapping("/all")
    fun testRepoAll():List<Product> = testRepo.findAll()
}

inline fun<reified T> logger(): Logger = LoggerFactory.getLogger(T::class.java)