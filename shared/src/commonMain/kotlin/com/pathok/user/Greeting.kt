package com.pathok.user

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class SampleDataClass(
    val platform: String,
)

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        val jsonString =
            Json.encodeToString(SampleDataClass.serializer(), SampleDataClass(platform.name))
        return "Hello, Pathok user on ${jsonString}!"
    }
}