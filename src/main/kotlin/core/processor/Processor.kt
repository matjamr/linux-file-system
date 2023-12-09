package core.processor

import model.context.Context

interface Processor {
    fun process(context: Context)
}
