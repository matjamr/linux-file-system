package model.command

import model.command.param.IParam
import model.node.Catalog

abstract class Command(
    var name: String,
    var iParams: List<IParam<Catalog>>
) {
    override fun toString(): String {
        return "Command(name='$name', iParams=$iParams)"
    }
}
