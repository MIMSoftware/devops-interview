package com.mimsoftware

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.html.respondHtml
import io.ktor.routing.get
import io.ktor.routing.routing
import kotlinx.html.body
import kotlinx.html.div
import kotlinx.html.h1
import kotlinx.html.h2
import kotlinx.html.h3
import kotlinx.html.head
import kotlinx.html.hr
import kotlinx.html.li
import kotlinx.html.p
import kotlinx.html.style
import kotlinx.html.ul


fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    routing {
        get("/") {
            call.respondHtml {
                body {
                    style = "background: lightgrey; color: black; font-family: verdana"
                    h1 { +"Hello, World!" }
                    div {
                        p {
                            +"Congratulations! If you are seeing this text, you were able to build and run the MIMSoftware example project."
                        }

                        h2 { +"Next Steps:" }
                        hr { }
                        ul {
                            li { +"Make sure this is running from inside your docker container before you submit." }
                            li { +"Make sure you include everything you needed to build your container." }
                            li { +"Make sure to also submit a copy of your resume and the answers to the questions you were given." }
                        }
                        hr { }
                        h3 { +"Good luck on the rest of your interview!" }
                    }
                }
            }
        }
    }
}

