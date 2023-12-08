package core.engine

import model.Context
import model.memento.Catalog

interface IEngine {
    fun init(catalog: Catalog)

    fun run()
}
