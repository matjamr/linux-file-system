package model.command.param

import core.invoker.Runnable
import model.node.INode

interface IParam<T:INode> {
    fun getName(): String
    fun getContent(): String?
    fun getDescription(): String
    fun mandatoryContent(): Boolean
    fun getRunnable(): Runnable<T>

}
