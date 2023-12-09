package core.processor

import model.context.Context

class ActionInputHandler: Processor {

    override fun process(context: Context) {
        print("[${context.currentUser}] ${context.currentCatalog}$: ")
        val input = readln()
        context.input = input
    }
}
