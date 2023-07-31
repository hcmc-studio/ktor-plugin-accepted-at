package studio.hcmc.ktor.plugin

import io.ktor.server.application.*
import io.ktor.util.*
import kotlinx.datetime.Clock

private val acceptedAtAttributeKey = AttributeKey<kotlinx.datetime.Instant>("acceptedAt")

var ApplicationCall.acceptedAt: kotlinx.datetime.Instant
    get() = attributes[acceptedAtAttributeKey]
    set(value) { attributes.put(acceptedAtAttributeKey, value) }

val AcceptedAt = createApplicationPlugin("AcceptedAtPlugin") {
    onCall { call ->
        call.acceptedAt = Clock.System.now()
    }
}