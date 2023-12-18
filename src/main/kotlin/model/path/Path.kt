package model.path

class Path(val pathName: String): IPath {
    val pathParts: List<String> = pathName.split("/")
        .stream()
        .map { it.strip() }
        .toList()

    override fun getPath(): String = pathName
    override fun getLastPart(): String = pathParts.last()
    override fun getParts(): List<String> = pathParts
}
