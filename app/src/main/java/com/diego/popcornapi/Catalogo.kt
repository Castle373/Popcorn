package com.diego.popcornapi

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class Catalogo : AppCompatActivity() {
    var adapter: PeliculaAdapter? = null
    var seriesAdapter:PeliculaAdapter?=null
    var peliculas = ArrayList<Pelicula>()
    var series=ArrayList<Pelicula>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo)

        cargarPeliculas()

        adapter = PeliculaAdapter(this,peliculas)
        seriesAdapter= PeliculaAdapter(this,series)
        var gridPeliculas: GridView =findViewById(R.id.gv_peliculas_catalogo)

        gridPeliculas.adapter = adapter
    }

    fun cargarPeliculas(){

        peliculas.add(Pelicula("Big Hero 6",R.drawable.bighero6, R.drawable.headerbighero6, "When a devastating event befalls the city of San Fransokyo and catapults Hiro into the midst of danger, he turns to Baymax and his close friends adrenaline junkie Go Go Tomago, neatnik Wasabi, chemistry whiz Honey Lemon and fanboy Fred. Determined to uncover the mystery, Hiro transforms his friends into a band of high-tech heroes called ‘Big Hero 6.’"))
        peliculas.add(Pelicula("Inception",R.drawable.inception, R.drawable.inceptionheader, "Dom Cobb is a skilled thief, the absolute best in the dangerous art of extraction, stealing valuable secrets from deep within the subconscious during the dream state, when the mind is at its most vulnerable. Cobb's rare ability has made him a coveted player in this treacherous new world of corporate espionage, but it has also made him an international fugitive and cost him everything he has ever loved. Now Cobb is being offered a chance at redemption. One last job could give him his life back but only if he can accomplish the impossible, inception. Instead of the perfect heist, Cobb and his team of specialists have to pull off the reverse: their task is not to steal an idea, but to plant one. If they succeed, it could be the perfect crime. But no amount of careful planning or expertise can prepare the team for the dangerous enemy that seems to predict their every move. An enemy that only Cobb could have seen coming."))
        peliculas.add(Pelicula("Leap Year", R.drawable.leapyear, R.drawable.leapyearheader, "A woman who has an elaborate scheme to propose to her boyfriend on Leap Day, an Irish tradition which occurs every time the date February 29 rolls around, faces a major setback when bad weather threatens to derail her planned trip to Dublin. With the help of an innkeeper, however, her cross-country odyssey just might result in her getting engaged."))
        peliculas.add(Pelicula("Toy Story", R.drawable.toystory, R.drawable.toystoryheader, "Toy Story is about the 'secret life of toys' when people are not around. When Buzz Lightyear, a space-ranger, takes Woody's place as Andy's favorite toy, Woody doesn't like the situation and gets into a fight with Buzz. Accidentaly Buzz falls out the window and Woody is accused by all the other toys of having killed him. He has to go out of the house to look for him so that they can both return to Andys room. But while on the outside they get into all kind of trouble while trying to get home."))
        peliculas.add(Pelicula("Men in black",R.drawable.mib, R.drawable.mibheader, "After a government agency makes first contact with aliens in 1961, alien refugees live in secret on Earth by disguising themselves as humans. Men in Black (MIB) is a secret agency that polices these aliens, protects Earth from extraterrestrial threats, and uses memory-erasing neuralyzers to keep alien activity a secret. MIB agents have their former identities erased while retired agents are neuralyzed. "))


    }
    class PeliculaAdapter : BaseAdapter {
        var peliculas = ArrayList<Pelicula>()
        var context: Context? = null
        constructor(context: Context, peliculas:ArrayList<Pelicula>) : super(){
            this.peliculas = peliculas
            this.context = context
        }

        override fun getCount(): Int {
            return peliculas.size
        }

        override fun getItem(position: Int): Any {
            return peliculas[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }
        override fun getView(position: Int, covertView: View?, parent: ViewGroup? ): View {
            var pelicula = peliculas[position]
            var inflator=context!!.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista=inflator.inflate(R.layout.pelicula,null)
            var image: ImageView = vista.findViewById(R.id.iv_pelicula)
            var title: TextView = vista.findViewById(R.id.tv_titulo)

            image.setImageResource(pelicula.image)
            title.setText(pelicula.titulo)


            image.setOnClickListener(){
                val intento = Intent(context,Detalle_Pelicula::class.java)
                intento.putExtra("titulo",pelicula.titulo)
                intento.putExtra("imagen",pelicula.image)
                intento.putExtra("header",pelicula.header)
                intento.putExtra("sipnosis",pelicula.sipnosis)
                context!!.startActivity(intento)
            }
            return vista

        }
    }
}