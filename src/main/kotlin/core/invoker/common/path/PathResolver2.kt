package core.invoker.common.path

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

    fun resolve(path: String, context: Context, supplier: Supplier<INode>): INode {

        var tmpNode: INode = getCurrentNode(path, context)
        var pathDirs: List<String> = path.split("/")

        for (i in 0..pathDirs.size) {
            var currentPath: String = pathDirs[i]

            if(currentPath == THIS_DIR) continue

            tmpNode = if(currentPath == GO_UP) {
                goUp(tmpNode)
            } else {
                getNextNode(tmpNode, currentPath, supplier)
            }
        }

        return tmpNode
    }

    private fun goUp(tmpNode: INode): INode {
        return Optional.ofNullable(tmpNode.getParent())
            .orElseThrow { RuntimeException("Node $tmpNode does not have parent, invalid path") }
    }

    private fun getNextNode(tmpNode: INode, currentPath: String, supplier: Supplier<INode>): INode {
        return (tmpNode as Catalog)
            .findByName(currentPath)
            .orElseGet(supplier)
    }

    private fun getCurrentNode(path: String, context: Context): INode {
        return if (path.startsWith("/")) {
            context.rootNode
        } else {
            context.currentCatalog
        }
    }

    fun resolvePathWithDirectoryCreate(path: String, context: Context): INode {
        if (path.startsWith("/")) {
            return absolutePathResolverWithDirectoryCreation(path, context)
        } else if (path == "." || path == "./") {
            return currentDirResolver(path, context)
        }

        return upperDirResolverWithCreate(path, context)
    }

    private fun upperDirResolver(path: String, context: Context): INode {
        var tmpNode: INode = context.currentCatalog
        val paths: List<String> = path.split("/")

        for (tmpPath: String in paths) {
            if (tmpPath.strip() == "" || tmpPath.strip() == ".")
                continue

            if (tmpPath == GO_UP && tmpNode.getParent() != null) {
                tmpNode = tmpNode.getParent() as Catalog
            } else {
                var tmp = (tmpNode as Catalog).findByName(tmpPath)

                if(tmp.isEmpty)
                    tmpNode = findFileByName(tmpNode, paths, tmpPath)
                else {
                    tmpNode = tmp.get()
                }
            }
        }

        return tmpNode
    }

    private fun findFileByName(tmpNode: Catalog, paths: List<String>, tmpPath: String): INode {
//        if(paths.last() != tmpPath) {
//            throw RuntimeException("OJ MATE ERROR")
//        }

        return tmpNode.findFileByName(tmpPath)
            .orElseThrow { RuntimeException("aaaa") }

    }

    private fun currentDirResolver(path: String, context: Context): INode {
        return context.currentCatalog
    }

    private fun absolutePathResolver(path: String, context: Context): INode {
        var tmpNode: Catalog = context.rootNode as Catalog
        val paths: List<String> = path.split("/")

        for (tmpPath: String in paths) {
            if (tmpPath.strip() == "" || tmpPath.strip() == ".")
                continue

            tmpNode = if (tmpPath == GO_UP && tmpNode.getParent() != null) {
                tmpNode.getParent() as Catalog
            } else {
                tmpNode.findByName(tmpPath)
                    .map { it as Catalog }
                    .orElseThrow { throw RuntimeException("There is no catalog with given name $tmpPath") }
            }
        }

        return tmpNode
    }

    private fun absolutePathResolverWithDirectoryCreation(path: String, context: Context): INode {
        var tmpNode: Catalog = context.rootNode as Catalog
        val paths: List<String> = path.split("/")

        for (tmpPath: String in paths) {
            if (tmpPath.strip() == "" || tmpPath.strip() == ".")
                continue

            tmpNode = if (tmpPath == GO_UP && tmpNode.getParent() != null) {
                tmpNode.getParent() as Catalog
            } else {
                tmpNode.findByName(tmpPath)
                    .map { it as Catalog }
                    .orElseGet {
                        val cat = Catalog(tmpPath, tmpNode, mutableListOf())
                        tmpNode.add(cat)

                        cat
                    }
            }
        }

        return tmpNode
    }

    private fun upperDirResolverWithCreate(path: String, context: Context): INode {
        var tmpNode: Catalog = context.currentCatalog as Catalog
        val paths: List<String> = path.split("/")

        for (tmpPath: String in paths) {
            if (tmpPath.strip() == "" || tmpPath.strip() == ".")
                continue

            tmpNode = if (tmpPath == GO_UP && tmpNode.getParent() != null) {
                tmpNode.getParent() as Catalog
            } else {
                tmpNode.findByName(tmpPath)
                    .map { it as Catalog }
                    .orElseGet {
                        val cat = Catalog(tmpPath, tmpNode, mutableListOf())
                        tmpNode.add(cat)

                        cat
                    }
            }
        }

        return tmpNode
    }
}