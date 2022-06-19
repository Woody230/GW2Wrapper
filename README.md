![](https://img.shields.io/badge/targets-Android%2FJVM-informational)
![](https://img.shields.io/github/v/release/Woody230/GW2Wrapper)
![](https://img.shields.io/github/license/Woody230/GW2Wrapper)
[![](https://img.shields.io/maven-central/v/io.github.woody230.gw2/v2-client)](https://search.maven.org/search?q=io.github.woody230.gw2)

# GW2 Wrapper

Kotlin Multiplatform wrapper of the [GW2 API](https://wiki.guildwars2.com/wiki/API:Main).

## Modules

| Name | Use |
| ---- | --- |
| asset-cdn | Build information from ArenaNet's [asset-cdn](http://assetcdn.101.arenanetworks.com/latest/101). | 
| v2-cache  | [Kodein-DB](https://github.com/Kodein-Framework/Kodein-DB) caching framework for v2-client. |
| v2-chatlink | Base64 chatlink encoding and decoding. |
| v2-client | All v2 endpoints of the [GW2 API](https://wiki.guildwars2.com/wiki/API:Main) as of 2022-03-24T00:00:00Z. |
| v2-emblem | Guild emblem images courtesy of [Werdes](https://emblem.werdes.net/). |
| v2-intl | Internationalization support by mapping translations from GW2 API models. The default English request is mapped to another supported language, which include French, German, Spanish, and Chinese. |
| v2-intl-cache |  [Kodein-DB](https://github.com/Kodein-Framework/Kodein-DB) extensions for storing the v2-intl translations. |
| v2-model | Models for the v2-client and [value class](https://kotlinlang.org/docs/inline-classes.html) wrappers for v2-model-enumeration. |
| v2-model-enumeration | Enumerations for GW2 API models and extensions for mapping the [value class](https://kotlinlang.org/docs/inline-classes.html) wrappers to the associated enumeration. |
| v2-model-extension | Extensions for GW2 API models. |
| v2-resource | Strings and images using [moko-resources](https://github.com/icerockdev/moko-resources). |
| v2-scope | Annotations for permissions required to access GW2 API endpoints. |
| v2-tile | [Tiling service](https://wiki.guildwars2.com/wiki/API:Tile_service) for map images. |
| v2-tile-cache | [Kodein-DB](https://github.com/Kodein-Framework/Kodein-DB) caching framework for v2-tile. |
| v2-tile-image | v2-tile image generator primarily for testing purposes |

## Gradle
Published to [Maven Central](https://search.maven.org/search?q=io.github.woody230.gw2).

```kotlin
repositories {
    mavenCentral()
}
```

```kotlin
implementation("io.github.woody230.gw2:$Module:2.0.1")
```