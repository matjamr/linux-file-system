import core.parser.extractor.Extractor
import core.parser.extractor.ParamsExtractor
import model.command.param.Param

fun main() {
    val paramsExtractor: Extractor<List<Param>, String> = ParamsExtractor()

    println(paramsExtractor.extract("find -f cieply"))
}
