package com.moh.recipes.composerecipe.contacts

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.test.center
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performGesture
import androidx.compose.ui.test.swipe
import org.junit.Rule
import org.junit.Test

class ContactsActivityTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ContactsActivity>()

    private val findScrollTop
        get() = composeTestRule.onNodeWithTag(ContactsActivity.TAG_SCROLL_TOP)

    @Test
    fun scrollToTop_appearsWhenAfterSwipeDown() {
        findScrollTop.assertDoesNotExist()
        // Swipe down
        composeTestRule.onNodeWithTag(
            testTag = ContactsActivity.TAG_CONTACTS_LIST
        ).performGesture {
            this.swipe(
                start = this.center,
                end = Offset(this.center.x, this.center.y - 500),
                durationMillis = 200
            )
        }
        findScrollTop.performClick()
    }
}