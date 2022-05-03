package com.example.robolectricsample

import android.widget.Button
import android.widget.TextView
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.*
import org.robolectric.shadows.ShadowAlertDialog

@RunWith(RobolectricTestRunner::class)
class MainActivityRoboTest {
    private lateinit var activitiy: MainActivity

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        activitiy = Robolectric.buildActivity(MainActivity::class.java).setup().get()
    }

    @Test
    fun test_registerSuccess_RedirectToResultPage() {
        val shadowActivity = shadowOf(activitiy)

        val userId = "A123456789"
        val userPassword = "a123456789"

        activitiy.findViewById<TextView>(R.id.loginId).setText(userId)
        activitiy.findViewById<TextView>(R.id.password).setText(userPassword)

        activitiy.findViewById<Button>(R.id.send).performClick()

        val nextActivity = shadowActivity.nextStartedActivity
        assertEquals(
            nextActivity.component!!.className,
            ResultActivity::class.java.name
        )
        assertEquals(
            userId,
            nextActivity.extras!!.getString("ID")
        )
        System.out.print("[test_registerSuccess_RedirectToResultPage] page name? "+ nextActivity.component!!.className+
        ", user id= "+ nextActivity.extras!!.getString("ID"))
    }

    @Test
    fun test_registerFail_showError() {
        val userId = "A1234"
        val userPassword = "a123456789"

        activitiy.findViewById<TextView>(R.id.loginId).setText(userId)
        activitiy.findViewById<TextView>(R.id.password).setText(userPassword)

        activitiy.findViewById<Button>(R.id.send).performClick()

        val dialog = ShadowAlertDialog.getLatestDialog()
        assertNotNull(dialog)
        assertTrue(dialog.isShowing)
        System.out.print("[test_registerFail_showError] dialog show? "+dialog.isShowing)
    }
}