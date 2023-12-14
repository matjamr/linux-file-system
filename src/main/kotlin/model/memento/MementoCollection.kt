package model.memento

class MementoCollection {
    private var mementoList: MutableList<Memento> = mutableListOf()

    fun addMemento(memento: Memento) {
        mementoList.add(memento)
    }

    fun getMemento(num: Int): Memento {
        return mementoList.get(num)
    }
}
