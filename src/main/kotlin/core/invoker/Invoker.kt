package core.invoker

import model.context.Context
import model.command.Command

interface Invoker {
    fun run(command: Command, context: Context)
}
