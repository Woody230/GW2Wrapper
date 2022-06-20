![](https://img.shields.io/badge/targets-Android%2FJVM-informational)
![](https://img.shields.io/github/v/release/Woody230/GW2Wrapper)
[![](https://img.shields.io/maven-central/v/io.github.woody230.gw2/v2-client)](https://search.maven.org/search?q=io.github.woody230.gw2)
![](https://img.shields.io/github/license/Woody230/GW2Wrapper)

# GW2 Wrapper

Kotlin Multiplatform wrapper of the [GW2 API](https://wiki.guildwars2.com/wiki/API:Main).

# Gradle
Published to [Maven Central](https://search.maven.org/search?q=io.github.woody230.gw2).

```kotlin
repositories {
    mavenCentral()
}
```

```kotlin
implementation("io.github.woody230.gw2:$Module:$Version")
```

# Modules

## asset-cdn
Build information from ArenaNet's [asset-cdn](http://assetcdn.101.arenanetworks.com/latest/101).

```kotlin
val buildId = AssetCdnClient().latest().id
```

## v2-cache
[Kodein-DB](https://github.com/Kodein-Framework/Kodein-DB) caching framework extensions for [v2-client](#v2-client).

```kotlin
val typeTable = TypeTable { gw2() }
```

## v2-chatlink
Base64 [chat link](https://wiki.guildwars2.com/wiki/Chat_link_format) encoding and decoding.

The following chat link types are supported:
* Coin
* Item
* NPC text
* Map (waypoints/points of interest)
* Skill
* Trait
* Recipe
* Wardrobe skin
* Outfit
* World vs. World objective
* Build template

## v2-client
Includes clients for all v2 endpoints of the [GW2 API](https://wiki.guildwars2.com/wiki/API:Main) as of schema 2022-03-24T00:00:00Z.

```kotlin
// Set up the configuration so that a defaulted model is returned instead of throwing an exception when errors occur.
// The configuration can also be used to set up a global token or language.
val configuration = Gw2ClientConfiguration(exceptionRecoveryMode = ExceptionRecoveryMode.DEFAULT)
val gw2 = Gw2Client(configuration = configuration)

val allWorlds: Collection<World> = gw2.world.worlds()

// Note that requests for models by id will automatically segment requests based on the configured page size, which by default set to the maximum value of 200.
val worldIds: Collection<WorldId> = gw2.world.worldIds()
val worldsById: Collection<World> = gw2.world.worlds(worldIds)

// Request the worlds with a Spanish translation.
val worldsWithLanguage: Collection<World> = gw2.world.worlds(worldIds, Language("es"))
```

## v2-emblem
Guild emblem images courtesy of [Werdes](https://emblem.werdes.net/). 

```kotlin
// Note that this client is separate from the v2-client EmblemClient.
val emblem: EmblemClient = com.bselzer.gw2.v2.emblem.client.EmblemClient()

val guildId: String = "c19c41d3-752d-e911-81a8-cde2ac1eed30"
val request: EmblemRequest = emblem.requestEmblem(guildId)

// Construct the url but don't make the request.
val url: String = emblem.emblemUrl(request)

// Make the request and get the image as bytes.
val bytes: ByteArray = emblem.emblem(request)
```

## v2-intl
 Internationalization support by mapping translations from GW2 API models. The default English request is mapped to another supported language, which include French, German, Spanish, and Chinese. 

 Only a subset of models have translations mapped. Currently this includes continent/map and World vs. World related models.

 ```kotlin
 val gw2 = Gw2Client()
 val id = WorldId(1013)
 val defaultWorld = gw2.world.world(id)
 val spanishWorld = gw2.world.world(id, Language("es"))

 val translator = Gw2Translators.world
 val translations = translator.translations(defaultWorld, spanishWorld, "es")
 ```

 ## v2-intl-cache
[Kodein-DB](https://github.com/Kodein-Framework/Kodein-DB) caching framework extensions for storing the [v2-intl](#v2-intl) translations.

```kotlin
// You will likely want to check that the language is not for English before trying to request translations.
suspend fun putMissingWorlds(
    database: DB, 
    gw2: Gw2Client,
) = database.transaction().use {
    putMissingTranslations(
        translator = Gw2Translator.world,
        defaults = gw2.world.worlds(),
        language = Language("es")
        requestTranslated = { ids, language -> gw2.world.worlds(ids, language) }
    )
}
```

## v2-model
Models for the [v2-client](#v2-client) and [value class](https://kotlinlang.org/docs/inline-classes.html) wrappers for [v2-model-enumeration](#v2-model-enumeration). 

See the [KotlinExtensions](https://github.com/Woody230/KotlinExtensions) value module for more information. The `Identifiable` and `Identifier` classes are used across all models as applicable. 

For instance, the `WvwMapObjectiveId` is referenced by the `WvwObjectiveLink` for chat links, the `WvwClient` for requesting `WvwObjective` ids and models, `WvwMatch` has a collection of objectives for match specific information via the `WvwMapObjective` model, and finally the `WvwObjective` model for general objective information.

## v2-model-enumeration
Enumerations for [v2-model](#v2-model) classes and extensions for mapping the [value class](https://kotlinlang.org/docs/inline-classes.html) wrappers to the associated enumeration.

```kotlin
val id = WvwMapObjectiveId("94-35")
val objective = Gw2Client().wvw.objective(id)

// Value classes are found within model.enumeration.wrapper from the v2-model module
val type: com.bselzer.gw2.v2.model.enumeration.wrapper.WvwObjectiveType = objective.type

// The associated enums are found within model.enumeration
val enumType: com.bselzer.gw2.v2.model.enumeration.WvwObjectiveType = type.enumValueOrNull()
```

## v2-model-extension
Extensions for [v2-model](#v2-model) classes. Currently these are focused on World. vs World. related models.

## v2-resource
Strings and images using [moko-resources](https://github.com/icerockdev/moko-resources). 

Strings are available for the German, English, French, and Spanish languages.

Resources are generated with the name `Gw2Resources`:
```kotlin
val eternalBattlegrounds = Gw2Resources.strings.eternal_battlegrounds
```

## v2-scope
Annotations for permissions required to access GW2 API endpoints.
Currently these are only for informational purposes.

## v2-tile
[Tiling service](https://wiki.guildwars2.com/wiki/API:Tile_service) for map images.

```kotlin
val gw2 = Gw2Client()

val continentId = ContinentId(2)
val floorId = FloorId(3)

val continent = gw2.continent.continent(continentId)
val floor = gw2.continent.floor(continentId, floorId)

val tile = TileClient()
val zoom = 3
val grid = tile.grid(continent, floor, zoom)
```

## v2-tile-cache
[Kodein-DB](https://github.com/Kodein-Framework/Kodein-DB) caching framework extensions for [v2-tile](#v2-tile).

* `TileGridMetadataExtractor`
* `TileMetadataExtractor`

## v2-tile-image
[v2-tile](#v2-tile) image generator currently only implemented in Android for testing purposes only. This module may be removed or changed at any time.