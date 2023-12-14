package core.invoker.mv

import core.invoker.Invoker
import model.context.Context
import model.command.Command

class MvInvoker : Invoker {
    override fun run(command: Command, context: Context) {
        println(command)
    }
}
