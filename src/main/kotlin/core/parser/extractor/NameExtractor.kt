package core.parser.extractor

class NameExtractor: Extractor<String, String> {
    override fun extract(data: String): String = data.split(" ")[0]
}
