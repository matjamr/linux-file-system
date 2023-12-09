package core.predicate

import java.util.function.Predicate


class IsPathPredicate: Predicate<String> {

    val pathRegex = Regex("^(\\.|\\.\\.)?/?(/([a-zA-Z0-9_-]+/)*[a-zA-Z0-9_-]+/?)?\$")

    override fun test(maybePath: String): Boolean = pathRegex.matches(maybePath);
}
