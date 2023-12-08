package model.command

import core.action.IAction
import model.command.param.IParam

open class Command(
    var name: String,
    var iParams: List<IParam>
) {
    override fun toString(): String {
        return "Command(name='$name', iParams=$iParams)"
    }
}
