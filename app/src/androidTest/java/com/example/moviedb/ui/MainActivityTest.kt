package com.example.moviedb.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.moviedb.R
import com.example.moviedb.core.utils.DataDummy
import com.example.moviedb.core.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    private val dummyMovies = DataDummy.generateDummyMovie()
    private val dummyTVShows = DataDummy.generateDummyTVShows()

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rvMovies)).check(matches(isDisplayed()))
        onView(withId(R.id.rvMovies)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovies.size
            )
        )
    }

    @Test
    fun loadDetailMovies() {

        onView(withId(R.id.rvMovies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tvTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDescription)).check(matches(isDisplayed()))
        onView(withId(R.id.tvGenre)).check(matches(isDisplayed()))
        onView(withId(R.id.tvRating)).check(matches(isDisplayed()))
        onView(withId(R.id.tvReleaseDate)).check(matches(isDisplayed()))

        onView(withId(R.id.kenburnsBackground)).check(matches(isDisplayed()))


    }

    @Test
    fun TestAddAndDeleteFavoriteFilm() {
        onView(withId(R.id.rvMovies)).check((matches(isDisplayed())))
        onView(withId(R.id.rvMovies)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                5
            )
        )
        onView(withId(R.id.rvMovies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                5,
                click()
            )
        )

        onView(withId(R.id.action_addFavorite)).perform(click())

        Espresso.pressBack()

        onView(withId(R.id.favoriteFragment)).perform(click())
        onView(withText(R.string.favorite_movie)).perform(click())

        onView(withId(R.id.rvMoviesFavorite)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0, click()
            )
        )

        onView(withId(R.id.action_addFavorite)).perform(click())
        Espresso.pressBack()
        Espresso.pressBack()
    }

    @Test
    fun loadTv() {
        onView(withId(R.id.tvShowsFragment)).perform(click())
        onView(withId(R.id.rvTVShows)).check(matches(isDisplayed()))
        onView(withId(R.id.rvTVShows)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTVShows.size
            )
        )
    }

    @Test
    fun loadDetailTv() {
        onView(withId(R.id.tvShowsFragment)).perform(click())
        onView(withId(R.id.rvTVShows)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tvTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDescription)).check(matches(isDisplayed()))
        onView(withId(R.id.tvGenre)).check(matches(isDisplayed()))
        onView(withId(R.id.tvRating)).check(matches(isDisplayed()))
        onView(withId(R.id.tvReleaseDate)).check(matches(isDisplayed()))

        onView(withId(R.id.kenburnsBackground)).check(matches(isDisplayed()))
    }

    @Test
    fun TestAddAndDeleteFavoriteTv() {
        onView(withId(R.id.tvShowsFragment)).perform(click())
        onView(withId(R.id.rvTVShows)).check((matches(isDisplayed())))
        onView(withId(R.id.rvTVShows)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                5
            )
        )
        onView(withId(R.id.rvTVShows)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                5,
                click()
            )
        )

        onView(withId(R.id.action_addFavorite)).perform(click())

        Espresso.pressBack()

        onView(withId(R.id.favoriteFragment)).perform(click())
        onView(withText(R.string.favorite_tv)).perform(click())

        onView(withId(R.id.rvTVShowsFavorite)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0, click()
            )
        )

        onView(withId(R.id.action_addFavorite)).perform(click())
        Espresso.pressBack()
        Espresso.pressBack()
    }


}