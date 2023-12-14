package core.invoker.common.path

import model.context.Context
import model.node.Catalog
import model.node.INode

private const val GO_UP = ".."

// TODO refactor
class PathResolver {
    fun resolve(path: String, context: Context): INode {
        if (path.startsWith("/")) {
            return absolutePathResolver(path, context)
        } else if (path == "." || path == "./") {
            return currentDirResolver(path, context)
        }

        return upperDirResolver(path, context)

    }

    private fun upperDirResolver(path: String, context: Context): INode {
        var tmpNode: Catalog = context.currentCatalog
        val paths: List<String> = path.split("/")

        for (tmpPath: String in paths) {

            if (tmpPath.strip() == "" || tmpPath.strip() == ".")
                continue

            tmpNode = if (tmpPath == GO_UP && tmpNode.getParent() != null) {
                tmpNode.getParent() as Catalog
            } else {
                tmpNode.findByName(tmpPath)
            }
        }

        return tmpNode
    }

    private fun currentDirResolver(path: String, context: Context): INode {
        return context.currentCatalog
    }

    private fun absolutePathResolver(path: String, context: Context): INode {
        var tmpNode = context.rootNode as Catalog


        var tmpPath = path.replace("./", "")
            .replace(".", "")

        val splittedPath = tmpPath.split("/")
        for (catalogName: String in splittedPath) {
            tmpNode = tmpNode.childrenNodes.stream()
                .filter { it is Catalog }
                .map { it as Catalog }
                .filter { it.getName() == catalogName }
                .findFirst()
                .orElseThrow { RuntimeException("Invalid path provided") }
        }


        return context.currentCatalog
    }
}
