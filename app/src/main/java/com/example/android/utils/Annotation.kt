package com.ilogic.roid.hub.utils


class Annotation {

    enum class Info {RECEIVE, DELIVERY}

    @Target(AnnotationTarget.CLASS)
    @Retention(AnnotationRetention.RUNTIME)
    annotation class Infos(val info: Info)
}