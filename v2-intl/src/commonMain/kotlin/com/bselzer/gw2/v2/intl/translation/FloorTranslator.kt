package com.bselzer.gw2.v2.intl.translation

import com.bselzer.gw2.v2.intl.model.Translations
import com.bselzer.gw2.v2.model.continent.floor.Floor
import com.bselzer.ktx.function.collection.addTo

class FloorTranslator : Translator<Floor> {
    override fun translations(default: Floor, translated: Floor, language: String) = buildList {
        default.regions.values.zip(translated.regions.values) { defaultRegion, translatedRegion ->
            Translations(
                default = defaultRegion.name,
                translated = translatedRegion.name,
                language = language
            ).addTo(this)

            defaultRegion.maps.values.zip(translatedRegion.maps.values) { defaultMap, translatedMap ->
                Translations(
                    default = defaultMap.name,
                    translated = translatedMap.name,
                    language = language
                ).addTo(this)

                defaultMap.pointsOfInterest.values.zip(translatedMap.pointsOfInterest.values) { defaultPoi, translatedPoi ->
                    Translations(
                        default = defaultPoi.name,
                        translated = translatedPoi.name,
                        language = language
                    ).addTo(this)
                }

                defaultMap.renownHearts.values.zip(translatedMap.renownHearts.values) { defaultHeart, translatedHeart ->
                    Translations(
                        default = defaultHeart.objective,
                        translated = translatedHeart.objective,
                        language = language
                    ).addTo(this)
                }

                defaultMap.sectors.values.zip(translatedMap.sectors.values) { defaultSector, translatedSector ->
                    Translations(
                        default = defaultSector.name,
                        translated = translatedSector.name,
                        language = language
                    ).addTo(this)
                }

                defaultMap.adventures.zip(translatedMap.adventures) { defaultAdventure, translatedAdventure ->
                    Translations(
                        default = defaultAdventure.name,
                        translated = translatedAdventure.name,
                        language = language
                    ).addTo(this)
                }
            }
        }
    }
}