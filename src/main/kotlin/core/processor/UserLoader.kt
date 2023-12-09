package core.processor

import model.context.Context
import model.user.User

class UserLoader: Processor {
    override fun process(context: Context) {
        context.currentUser = User("andzej", "waligrucha")
    }
}
