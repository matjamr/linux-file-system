package model.command.param

import core.action.IAction
import lombok.ToString
import model.command.Command


class Param(private val name: String,
            private val content: String?,
            private val action: Runnable,
            private val description: String,
            private val mandatoryContent: Boolean = false
): IParam {
    override fun getName(): String = name
    override fun getContent(): String? = content
    override fun getDescription(): String = description
    override fun mandatoryContent(): Boolean = mandatoryContent

    override fun getRunnable(): Runnable = action

    override fun toString(): String {
        return "Param(name='$name', content=$content, description=$description)"
    }


}
