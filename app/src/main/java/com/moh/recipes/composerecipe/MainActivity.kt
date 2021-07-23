package com.moh.recipes.composerecipe

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moh.recipes.composerecipe.contacts.ContactsActivity
import com.moh.recipes.composerecipe.theme.SampleTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SamplePreview()
        }
    }

    @Composable
    fun ScreenContent() {
        Surface {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Header",
                    style = MaterialTheme.typography.h1
                )
                Text(
                    text = "Header2",
                    style = MaterialTheme.typography.h2
                )
                Text(
                    text = "body",
                    style = MaterialTheme.typography.body1
                )
                Text(
                    color = MaterialTheme.colors.error,
                    text = "error"
                )
                Row(Modifier.fillMaxHeight(), verticalAlignment = Alignment.CenterVertically) {
                    Button(onClick = {
                        startActivity(ContactsActivity.newIntent(this@MainActivity))
                    }, Modifier.padding(16.dp)) {
                        Text(text = "Contacts list")
                    }
                    Button(onClick = {
                        startActivity(MixedActivity.newIntent(this@MainActivity))
                    }, Modifier.padding(16.dp)) {
                        Text(text = "Mixed")
                    }

                }
            }
        }

    }

    @Preview("default")
    @Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
    @Preview("large font", fontScale = 1.5f)
    @Composable
    fun SamplePreview() {
        SampleTheme {
            ScreenContent()
        }
    }
}
