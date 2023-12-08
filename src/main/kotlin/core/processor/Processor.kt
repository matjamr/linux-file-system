package core.processor

import model.Context

interface Processor {
    fun process(context: Context)
}
