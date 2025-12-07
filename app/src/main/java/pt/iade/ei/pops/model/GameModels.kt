package pt.iade.ei.pops.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameItem(
    val id: String,
    val name: String,
    val description: String,
    val priceUsd: Double
) : Parcelable

@Parcelize
data class Game(
    val id: String,
    val title: String,
    val shortDescription: String,
    @DrawableRes val coverRes: Int,
    val purchasableItems: List<GameItem>
) : Parcelable

object GameStoreRepository {
    fun sampleGames(): List<Game> = listOf(
        Game(
            id = "g01",
            title = "The Last of Us Part I",
            shortDescription = "Uma jornada emocional através de um mundo pós-apocalíptico.",
            coverRes = pt.iade.ei.pops.R.drawable.cover_last_of_us,
            purchasableItems = listOf(
                GameItem(
                    id = "g01i01",
                    name = "Pacote de Recursos",
                    description = "Recursos essenciais para sobrevivência: medicamentos, materiais e munições.",
                    priceUsd = 4.59
                ),
                GameItem(
                    id = "g01i02",
                    name = "Expansão Left Behind",
                    description = "DLC adicional explorando a história de Ellie antes dos eventos principais.",
                    priceUsd = 9.19
                ),
                GameItem(
                    id = "g01i03",
                    name = "Pacote de Skins Premium",
                    description = "Conjunto exclusivo de skins para Ellie e Joel.",
                    priceUsd = 13.99
                )
            )
        ),
        Game(
            id = "g02",
            title = "Assassin's Creed Valhalla",
            shortDescription = "Viva a saga épica dos Vikings na Inglaterra do século IX.",
            coverRes = pt.iade.ei.pops.R.drawable.cover_assassins_creed,
            purchasableItems = listOf(
                GameItem(
                    id = "g02i01",
                    name = "Pacote Berserker",
                    description = "Armaduras e armas lendárias do guerreiro nórdico.",
                    priceUsd = 5.99
                ),
                GameItem(
                    id = "g02i02",
                    name = "Expansão Dawn of Ragnarök",
                    description = "Nova expansão épica com deuses nórdicos e novos reinos.",
                    priceUsd = 10.99
                ),
                GameItem(
                    id = "g02i03",
                    name = "Pacote de Recursos",
                    description = "Recursos para melhorar seu assentamento e equipamentos.",
                    priceUsd = 3.69
                )
            )
        )
    )
}

