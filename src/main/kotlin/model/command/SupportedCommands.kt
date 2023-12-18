package model.command

import core.invoker.Invoker
import core.invoker.cd.CdInvoker
import core.invoker.cd.CdProxy
import core.invoker.common.path.PathResolver2
import core.invoker.cp.CpInvoker
import core.invoker.ls.ARunnable
import core.invoker.ls.LRunnable
import core.invoker.ls.LsInvoker
import core.invoker.ls.RRunnable
import core.invoker.more.MoreInvoker
import core.invoker.more.MoreProxy
import core.invoker.mv.MvInvoker
import core.invoker.mv.MvProxy
import core.invoker.touch.TouchInvoker
import core.invoker.touch.TouchProxy
import core.parser.*
import core.predicate.IsPathPredicate
import model.command.param.IParam
import model.command.param.Param
import model.node.Catalog
import java.lang.RuntimeException

enum class SupportedCommands(var commandName: String,
                             var iParams: List<IParam<Catalog>>,
                             var action: Invoker,
                             var parser: Parser
) {
    LS(
        "ls",
        listOf(
            Param("-l", null, ARunnable(),"Follow all symbolic links to final target and list the file or directory the link references rather than the link itself."),
            Param("-a", null, LRunnable(),"Include directory entries whose names begin with a dot (‘.’) except for . and ...  Automatically set for the super-user unless -I is specified."),
            Param("-r", null, RRunnable(),"Recursively print all subdirectories")
        ),
        LsInvoker(PathResolver2()),
        LsParser(IsPathPredicate())
    ),
    MV("mv", ArrayList(), MvProxy(MvInvoker(PathResolver2()), PathResolver2()), MvParser()),
    CD(
        "cd",
        emptyList(),
        CdProxy(CdInvoker(PathResolver2()), PathResolver2()),
        CdParser()
    ),
    CP(
        "cp",
        emptyList(),
        CpInvoker(PathResolver2()),
        CpParser()
    ),
    TOUCH(
        "touch",
        emptyList(),
        TouchProxy(TouchInvoker(PathResolver2()), PathResolver2()),
        TouchParser()
    ),
    MORE(
        "more",
        emptyList(),
        MoreProxy(MoreInvoker(PathResolver2()), PathResolver2()),
        MoreParser()
    )
    ;

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
