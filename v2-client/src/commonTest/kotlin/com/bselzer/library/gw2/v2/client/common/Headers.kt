import io.ktor.http.*

/**
 * The [ContentType] as a [Headers]
 */
fun ContentType.asHeader(): Headers = headersOf(HttpHeaders.ContentType, listOf(this.toString()))