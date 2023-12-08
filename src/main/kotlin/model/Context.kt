package model

import model.memento.Catalog
import model.node.INode
import model.node.Node

class Context(
    val catalog: Catalog
) {
    lateinit var currentUser: User
    var abortFlag: Boolean = false
    lateinit var currentNode: INode
    lateinit var input: String
}
