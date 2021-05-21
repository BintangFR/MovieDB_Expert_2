package com.example.moviedb.core.utils

import com.example.moviedb.core.data.local.entity.DataEntity
import com.example.moviedb.core.data.remote.response.*

object DataDummy {

    fun generateDummyMovie(): List<DataEntity> {

        val movies = ArrayList<DataEntity>()

        movies.add(
            DataEntity(
                0,
                "Bohemian Rhapsody",
                "Music, Drama, History",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                80.0,
                "11/02/2018 (US)",
                "https://images.squarespace-cdn.com/content/59558e53be65943ed29f505b/1541263297805-PTO2V9NVF91FIO9PZ39I/BohemianRhapsodyPoster.jpg?content-type=image%2Fjpeg",
                false,
                "MOVIES"

            )
        )
        movies.add(
            DataEntity(
                1,
                "Mortal Engines",
                "Adventure, Science Fiction ",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                61.0,
                "12/14/2018 (US)",
                "https://movies.universalpictures.com/media/mte-char1sheet-hester-rgb-5sm-5bb29e8090d68-1.jpg",
                false,
                "MOVIES"
            )
        )
        movies.add(
            DataEntity(
                2,
                "T-34",
                "War, Action, Drama, History ",
                "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, unbreakable love, and legendary miracles.",
                69.0,
                "01/01/2019 (RU)",
                "https://www.wellgousa.com/sites/default/files/2019-05/812x1200.jpg",
                false,
                "MOVIES"
            )
        )
        movies.add(
            DataEntity(
                3,
                "Spider-Man",
                "Fantasy, Action ",
                "After being bitten by a genetically altered spider, nerdy high school student Peter Parker is endowed with amazing powers to become the Amazing superhero known as Spider-Man.",
                72.0,
                "05/22/2002 (ID)",
                "https://images-na.ssl-images-amazon.com/images/I/811CP3gzbPL.jpg", false, "MOVIES"
            )
        )
        movies.add(
            DataEntity(
                4,
                "Aquaman",
                "Action, Adventure, Fantasy ",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                69.0,
                "12/21/2018 (US)",
                "https://m.media-amazon.com/images/M/MV5BOTk5ODg0OTU5M15BMl5BanBnXkFtZTgwMDQ3MDY3NjM@._V1_.jpg",
                false,
                "MOVIES"
            )
        )
        movies.add(
            DataEntity(
                5,
                "Avengers: Infinity War",
                "Adventure, Action, Science Fiction ",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                83.0,
                "04/27/2018 (US)",
                "https://m.media-amazon.com/images/M/MV5BMjMxNjY2MDU1OV5BMl5BanBnXkFtZTgwNzY1MTUwNTM@._V1_UY1200_CR90,0,630,1200_AL_.jpg",
                false,
                "MOVIES"
            )
        )
        movies.add(
            DataEntity(
                6,
                "Alita: Battle Angel",
                "Action, Science Fiction, Adventure",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                72.0,
                "02/14/2019 (US)",
                "https://i.pinimg.com/564x/9f/c0/e2/9fc0e28c24b9bcb1f33dc14ebe40c6d5.jpg",
                false,
                "MOVIES"
            )
        )
        movies.add(
            DataEntity(
                7,
                "Wreck-It Ralph",
                "Family, Animation, Comedy, Adventure",
                "Wreck-It Ralph is the 9-foot-tall, 643-pound villain of an arcade video game named Fix-It Felix Jr., in which the game's titular hero fixes buildings that Ralph destroys. Wanting to prove he can be a good guy and not just a villain, Ralph escapes his game and lands in Hero's Duty, a first-person shooter where he helps the game's hero battle against alien invaders. He later enters Sugar Rush, a kart racing game set on tracks made of candies, cookies and other sweets. There, Ralph meets Vanellope von Schweetz who has learned that her game is faced with a dire threat that could affect the entire arcade, and one that Ralph may have inadvertently started.",
                73.0,
                "11/02/2012 (US)",
                "https://static.wikia.nocookie.net/disney/images/8/89/Wreck_It_Ralph_Poster.jpeg/revision/latest?cb=20181231152041",
                false,
                "MOVIES"
            )
        )
        movies.add(
            DataEntity(
                8,
                "How to Train Your Dragon",
                "Fantasy, Adventure, Animation, Family",
                "As the son of a Viking leader on the cusp of manhood, shy Hiccup Horrendous Haddock III faces a rite of passage: he must kill a dragon to prove his warrior mettle. But after downing a feared dragon, he realizes that he no longer wants to destroy it, and instead befriends the beast – which he names Toothless – much to the chagrin of his warrior father",
                78.0,
                "03/26/2010 (US)",
                "https://m.media-amazon.com/images/M/MV5BMjA5NDQyMjc2NF5BMl5BanBnXkFtZTcwMjg5ODcyMw@@._V1_.jpg",
                false,
                "MOVIES"
            )
        )
        movies.add(
            DataEntity(
                9,
                "Overlord",
                "Horror, War, Science Fiction",
                "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
                67.0,
                "11/09/2018 (US)",
                "https://images-na.ssl-images-amazon.com/images/I/81SVICJb2jL._AC_SL1500_.jpg",
                false,
                "MOVIES"
            )
        )

        return movies
    }

