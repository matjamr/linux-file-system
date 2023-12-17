package model.context

import model.memento.MementoCollection
import model.node.Catalog
import model.node.INode
import model.user.User

class Context(
) {
    lateinit var currentUser: User
    var abortFlag: Boolean = false
    lateinit var currentNode: INode
    lateinit var rootNode: INode
    lateinit var input: String
    lateinit var mementoCollection: MementoCollection
}
