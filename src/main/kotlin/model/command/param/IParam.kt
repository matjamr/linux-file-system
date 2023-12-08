package model.command.param

interface IParam {
    fun getName(): String
    fun getContent(): String?
    fun getDescription(): String
    fun mandatoryContent(): Boolean
    fun getRunnable(): Runnable

}
