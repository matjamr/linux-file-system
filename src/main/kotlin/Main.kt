import core.engine.Engine
import core.engine.IEngine
import core.extractor.CommandNameExtractor
import core.extractor.Extractor
import core.processor.*
import model.node.Catalog
import model.node.File

fun main() {
    var rootCatalog: Catalog = Catalog("/", null, mutableListOf())
    var devCatalog: Catalog = Catalog("dev", rootCatalog, mutableListOf())
    var usrCatalog: Catalog = Catalog("usr", rootCatalog, mutableListOf())
    var adminCatalog: Catalog = Catalog("admin", usrCatalog, mutableListOf())
    var docsCatalog: Catalog = Catalog("docs", rootCatalog, mutableListOf())
    var fileDotXX: File = File("file.xx", docsCatalog, "Some Content")

    docsCatalog.add(fileDotXX)
    usrCatalog.add(adminCatalog)
    rootCatalog.add(devCatalog)
    rootCatalog.add(usrCatalog)
    rootCatalog.add(docsCatalog)


    val extractor: Extractor<String, String> = CommandNameExtractor()

    val userLoader: Processor = UserLoader()
    val actionInputHandler: Processor = ActionInputHandler()
    val initialConfigRunner: Processor = InitialConfigRunner()
    val commandProcessor: Processor = CommandProcessor(extractor)

    val iEngine: IEngine = Engine(listOf(
        userLoader,
        initialConfigRunner,
        actionInputHandler,
        commandProcessor
    ))

    iEngine.init(rootCatalog)
        .run()
}