    fun generateDummyTVShows(): List<DataEntity> {

        val tvShows = ArrayList<DataEntity>()
        tvShows.add(
            DataEntity(
                0,
                "Arrow",
                "Crime, Drama, Mystery, Action & Adventure",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                66.0,
                "October 10, 2012",
                "https://i.pinimg.com/originals/2a/4c/2f/2a4c2f06d714ce020566be924b03d55a.jpg",
                false,
                "TVSHOWS"
            )
        )
        tvShows.add(
            DataEntity(
                1,
                "Gotham",
                "Drama, Crime, Sci-Fi & Fantasy",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                75.0,
                "September 22, 2014",
                "https://i.pinimg.com/originals/68/63/50/68635073ac000d3e81c32fbb1a1774e3.jpg",
                false,
                "TVSHOWS"
            )
        )
        tvShows.add(
            DataEntity(
                2,
                "Naruto Shippūden",
                "Animation, Action & Adventure, Sci-Fi & Fantasy",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                86.0,
                "February 15, 2007",
                "https://i5.walmartimages.com/asr/f37a5913-a246-4a6f-892f-e909e72fc997_1.f381ee4d2727d156f88143272099da96.jpeg",
                false,
                "TVSHOWS"
            )
        )
        tvShows.add(
            DataEntity(
                3,
                "Family Guy",
                "Animation, Comedy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                70.0,
                "January 31, 1999",
                "https://images-na.ssl-images-amazon.com/images/I/81qr6-4oG2L._AC_SL1500_.jpg",
                false,
                "TVSHOWS"
            )
        )
        tvShows.add(
            DataEntity(
                4,
                "Dragon Ball Z",
                "Animation, Sci-Fi & Fantasy, Action & Adventure",
                "Five years have passed since the fight with Piccolo Jr., and Goku now has a son, Gohan. The peace is interrupted when an alien named Raditz arrives on Earth in a spacecraft and tracks down Goku, revealing to him that that they are members of a near-extinct warrior race called the Saiyans.",
                82.0,
                "April 26, 1989",
                "https://cdn.europosters.eu/image/750/posters/dragon-ball-z-goku-i28205.jpg",
                false,
                "TVSHOWS"
            )
        )
        tvShows.add(
            DataEntity(
                5,
                "The Simpsons",
                "Family, Animation, Comedy",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                78.0,
                "December 17, 1989",
                "https://images-na.ssl-images-amazon.com/images/I/71mtHOsKNlL._AC_SL1115_.jpg",
                false,
                "TVSHOWS"
            )
        )
        tvShows.add(
            DataEntity(
                6,
                "The Walking Dead",
                "Action & Adventure, Drama, Sci-Fi & Fantasy",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                81.0,
                "October 31, 2010",
                "https://cdn.europosters.eu/image/750/posters/the-walking-dead-city-i15032.jpg",
                false,
                "TVSHOWS"
            )
        )
        tvShows.add(
            DataEntity(
                7,
                "NCIS",
                "Crime, Action & Adventure, Drama",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                74.0,
                "September 23, 2003",
                "https://images-na.ssl-images-amazon.com/images/I/71w%2B0a80ymL._AC_SX522_.jpg",
                false,
                "TVSHOWS"
            )
        )
        tvShows.add(
            DataEntity(
                8,
                "The Umbrella Academy",
                "Action & Adventure, Sci-Fi & Fantasy, Drama",
                "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
                87.0,
                "February 15, 2019",
                "https://cdn.europosters.eu/image/750/posters/the-umbrella-academy-super-dysfunctional-family-i74254.jpg",
                false,
                "TVSHOWS"
            )
        )
        tvShows.add(
            DataEntity(
                9,
                "Fairy Tail",
                "Action & Adventure, Animation, Comedy, Sci-Fi & Fantasy",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                78.0,
                "October 12, 2009",
                "https://cdn.europosters.eu/image/750/posters/fairy-tail-season-6-key-art-i49242.jpg",
                false,
                "TVSHOWS"
            )
        )

        return tvShows
    }


