package model.command.param

import lombok.ToString


class Param(private val name: String,
            private val content: String?,
            private val isContentRequired: Boolean): IParam {
    override fun getName(): String = name
    override fun getContent(): String? = content
    override fun isContentRequired(): Boolean = isContentRequired

    override fun toString(): String {
        return "Param(name='$name', content=$content, isContentRequired=$isContentRequired)"
    }


}
