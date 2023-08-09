package studio.hcmc.ktor.plugin

import io.ktor.server.application.*
import io.ktor.util.*
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

private val acceptedAtAttributeKey = AttributeKey<Instant>("acceptedAt")

var ApplicationCall.acceptedAt: Instant
    get() = attributes[acceptedAtAttributeKey]
    set(value) { attributes.put(acceptedAtAttributeKey, value) }

val AcceptedAt = createApplicationPlugin("AcceptedAtPlugin") {
    onCall { call ->
        call.acceptedAt = Clock.System.now()
    }
}