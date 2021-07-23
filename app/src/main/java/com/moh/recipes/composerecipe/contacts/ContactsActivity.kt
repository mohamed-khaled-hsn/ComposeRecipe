package com.moh.recipes.composerecipe.contacts

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowUpward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moh.recipes.composerecipe.theme.SampleTheme
import kotlinx.coroutines.launch

class ContactsActivity : AppCompatActivity() {

    val grouped = FakeContactsList.groupBy { it.firstName[0] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SamplePreview()
        }
    }


    @OptIn(ExperimentalFoundationApi::class, ExperimentalAnimationApi::class)
    @Composable
    fun ContactsList(grouped: Map<Char, List<Contact>>) {
        Box {
            val listState = rememberLazyListState()
            // Remember a CoroutineScope to be able to launch
            val coroutineScope = rememberCoroutineScope()

            LazyColumn(
                state = listState,
                modifier = Modifier
                    .background(MaterialTheme.colors.background)
                    .testTag(TAG_CONTACTS_LIST)
            ) {
                grouped.forEach { (initial, contactsForInitial) ->
                    stickyHeader {
                        CharacterHeader(
                            initial,
                            Modifier
                                .fillParentMaxWidth()
                                .background(MaterialTheme.colors.primary)
                        )
                    }
                    items(contactsForInitial) { contact ->
                        ContactListItem(contact)
                    }
                }
            }
            // We use a remembered derived state to
            // minimize unnecessary compositions
            val showButton by remember {
                derivedStateOf {
                    listState.firstVisibleItemIndex > 0
                }
            }

            AnimatedVisibility(
                visible = showButton,
                Modifier.align(Alignment.BottomEnd)
            ) {
                ScrollToTopButton(modifier = Modifier.padding(16.dp)) {
                    coroutineScope.launch {
                        // Animate scroll to the first item
                        listState.animateScrollToItem(index = 0)
                    }
                }
            }
        }
    }

    @Composable
    fun ScrollToTopButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
        Button(onClick = onClick, modifier.testTag(TAG_SCROLL_TOP)) {
            Icon(Icons.Outlined.ArrowUpward, null)
        }
    }

    @Composable
    fun CharacterHeader(initial: Char, modifier: Modifier = Modifier) {
        Text(
            text = "$initial",
            modifier = modifier.padding(start = 16.dp),
            color = MaterialTheme.colors.onPrimary
        )
    }

    @Composable
    fun ContactListItem(contact: Contact, modifier: Modifier = Modifier) {
        Column(modifier = modifier.padding(16.dp)) {
            Text(text = "${contact.firstName} ${contact.lastName}")
            Text(text = contact.phoneNumber)
        }
    }

    @Preview("default")
    @Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
    @Preview("large font", fontScale = 1.5f)
    @Composable
    fun SamplePreview() {
        SampleTheme {
            Surface {
                Scaffold(
                    topBar = {
                        TopAppBar {
                            Text(
                                "Contacts List",
                                Modifier.padding(8.dp),
                                style = MaterialTheme.typography.h5
                            )
                        }
                    },
                    content = { ContactsList(grouped) }
                )

            }
        }
    }

    companion object {
        const val TAG_SCROLL_TOP = "tag_scroll_top"
        const val TAG_CONTACTS_LIST = "tag_contacts_list"
        fun newIntent(context: Context): Intent {
            return Intent(context, ContactsActivity::class.java)
        }
    }
}

