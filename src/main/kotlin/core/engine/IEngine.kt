package core.engine

import model.node.Catalog

interface IEngine {
    fun init(rootCatalog: Catalog): IEngine

    fun run(): IEngine
}
