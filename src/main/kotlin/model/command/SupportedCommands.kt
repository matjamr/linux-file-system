package model.command

import core.parser.Parser
import core.action.IAction
import core.action.cd.CdAction
import core.action.common.ShowCatalogRunnable
import core.action.common.path.PathResolver
import core.action.ls.ARunnable
import core.action.ls.LRunnable
import core.action.ls.LsAction
import core.action.ls.RRunnable
import core.action.mv.MvAction
import core.parser.CdParser
import core.parser.LsParser
import core.parser.MvParser
import core.predicate.IsPathPredicate
import model.command.param.IParam
import model.command.param.Param
import model.node.Catalog
import java.lang.RuntimeException

enum class SupportedCommands(var commandName: String,
                             var iParams: List<IParam<Catalog>>,
                             var action: IAction,
                             var parser: Parser
) {
    LS(
        "ls",
        listOf(
            Param("-l", null, ARunnable(),"Follow all symbolic links to final target and list the file or directory the link references rather than the link itself."),
            Param("-a", null, LRunnable(),"Include directory entries whose names begin with a dot (‘.’) except for . and ...  Automatically set for the super-user unless -I is specified."),
            Param("-r", null, RRunnable(),"Recursively print all subdirectories")
        ),
        LsAction(PathResolver()),
        LsParser(IsPathPredicate())
    ),
    MV("mv", ArrayList(), MvAction(), MvParser()),
    CD(
        "cd",
        emptyList(),
        CdAction(PathResolver()),
        CdParser()
    );

    //    RM("rm"),
//    RM_DIR("rmdir"),
//    TOUCH("touch"),

    fun getParamNames(): List<String> = iParams.stream()
        .map { it.getName() }
        .toList()

    fun findParamByName(paramName: String): IParam<Catalog> = iParams.stream()
        .filter { it.getName() == paramName }
        .findFirst()
        .orElseThrow { RuntimeException("There is no param with name $paramName") }
}
