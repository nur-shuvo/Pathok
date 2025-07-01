package com.pathok.user

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform