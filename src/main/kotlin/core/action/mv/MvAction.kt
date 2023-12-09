package core.action.mv

import core.action.IAction
import model.context.Context
import model.command.Command

class MvAction : IAction {
    override fun run(command: Command, context: Context) {
        println(command)
    }
}
