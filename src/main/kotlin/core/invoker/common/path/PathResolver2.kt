package core.invoker.common.path

import core.util.Provider
import model.context.Context
import model.node.Catalog
import model.node.File
import model.node.INode
import java.util.*
import java.util.function.Supplier

private const val GO_UP = ".."
private const val THIS_DIR = "."


// dupa -> a.txt -> w
class PathResolver2 {

    fun resolve(path: String, context: Context, provider: Provider): INode {

        var tmpNode: INode = getCurrentNode(path, context)
        var pathDirs: List<String> = splitPath(path)

        for (pathNodeName: String in pathDirs) {
            if(pathNodeName == THIS_DIR) continue

            tmpNode = if(pathNodeName == GO_UP) {
                goUp(tmpNode)
            } else {
                getNextNode(tmpNode, pathNodeName, provider)
            }
        }

        return tmpNode
    }

    private fun goUp(tmpNode: INode): INode {
        return Optional.ofNullable(tmpNode.getParent())
            .orElseThrow { RuntimeException("Node $tmpNode does not have parent, invalid path") }
    }

    private fun getNextNode(tmpNode: INode, currentPath: String, provider: Provider): INode {
        var ret = (tmpNode as Catalog)
            .findByName(currentPath)

        return if (ret.isPresent) {
            ret.get()
        } else {
            provider.provide(currentPath, tmpNode)
        }
    }

    private fun getCurrentNode(path: String, context: Context): INode {
        return if (path.strip().startsWith("/")) {
            context.rootNode
        } else {
            context.currentNode
        }
    }

    private fun splitPath(path: String): List<String> = path.split("/").stream()
        .map { it.strip() }
        .filter { it.isNotEmpty() }
        .toList()
}
