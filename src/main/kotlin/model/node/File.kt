package model.node

import model.memento.Memento

class File(
    private var name: String,
    private var parent: INode?,
    var content: String
) : Node(parent, name) {


    constructor(file: File) : this(file.name, file.parent, file.content)

    override fun clone(): File {
        return File(this)
    }

    override fun createMemento(): Memento {
        TODO("Not yet implemented")
    }

    override fun restore(memento: Memento) {
        TODO("Not yet implemented")
    }
}
