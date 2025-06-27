package com.byteutility.dev.pathok

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform