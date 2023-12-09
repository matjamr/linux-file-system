package model.command.param

import core.action.IAction
import core.action.Runnable
import lombok.ToString
import model.command.Command
import model.node.INode


class Param<T:INode>(private val name: String,
            private val content: String?,
            private val action: Runnable<T>,
            private val description: String,
            private val mandatoryContent: Boolean = false
): IParam<T> {
    override fun getName(): String = name
    override fun getContent(): String? = content
    override fun getDescription(): String = description
    override fun mandatoryContent(): Boolean = mandatoryContent

    override fun getRunnable(): Runnable<T> = action

    override fun toString(): String {
        return "Param(name='$name', content=$content, description=$description)"
    }


}
