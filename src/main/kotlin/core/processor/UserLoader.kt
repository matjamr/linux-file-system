package core.processor

import model.Context
import model.User

class UserLoader: Processor {
    override fun process(context: Context) {
        context.currentUser = User("andzej", "waligrucha")
    }
}
