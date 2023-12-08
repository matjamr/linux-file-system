package core.action

import model.command.Command

interface IAction {
    fun run(command: Command)
}
