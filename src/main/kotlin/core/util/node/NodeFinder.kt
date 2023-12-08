package core.util.node

import model.node.INode
import java.lang.RuntimeException

class NodeFinder {
    companion object {

        @JvmStatic
        fun findNodeByName(nodes: List<INode>, name: String): INode {
            return nodes.stream()
                .filter { it.getName() === name }
                .findFirst()
                .orElseThrow { RuntimeException("Cannot find node with name: $name") }
        }

    }
}
