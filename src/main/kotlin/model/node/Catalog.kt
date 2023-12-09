package model.node

import java.util.*

class Catalog(private var name_: String,
              private var parent_: INode?,
              var childrenNodes: MutableList<INode>)
    : Node(parent_, name_) {

    fun findByName(name: String): Catalog = childrenNodes.stream()
        .filter { it is Catalog }
        .filter { it.getName() == name }
        .findFirst()
        .map { it as Catalog }
        .orElseThrow { throw RuntimeException("There is no catalog with given name $name") }

    fun add(node: INode) {
        if (childrenNodes.contains(node)) {
            throw RuntimeException("Node already exists")
        }

        childrenNodes.add(node)
    }

    fun remove(node: INode) {
        childrenNodes.remove(node)
    }
}
