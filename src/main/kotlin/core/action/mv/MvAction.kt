package core.action.mv

import core.action.IAction
import model.command.Command

class MvAction : IAction {
    override fun run(command: Command) {
        println(command)
    }
}
