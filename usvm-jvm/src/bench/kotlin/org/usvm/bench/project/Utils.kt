package org.usvm.bench.project

import org.jacodb.api.jvm.JcClasspath
import org.jacodb.api.jvm.JcMethod
import org.jacodb.api.jvm.ext.findFieldOrNull
import org.jacodb.api.jvm.ext.findMethodOrNull
import org.jacodb.api.jvm.ext.humanReadableSignature

object Utils {
    const val projectFileName = "project.json"
    const val persistenceFileName = "jacodb"
    const val classesDirName = "classes"
}

fun getFqnFromHrs(hrs: String): String {
    return hrs.split('#').first()
}

fun JcClasspath.getMethodByHrs(hrs: String): JcMethod? {
    val clsFqn = getFqnFromHrs(hrs)
    return findClassOrNull(clsFqn)?.declaredMethods?.find { it.humanReadableSignature == hrs }
}
