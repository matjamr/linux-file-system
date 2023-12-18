package model.path

class PathProxy(val path: Path): IPath {

    private val forbiddenChars: List<String> = "#$@!$%^&()1234567890+={[}]|\\\'\";:?><,~`£§".split("")

    override fun getPath(): String {
        isValid(path.pathName)

        return path.getPath()
    }

    override fun getLastPart(): String = path.getLastPart()

    override fun getParts(): List<String> = path.getParts()

    private fun isValid(pathName: String) {
        if(pathName.split("/")
                .map { it.strip() }
                .any { name ->  forbiddenChars.filter{ char -> char != "" }.any { char -> name.contains(char) } }) {
            throw RuntimeException("Invalid path inserted")
        }
    }
}
