package model.command

import core.action.IAction
import model.command.param.IParam
import model.node.Catalog

open class Command(
    var name: String,
    var iParams: List<IParam<Catalog>>
) {
    override fun toString(): String {
        return "Command(name='$name', iParams=$iParams)"
    }
}
