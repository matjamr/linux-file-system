package core.action

import model.context.Context
import model.command.Command

interface IAction {
    fun run(command: Command, context: Context)
}
