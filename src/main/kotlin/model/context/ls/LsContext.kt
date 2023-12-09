package model.context.ls

import model.node.INode
import java.lang.RuntimeException

class LsContext {
    companion object {
        @JvmStatic
        fun getInstance(): LsContext {
            return LsContext()
        }
    }
}
