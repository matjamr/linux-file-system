package core.util

import com.github.javafaker.Faker
import model.node.Catalog
import model.node.File
import model.node.INode

class CreateDirProvider: Provider {
    var from: INode? = null
    override fun provide(nodeName: String, node: INode): INode {

        if((from is Catalog && node is File) || (node is Catalog && from is File))
            throw RuntimeException("Cannot move incompatible types")

        val tmpNode: INode = if(node is Catalog) {
            Catalog(nodeName, node, (from as Catalog).childrenNodes)
        } else {
            File(nodeName, node, Faker().lorem().sentence(1000))
        }

        (node as Catalog).childrenNodes.add(tmpNode)

        return tmpNode
    }
}
