package com.bselzer.gw2.v2.client.result

import com.bselzer.gw2.v2.scope.core.Permission
import com.bselzer.ktx.serialization.context.JsonContext
import io.ktor.client.call.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.json.JsonObject

sealed class HttpError(val response: HttpResponse) {
    class Default(response: HttpResponse) : HttpError(response)

    sealed class BadRequest(response: HttpResponse) : HttpError(response) {
        class Default(response: HttpResponse, val reason: String) : BadRequest(response) {
            override fun toString(): String = "BadRequest due to `$reason`. ${super.toString()}"
        }

        class MissingCharacter(response: HttpResponse) : BadRequest(response) {
            override fun toString(): String = "Account owner does not own the character. ${super.toString()}"
        }

        class MissingContinent(response: HttpResponse) : BadRequest(response) {
            override fun toString(): String = "Continent id is not available. ${super.toString()}"
        }

        class MissingFloor(response: HttpResponse) : BadRequest(response) {
            override fun toString(): String = "Floor id is not available. ${super.toString()}"
        }

        class MissingRegion(response: HttpResponse) : BadRequest(response) {
            override fun toString(): String = "Region id is not available. ${super.toString()}"
        }

        class MissingMap(response: HttpResponse) : BadRequest(response) {
            override fun toString(): String = "Map id is not available. ${super.toString()}"
        }
    }

    /**
     * The access token is not provided.
     */
    class Unauthorized(response: HttpResponse) : HttpError(response) {
        override fun toString(): String = "Access token is not provided. ${super.toString()}"
    }

    sealed class Forbidden(response: HttpResponse) : HttpError(response) {
        class Default(response: HttpResponse, val reason: String) : BadRequest(response) {
            override fun toString(): String = "Forbidden due to `$reason`. ${super.toString()}"
        }

        /**
         * The access token is missing one or more permissions.
         */
        class PermissionRequired(response: HttpResponse, val permissions: List<Permission>) : Forbidden(response) {
            override fun toString(): String = "Permissions required: ${permissions.joinToString()}. ${super.toString()}"
        }

        /**
         * The account owner must be the leader of the guild.
         */
        class GuildLeaderRequired(response: HttpResponse) : Forbidden(response) {
            override fun toString(): String = "Account owner must be the leader of the guild. ${super.toString()}"
        }

        /**
         * The account owner must be a member of the guild.
         */
        class GuildMemberRequired(response: HttpResponse) : Forbidden(response) {
            override fun toString(): String = "Account owner must be a member of the guild. ${super.toString()}"
        }
    }

    sealed class NotFound(response: HttpResponse) : HttpError(response) {
        class Default(response: HttpResponse, val reason: String) : BadRequest(response) {
            override fun toString(): String = "NotFound due to `$reason`. ${super.toString()}"
        }

        class Endpoint(response: HttpResponse) : NotFound(response) {
            override fun toString(): String = "Endpoint not found. ${super.toString()}"
        }

        class MissingId(response: HttpResponse) : HttpError(response) {
            override fun toString(): String = "Id is not available. ${super.toString()}"
        }

        class MissingIds(response: HttpResponse) : HttpError(response) {
            override fun toString(): String = "All ids are not available. ${super.toString()}"
        }

        class MissingGuild(response: HttpResponse) : BadRequest(response) {
            override fun toString(): String = "Guild id is not available. ${super.toString()}"
        }

        class MissingLeaderboard(response: HttpResponse) : BadRequest(response) {
            override fun toString(): String = "PvP leaderboard type is not available. ${super.toString()}"
        }
    }

    override fun toString(): String = "${response.request.method.value} request to ${response.request.url} failed with status code ${response.status}."

    companion object {
        internal suspend fun HttpResponse.error(): HttpError {
            val response = this
            return when (response.status) {
                HttpStatusCode.BadRequest -> response.badRequest(reason())
                HttpStatusCode.Unauthorized -> Unauthorized(response)
                HttpStatusCode.Forbidden -> response.forbidden(reason())
                HttpStatusCode.NotFound -> response.notFound(reason())
                else -> Default(response)
            }
        }

        private fun HttpResponse.badRequest(reason: String): HttpError = when (reason) {
            "no such character" -> BadRequest.MissingCharacter(this)
            "invalid continent id specified" -> BadRequest.MissingContinent(this)
            "invalid floor specified" -> BadRequest.MissingFloor(this)
            "invalid region specified" -> BadRequest.MissingRegion(this)
            "invalid map specified" -> BadRequest.MissingMap(this)
            else -> BadRequest.Default(this, reason)
        }

        private fun HttpResponse.notFound(reason: String): HttpError = when (reason) {
            "not found" -> NotFound.Endpoint(this)
            "no such id" -> NotFound.MissingId(this)
            "all ids provided are invalid" -> NotFound.MissingIds(this)
            "no such guild" -> NotFound.MissingGuild(this)
            "no such leaderboard" -> NotFound.MissingLeaderboard(this)
            else -> NotFound.Default(this, reason)
        }

        private fun HttpResponse.forbidden(reason: String): HttpError = when {
            reason == "access restricted to guild leaders" -> Forbidden.GuildLeaderRequired(this)
            reason == "membership required" -> Forbidden.GuildMemberRequired(this)
            reason.startsWith("requires scope") -> {
                val names = reason.replaceFirst("requires scope", "").trim().split(",")
                val permissions = with(JsonContext) { names.decode<Permission>() }
                Forbidden.PermissionRequired(this, permissions)
            }
            else -> Forbidden.Default(this, reason)
        }

        private suspend fun HttpResponse.reason(): String {
            val json = try {
                body<JsonObject>()
            } catch (ex: Exception) {
                return ""
            }

            return json["text"].toString()
        }
    }
}

