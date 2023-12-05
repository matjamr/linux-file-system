package model.command.param

interface IParam {
    fun getName(): String
    fun getContent(): String?
    fun isContentRequired(): Boolean
}
