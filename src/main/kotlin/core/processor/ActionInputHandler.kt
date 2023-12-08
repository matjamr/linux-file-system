package core.processor

import model.Context

class ActionInputHandler: Processor {

    override fun process(context: Context) {
        print("[${context.currentUser}] ${context.currentNode}$: ")
        val input = readln()
        context.input = input
    }
}
