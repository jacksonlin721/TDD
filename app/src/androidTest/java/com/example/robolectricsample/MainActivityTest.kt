package com.example.robolectricsample


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.tddtest1.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        waitUI(1000)

        val appCompatEditText = onView(
            allOf(withId(R.id.loginId),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0),
                    0),
                isDisplayed()))
        appCompatEditText.perform(replaceText("yyyyyy"), closeSoftKeyboard())

        val appCompatEditText2 = onView(
            allOf(withId(R.id.password),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0),
                    1),
                isDisplayed()))
        appCompatEditText2.perform(replaceText("yttttttt"), closeSoftKeyboard())

        val materialButton = onView(
            allOf(withId(R.id.send), withText("註冊"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0),
                    2),
                isDisplayed()))
        materialButton.perform(click())

        waitUI(1000)

        val textView = onView(
            allOf(withId(android.R.id.message), withText("密碼至少要8碼，第1碼為英文，並包含1碼數字"),
                withParent(withParent(withId(R.id.scrollView))),
                isDisplayed()))
        textView.check(matches(withText("密碼至少要8碼，第1碼為英文，並包含1碼數字")))

        waitUI(1000)

        Espresso.pressBack()

        val appCompatEditText3 = onView(
            allOf(withId(R.id.loginId), withText("yyyyyy"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0),
                    0),
                isDisplayed()))
        appCompatEditText3.perform(replaceText("yyyyy"))

        val appCompatEditText4 = onView(
            allOf(withId(R.id.loginId), withText("yyyyy"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0),
                    0),
                isDisplayed()))
        appCompatEditText4.perform(closeSoftKeyboard())

        val materialButton2 = onView(
            allOf(withId(R.id.send), withText("註冊"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0),
                    2),
                isDisplayed()))
        materialButton2.perform(click())

        waitUI(1000)

        val textView3 = onView(
            allOf(withId(android.R.id.message), withText("帳號至少要6碼，第1碼為英文"),
                withParent(withParent(withId(R.id.scrollView))),
                isDisplayed()))
        textView3.check(matches(withText("帳號至少要6碼，第1碼為英文")))

        waitUI(1000)

        Espresso.pressBack()

        val appCompatEditText5 = onView(
            allOf(withId(R.id.loginId), withText("yyyyy"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0),
                    0),
                isDisplayed()))
        appCompatEditText5.perform(replaceText("yyyyyy"))

        val appCompatEditText6 = onView(
            allOf(withId(R.id.loginId), withText("yyyyyy"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0),
                    0),
                isDisplayed()))
        appCompatEditText6.perform(closeSoftKeyboard())

        val appCompatEditText7 = onView(
            allOf(withId(R.id.password), withText("yttttttt"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0),
                    1),
                isDisplayed()))
        appCompatEditText7.perform(replaceText("yttttttt2"))

        val appCompatEditText8 = onView(
            allOf(withId(R.id.password), withText("yttttttt2"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0),
                    1),
                isDisplayed()))
        appCompatEditText8.perform(closeSoftKeyboard())

        val materialButton3 = onView(
            allOf(withId(R.id.send), withText("註冊"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0),
                    2),
                isDisplayed()))
        materialButton3.perform(click())

        waitUI(1000)

        val textView5 = onView(
            allOf(withText("TDDTest1"),
                withParent(allOf(withId(R.id.action_bar),
                    withParent(withId(R.id.action_bar_container)))),
                isDisplayed()))
        textView5.check(matches(withText("TDDTest1")))
    }

    private fun waitUI(time: Long) {
        Thread.sleep(time)
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
