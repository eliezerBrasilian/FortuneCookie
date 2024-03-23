package com.biscoitodasorte

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import com.biscoitodasorte.dto.Phrase
import com.biscoitodasorte.services.Phrases
import com.biscoitodasorte.ui.theme.BiscoitoDaSorteTheme
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Regular
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.regular.Copy
import compose.icons.fontawesomeicons.solid.ShareAltSquare

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BiscoitoDaSorteTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    val modifier: Modifier = Modifier
    val phrases = Phrases()

    val fortuneCookieIsBroken = remember {
        mutableStateOf(true);
    }

    val fortuneCookieImageClose = remember {
        mutableStateOf(R.drawable.biscoito_fechado)
    }

    val fortuneCookieImageOpen = remember {
        mutableStateOf(R.drawable.biscoito_aberto)
    }

    val selectedPhrase = remember {
        mutableStateOf(phrases.getRandomPhrase())
    }

    val handleChangePhrase:()->Unit = {
        selectedPhrase.value = phrases.getRandomPhrase()
    }

    val brokeFortuneCookie: ()->Unit = {
        if (!fortuneCookieIsBroken.value)
            fortuneCookieIsBroken.value = true;

        handleChangePhrase();
    }

    val resetFortuneCookie: ()->Unit = {
        if (fortuneCookieIsBroken.value)
            fortuneCookieIsBroken.value = false;

    }


    Column(modifier = modifier
        .fillMaxSize()
        .padding(horizontal = 20.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

        Image(painter = painterResource(id = if (fortuneCookieIsBroken.value) fortuneCookieImageOpen.value else fortuneCookieImageClose.value),
            contentDescription = "fortune cookie",
            modifier = modifier
                .height(160.dp)
                .width(160.dp))

        if (fortuneCookieIsBroken.value){
            Spacer(modifier = modifier.height(20.dp))
            PhraseContainer(modifier = modifier, selectedPhrase = selectedPhrase.value)
        }

        Spacer(modifier = modifier.height(100.dp))
        Button(onClick = brokeFortuneCookie ) {
            Text(text = "Quebrar Biscoito")
        }
        Spacer(modifier = modifier.height(20.dp))

        if (fortuneCookieIsBroken.value)
        Button(onClick = resetFortuneCookie, colors = ButtonDefaults.buttonColors(Color(0xFFE9726A))) {
            Text(text = "Fechar Biscoito")
        }
    }
}
@Composable
fun PhraseContainer(modifier: Modifier, selectedPhrase: Phrase){
    val clipboardManager = LocalClipboardManager.current
    val localContext = LocalContext.current

    val copyPhrase:()->Unit = {
        clipboardManager.setText(AnnotatedString(selectedPhrase.content))
        Toast.makeText(localContext,"Frase copiada :)",Toast.LENGTH_SHORT).show();
    }

    val sharePhrase: ()->Unit = {
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
                        .width(40.dp).clickable(onClick = copyPhrase))

                Icon(imageVector =  FontAwesomeIcons.Solid.ShareAltSquare,
                    contentDescription = "fortune cookie",
                    modifier = modifier
                        .height(40.dp)
                        .width(40.dp).clickable(onClick = sharePhrase))
            }
        }

}