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

    override fun getName(): String = name_

    constructor(catalog: Catalog) : this(catalog.name_, catalog.parent_, catalog.childrenNodes)

    override fun createMemento(): Memento {
        return Memento(name_, parent_)
    }

    override fun restore(memento: Memento) {
        TODO("Not yet implemented")
    }

    override fun setName(name: String) {
        this.name_ = name
    }

    fun findByName(name: String): Optional<INode> = childrenNodes.stream()
        .filter { it.getName() == name }
        .findFirst()

    fun findFileByName(name: String): Optional<File> = childrenNodes.stream()
        .filter { it is File }
        .filter { it.getName() == name }
        .map { it as File }
        .findFirst()


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
