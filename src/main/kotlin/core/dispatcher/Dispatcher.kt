package core.dispatcher

import core.action.IAction

interface Dispatcher {
    fun dispatch(commandName: String): IAction
}
