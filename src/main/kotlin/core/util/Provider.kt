package core.util

import model.node.INode

interface Provider {
    fun provide(nodeName: String, node: INode): INode
}
