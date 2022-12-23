package example

import io.micronaut.runtime.Micronaut.*
import org.h2.tools.Server

//fun main(args: Array<String>) {
//    run(*args)
//}
//

class Application {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Server.createWebServer().start()
            run(Application::class.java)
        }
    }
}

