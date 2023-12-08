package core.extractor

class CommandNameExtractor: Extractor<String, String> {
    override fun extract(data: String): String = data.split(" ")[0]
}
