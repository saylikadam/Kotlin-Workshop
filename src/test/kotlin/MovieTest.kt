import io.kotlintest.*
import io.kotlintest.matchers.collections.shouldContainAll
import io.kotlintest.matchers.collections.shouldNotBeEmpty
import io.kotlintest.specs.FunSpec
import java.time.LocalDate

class MovieStoreTest: FunSpec() {
    val movie1 =  Movie("1","one", LocalDate.of(2015, 5, 23), listOf(Genres.ACTION), "director1", listOf("act1", "act2"), listOf("actr1", "actr2"),30)
    val movie2 =  Movie("2","two", LocalDate.of(2016, 5, 23), listOf(Genres.COMEDY), "director2", listOf("act11", "act22"), listOf("actr11", "actr22"),40)
    val movie3 =  Movie("3","three", LocalDate.of(2016, 5, 23), listOf(Genres.ACTION), "director3", listOf("act111", "act222"), listOf("actr111", "actr222"),50)
    val movie4 =  Movie("4","four", LocalDate.of(2017, 5, 23), listOf(Genres.DRAMA), "director2", listOf("act1111", "act2222"), listOf("actr1111", "actr2221"),60)

    var movieStore = MovieStore(listOf(movie1,movie2,movie3,movie4))

    init {
        test("should return movies available for the given actor") {
            val listOfMovies = movieStore.getMovieAvailableForAnActor("act1")
            listOfMovies.size shouldBe 1
            listOfMovies.get(0).title shouldBe "one"
        }

        test("should return movies available for the given actress") {
            val listOfMovies = movieStore.getMovieAvailableForAnActress("actr1")
            listOfMovies.size shouldBe 1
            listOfMovies.get(0).title shouldBe "one"
        }

        test("should return movies from given release date") {
            val moviesFromGivenReleaseYear = movieStore.getMoviesFromGivenReleaseYear(2016)
            moviesFromGivenReleaseYear.size shouldBe 2
            moviesFromGivenReleaseYear.get(0).equals(
                    Movie("2","two", LocalDate.of(2016, 5, 23), listOf(Genres.COMEDY), "director2", listOf("act11", "act22"), listOf("actr11", "actr22"),40)
            ) shouldBe true
        }

        test("should return movies which has duration more than 30 min") {
            val moviesMoreThanGivenDuration = movieStore.getMoviesMoreThanGivenDuration(30)
            moviesMoreThanGivenDuration.size shouldBe 3
        }

    }
}