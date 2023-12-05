package core.parser.extractor

interface Extractor<T, R> {
    fun extract(data: R): T
}
