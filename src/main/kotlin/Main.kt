import core.engine.Engine
import core.engine.IEngine
import core.extractor.CommandNameExtractor
import core.extractor.Extractor
import core.processor.*
import model.memento.Catalog
import model.node.Node

fun main() {
    var root: Node = Node(null, "/")
    var dev: Node = Node(root, "dev")
    var usr: Node = Node(root, "usr")
    var andrzejFolder: Node = Node(usr, "andzej")
    var admin: Node = Node(usr, "admin")
    var docs: Node = Node(root, "docs")
    var filtxx: Node = Node(docs, "filetxx")

    var initStateCatalog: Catalog = Catalog(mutableListOf(
        root,
        dev,
        usr,
        admin,
        docs,
        filtxx,
        andrzejFolder
    ))

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

    iEngine.init(initStateCatalog)
    iEngine.run()
}

