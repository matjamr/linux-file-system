package model.context

import model.node.Catalog
import model.node.INode
import model.user.User

class Context(
) {
    lateinit var currentUser: User
    var abortFlag: Boolean = false
    lateinit var currentNode: INode
    lateinit var input: String
    lateinit var currentCatalog: Catalog
}
