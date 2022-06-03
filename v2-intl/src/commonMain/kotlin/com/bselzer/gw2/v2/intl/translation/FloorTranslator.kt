package com.bselzer.gw2.v2.intl.translation

import com.bselzer.gw2.v2.intl.model.Translation
import com.bselzer.gw2.v2.model.continent.floor.Floor
import com.bselzer.ktx.function.collection.addTo

class FloorTranslator : Translator<Floor> {
    override fun text(model: Floor): List<String> = buildList {
        model.regions.values.forEach { region ->
            add(region.name)

            region.maps.values.forEach { map ->
                add(map.name)

                map.pointsOfInterest.values.forEach { poi -> add(poi.name) }
                map.renownHearts.values.forEach { heart -> add(heart.objective) }
                map.sectors.values.forEach { sector -> add(sector.name) }
                map.adventures.forEach { adventure -> add(adventure.name) }
            }
        }
    }

    override fun translations(default: Floor, translated: Floor, language: String) = buildList {
        default.regions.values.zip(translated.regions.values) { defaultRegion, translatedRegion ->
            Translation(
                default = defaultRegion.name,
                translated = translatedRegion.name,
                language = language
            ).addTo(this)

            defaultRegion.maps.values.zip(translatedRegion.maps.values) { defaultMap, translatedMap ->
                Translation(
                    default = defaultMap.name,
                    translated = translatedMap.name,
                    language = language
                ).addTo(this)

                defaultMap.pointsOfInterest.values.zip(translatedMap.pointsOfInterest.values) { defaultPoi, translatedPoi ->
                    Translation(
                        default = defaultPoi.name,
                        translated = translatedPoi.name,
                        language = language
                    ).addTo(this)
                }

                defaultMap.renownHearts.values.zip(translatedMap.renownHearts.values) { defaultHeart, translatedHeart ->
                    Translation(
                        default = defaultHeart.objective,
                        translated = translatedHeart.objective,
                        language = language
                    ).addTo(this)
                }

                defaultMap.sectors.values.zip(translatedMap.sectors.values) { defaultSector, translatedSector ->
                    Translation(
                        default = defaultSector.name,
                        translated = translatedSector.name,
                        language = language
                    ).addTo(this)
                }

                defaultMap.adventures.zip(translatedMap.adventures) { defaultAdventure, translatedAdventure ->
                    Translation(
                        default = defaultAdventure.name,
                        translated = translatedAdventure.name,
                        language = language
                    ).addTo(this)
                }
            }
        }
    }
}