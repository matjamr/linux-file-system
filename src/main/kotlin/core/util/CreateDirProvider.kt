package core.util

import model.node.Catalog
import model.node.File
import model.node.INode

class CreateDirProvider: Provider {
    override fun provide(nodeName: String, node: INode): INode {
        val tmpNode: INode = if(node is Catalog) {
            Catalog(nodeName, node, mutableListOf())
        } else {
            File(nodeName, node, "")
        }

        (node as Catalog).childrenNodes.add(tmpNode)

        return tmpNode
    }
}
