package model.node

import model.memento.Memento
import java.util.*

// kompozyt
class Catalog(private var name_: String,
              private var parent_: INode?,
              var childrenNodes: MutableList<INode>)
    : Node(parent_, name_) {


    override fun clone(): Catalog {
        return Catalog(this)
    }

    constructor(catalog: Catalog) : this(catalog.name_, catalog.parent_, catalog.childrenNodes)

    override fun createMemento(): Memento {
        return Memento(name_, parent_)
    }

    override fun restore(memento: Memento) {
        TODO("Not yet implemented")
    }

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

    fun rename(nodeFrom: INode, nodeTo: INode) {
    }

    fun move(nodeFrom: INode, nodeTo: INode) {

    }
}
