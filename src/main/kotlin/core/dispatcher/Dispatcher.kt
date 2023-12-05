package core.dispatcher

import model.command.action.IAction

interface Dispatcher {
    fun dispatch(commandName: String): IAction
}
