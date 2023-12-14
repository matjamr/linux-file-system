package core.invoker.common.path

import model.node.INode
import javax.naming.Context

interface IPathResolver {
    fun shouldResolve(path: String, context: Context): Boolean = true
    fun resolve(path: String, context: Context): INode
}