    fun generateDummyMoviesList(): List<MovieList> {

        val movies = ArrayList<MovieList>()

        movies.add(
            MovieList(
                0,
                "Bohemian Rhapsody",
                80.0,
                "2018",
                "https://images.squarespace-cdn.com/content/59558e53be65943ed29f505b/1541263297805-PTO2V9NVF91FIO9PZ39I/BohemianRhapsodyPoster.jpg?content-type=image%2Fjpeg"

            )
        )
        movies.add(
            MovieList(
                1,
                "Mortal Engines",
                61.0,
                "2018",
                "https://movies.universalpictures.com/media/mte-char1sheet-hester-rgb-5sm-5bb29e8090d68-1.jpg"
            )
        )
        movies.add(
            MovieList(
                2,
                "T-34",
                69.0,
                "2019",
                "https://www.wellgousa.com/sites/default/files/2019-05/812x1200.jpg"
            )
        )
        movies.add(
            MovieList(
                3,
                "Spider-Man",
                72.0,
                "2002",
                "https://images-na.ssl-images-amazon.com/images/I/811CP3gzbPL.jpg"
            )
        )
        movies.add(
            MovieList(
                4,
                "Aquaman",
                69.0,
                "2018",
                "https://m.media-amazon.com/images/M/MV5BOTk5ODg0OTU5M15BMl5BanBnXkFtZTgwMDQ3MDY3NjM@._V1_.jpg"
            )
        )
        movies.add(
            MovieList(
                5,
                "Avengers: Infinity War",
                83.0,
                "2018",
                "https://m.media-amazon.com/images/M/MV5BMjMxNjY2MDU1OV5BMl5BanBnXkFtZTgwNzY1MTUwNTM@._V1_UY1200_CR90,0,630,1200_AL_.jpg"
            )
        )
        movies.add(
            MovieList(
                6,
                "Alita: Battle Angel",
                72.0,
                "2019",
                "https://i.pinimg.com/564x/9f/c0/e2/9fc0e28c24b9bcb1f33dc14ebe40c6d5.jpg"
            )
        )
        movies.add(
            MovieList(
                7,
                "Wreck-It Ralph",
                73.0,
                "2012",
                "https://static.wikia.nocookie.net/disney/images/8/89/Wreck_It_Ralph_Poster.jpeg/revision/latest?cb=20181231152041",

                )
        )
        movies.add(
            MovieList(
                8,
                "How to Train Your Dragon",
                78.0,
                "2010",
                "https://m.media-amazon.com/images/M/MV5BMjA5NDQyMjc2NF5BMl5BanBnXkFtZTcwMjg5ODcyMw@@._V1_.jpg"
            )
        )
        movies.add(
            MovieList(
                9,
                "Overlord",
                67.0,
                "2018",
                "https://images-na.ssl-images-amazon.com/images/I/81SVICJb2jL._AC_SL1500_.jpg"
            )
        )

        return movies
    }

