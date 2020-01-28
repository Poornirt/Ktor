package com.example.demo

import io.ktor.application.*
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.request.receive

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {

    install(ContentNegotiation) {
        gson()
    }

    val repository=FileRepository()

    routing {
       get("/"){
           call.respond(HttpStatusCode.OK, mapOf("message" to "Demo of KTOR"))
       }
        post("/addFile"){
            val item=call.receive<Item>();
            repository.addFile(item)
            call.respond(HttpStatusCode.Created,item)
        }
    }
}