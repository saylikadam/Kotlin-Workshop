import java.time.LocalDate

data class Movie(val imdbID: String,
            val title: String,
            val releaseDate: LocalDate,
            val genres:List<Genres>,
            val director: String,
            val actor:List<String>,
            val actress:List<String>,
            val duration: Int)

enum class Genres {
    COMEDY,
    DRAMA,
    ACTION
}
class  MovieStore(val movies: List<Movie>) {

    fun getMovieAvailableForAnActor(actor: String): List<Movie> {
        return movies.filter {  it.actor.contains(actor) }
    }

    fun getMovieAvailableForAnActress(actress: String): List<Movie> {
        return movies.filter {  it.actress.contains(actress) }
    }

    fun getMoviesFromGivenReleaseYear(year: Int): List<Movie> {
        return movies.filter { it.releaseDate.year.equals(year) }
    }

    fun getMoviesMoreThanGivenDuration(duration: Int): List<Movie> {
        return movies.filter { it.duration > duration }
    }
}

fun main(args: Array<String>) {

    val genres = listOf(Genres.ACTION)
    val actorList = listOf("actor1", "actor2")
    val actressList = listOf("actress1", "actress2")
    val director = "director"
    val releaseDate = LocalDate.now()
    val movie1 = Movie("1", "first",releaseDate, genres, director , actorList, actressList, 30 )
    val movie2 = Movie("2", "second",releaseDate, genres, director , actorList, actressList, 40 )
    val movie3 = Movie("3", "third",releaseDate, genres, director , actorList, actressList, 30 )
    val movie4 = Movie("4", "fourth",releaseDate, genres, director , actorList, actressList, 30 )

    val store =  MovieStore(listOf(movie1, movie2, movie3, movie4))

    print(store.getMoviesFromGivenReleaseYear(2018))
    print(store.getMoviesMoreThanGivenDuration(40))
    print(store.getMovieAvailableForAnActor("actor1"))
    print(store.getMovieAvailableForAnActress("actress1"))
}

//case classes from scala
//Sealed Classes
//Decorator patter
//  by map
//Rational
//dsl
//arrow
//co-routine
//