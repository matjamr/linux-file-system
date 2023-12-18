package model.path

interface IPath {
    fun getPath(): String
    fun getLastPart(): String
    fun getParts(): List<String>
}
