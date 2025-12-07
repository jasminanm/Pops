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
    val genre: String,
    val shortDescription: String,
    val rating: Double,
    @DrawableRes val coverRes: Int,
    val featuredTag: String,
    val purchasableItems: List<GameItem>
) : Parcelable

object GameStoreRepository {
    fun sampleGames(): List<Game> = listOf(
        Game(
            id = "g01",
            title = "The Last of Us Part I",
            genre = "Ação-Aventura",
            shortDescription = "Uma jornada emocional através de um mundo pós-apocalíptico.",
            rating = 4.9,
            coverRes = pt.iade.ei.pops.R.drawable.cover_last_of_us,
            featuredTag = "Escolha da Equipa",
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
            genre = "RPG de Ação",
            shortDescription = "Viva a saga épica dos Vikings na Inglaterra do século IX.",
            rating = 4.7,
            coverRes = pt.iade.ei.pops.R.drawable.cover_assassins_creed,
            featuredTag = "Novo",
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

