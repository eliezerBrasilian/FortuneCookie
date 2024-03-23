package com.biscoitodasorte.components

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import com.biscoitodasorte.dto.Phrase
import com.biscoitodasorte.services.showInterstitial
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Regular
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.regular.Copy
import compose.icons.fontawesomeicons.solid.ShareAltSquare

@Composable
fun PhraseContainer(modifier: Modifier, selectedPhrase: Phrase){
    val clipboardManager = LocalClipboardManager.current
    val localContext = LocalContext.current

    val copyPhrase:()->Unit = {
        clipboardManager.setText(AnnotatedString(selectedPhrase.content))
        Toast.makeText(localContext,"Frase copiada :)", Toast.LENGTH_SHORT).show();
        showInterstitial(localContext);
    }

    val sharePhrase: ()->Unit = {
        showInterstitial(localContext);
        val customSharePhraseContent = "${selectedPhrase.content}\n\nBiscoito da Sorte: https://play.google.com/store/apps/details?id=com.biscoitodasorte"
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, customSharePhraseContent)
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        localContext.startActivity(shareIntent)
    }

    Column(modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)){
        Box(modifier = modifier
            .fillMaxWidth()
            .background(color = Color(0xFFDBCEA0))
            .padding(20.dp)
            .heightIn(min = 50.dp)){
            Column {
                Text(text =  "\"${selectedPhrase.content}\"", color = Color.Black)
                Box(modifier = modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                    Text(text =  selectedPhrase.author,color = Color.Black)
                }
            }
        }

        Row(horizontalArrangement = Arrangement.spacedBy(40.dp)) {
            Icon(imageVector =  FontAwesomeIcons.Regular.Copy,
                contentDescription = "fortune cookie",
                modifier = modifier
                    .height(40.dp)
                    .width(40.dp)
                    .clickable(onClick = copyPhrase))

            Icon(imageVector =  FontAwesomeIcons.Solid.ShareAltSquare,
                contentDescription = "fortune cookie",
                modifier = modifier
                    .height(40.dp)
                    .width(40.dp)
                    .clickable(onClick = sharePhrase))
        }
    }
}