    fun generateDummyTVShowsList(): List<TVShowsList> {

        val tvShows = ArrayList<TVShowsList>()
        tvShows.add(
            TVShowsList(
                0,
                "Arrow",
                66.0,
                "2012",
                "https://i.pinimg.com/originals/2a/4c/2f/2a4c2f06d714ce020566be924b03d55a.jpg"
            )
        )
        tvShows.add(
            TVShowsList(
                1,
                "Gotham",
                75.0,
                "2014",
                "https://i.pinimg.com/originals/68/63/50/68635073ac000d3e81c32fbb1a1774e3.jpg"
            )
        )
        tvShows.add(
            TVShowsList(
                2,
                "Naruto Shippūden",
                86.0,
                "2007",
                "https://i5.walmartimages.com/asr/f37a5913-a246-4a6f-892f-e909e72fc997_1.f381ee4d2727d156f88143272099da96.jpeg"
            )
        )
        tvShows.add(
            TVShowsList(
                3,
                "Family Guy",
                70.0,
                "1999",
                "https://images-na.ssl-images-amazon.com/images/I/81qr6-4oG2L._AC_SL1500_.jpg"
            )
        )
        tvShows.add(
            TVShowsList(
                4,
                "Dragon Ball Z",
                82.0,
                "1989",
                "https://cdn.europosters.eu/image/750/posters/dragon-ball-z-goku-i28205.jpg"
            )
        )
        tvShows.add(
            TVShowsList(
                5,
                "The Simpsons",
                78.0,
                "1989",
                "https://images-na.ssl-images-amazon.com/images/I/71mtHOsKNlL._AC_SL1115_.jpg"
            )
        )
        tvShows.add(
            TVShowsList(
                6,
                "The Walking Dead",
                81.0,
                "2010",
                "https://cdn.europosters.eu/image/750/posters/the-walking-dead-city-i15032.jpg"
            )
        )
        tvShows.add(
            TVShowsList(
                7,
                "NCIS",
                74.0,
                "2003",
                "https://images-na.ssl-images-amazon.com/images/I/71w%2B0a80ymL._AC_SX522_.jpg"
            )
        )
        tvShows.add(
            TVShowsList(
                8,
                "The Umbrella Academy",
                87.0,
                "2019",
                "https://cdn.europosters.eu/image/750/posters/the-umbrella-academy-super-dysfunctional-family-i74254.jpg"
            )
        )
        tvShows.add(
            TVShowsList(
                9,
                "Fairy Tail",
                78.0,
                "2009",
                "https://cdn.europosters.eu/image/750/posters/fairy-tail-season-6-key-art-i49242.jpg"
            )
        )

        return tvShows
    }

    fun getFakeDummyMovieDetail(): MovieDetail {
        val genre = ArrayList<Genre>()
        genre.add(
            Genre(
                1,
                "Horror"
            )
        )
        genre.add(
            Genre(
                2,
                "War"
            )
        )
        genre.add(
            Genre(
                3,
                "Science Fiction"
            )
        )
        return MovieDetail(
            9,
            "Overlord",
            67.0,
            "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
            "11/09/2018 (US)",
            "https://images-na.ssl-images-amazon.com/images/I/81SVICJb2jL._AC_SL1500_.jpg",
            genre
        )
    }

    fun getFakeDummyTvshowDetail(): TVShowsDetail {
        val genre = ArrayList<Genre>()

        genre.add(
            Genre(
                4,
                "Action & Adventure"
            )
        )
        genre.add(
            Genre(
                5,
                "Animation"
            )
        )
        genre.add(
            Genre(
                6,
                "Comedy"
            )
        )
        genre.add(
            Genre(
                7,
                "Sci-Fi & Fantasy"
            )
        )

        return TVShowsDetail(
            9,
            "Fairy Tail",
            78.0,
            "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
            "October 12, 2009",
            "https://cdn.europosters.eu/image/750/posters/fairy-tail-season-6-key-art-i49242.jpg",
            genre
        )
    }

}

