package core.dispatcher

import core.action.IAction
import java.lang.RuntimeException

class ActionDispatcher(
    private val actionMap: Map<String, IAction>
): Dispatcher {
    override fun dispatch(commandName: String): IAction = actionMap.getOrElse(
        commandName
    ) { throw RuntimeException("Unsupported command: $commandName") }
}
