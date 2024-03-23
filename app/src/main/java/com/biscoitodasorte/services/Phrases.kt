package com.biscoitodasorte.services

import com.biscoitodasorte.dto.Phrase
import java.util.Random
/*
Claro, aqui está a lista de frases motivacionais e de esperança para biscoitos da sorte, agora com os autores separadamente:

```json
{
  "frases": [

    {
      "id": 14,
      "frase": "Acredite em si mesmo e em tudo que você é. Saiba que há algo dentro de você que é maior do que qualquer obstáculo.",
      "autor": "Christian D. Larson"
    },
    {
      "id": 15,
      "frase": "Lembre-se: seu único limite é você mesmo.",
      "autor": "Autor desconhecido"
    },
    {
      "id": 16,
      "frase": "Não deixe o que você não pode fazer atrapalhar o que você pode fazer.",
      "autor": "John Wooden"
    },
    {
      "id": 17,
      "frase": "Nunca é tarde demais para ser quem você poderia ter sido.",
      "autor": "George Eliot"
    },
    {
      "id": 18,
      "frase": "A vida é 10% do que acontece com você e 90% como você reage a isso.",
      "autor": "Charles R. Swindoll"
    },
    {
      "id": 19,
      "frase": "Você não falha até desistir de tentar.",
      "autor": "Autor desconhecido"
    },
    {
      "id": 20,
      "frase": "Lembre-se: o que quer que você possa fazer ou sonhe que pode, comece. A coragem contém genialidade, poder e magia.",
      "autor": "Johann Wolfgang von Goethe"
    },
    {
      "id": 21,
      "frase": "O sucesso não é definitivo, o fracasso não é fatal: é a coragem de continuar que conta.",
      "autor": "Winston Churchill"
    },
    {
      "id": 22,
      "frase": "A jornada de mil milhas começa com um único passo.",
      "autor": "Lao Tsé"
    },
    {
      "id": 23,
      "frase": "Acredite em si mesmo e em suas habilidades. Com trabalho árduo e dedicação, tudo é possível.",
      "autor": "Autor desconhecido"
    },
    {
      "id": 24,
      "frase": "Às vezes, quando pensamos que estamos lutando contra uma força externa, na verdade estamos lutando contra nós mesmos.",
      "autor": "Autor desconhecido"
    },
    {
      "id": 25,
      "frase": "Nada é impossível. A palavra em si diz 'eu sou possível'.",
      "autor": "Audrey Hepburn"
    },
    {
      "id": 26,
      "frase": "Quando você sentir vontade de desistir, lembre-se por que começou.",
      "autor": "Autor desconhecido"
    },
    {
      "id": 27,
      "frase": "O sucesso é a soma de pequenos esforços repetidos dia após dia.",
      "autor": "Robert Collier"
    },
    {
      "id": 28,
      "frase": "As montanhas mais altas da vida são escaladas um passo de cada vez.",
      "autor": "Autor desconhecido"
    },
    {
      "id": 29,
      "frase": "Não deixe o medo de perder ser maior que a excitação de ganhar.",
      "autor": "Robert Kiyosaki"
    },
    {
      "id": 30,
      "frase": "Quanto maior o obstáculo, maior a glória em superá-lo.",
      "autor": "Molière"
    },
    {
      "id": 31,
      "frase": "Se você quer voar, precisa primeiro se libertar das coisas que o prendem.",
      "autor": "Autor desconhecido"
    },
    {
      "id": 32,
      "frase": "Acredite que você pode e você está no meio do caminho.",
      "autor": "Theodore Roosevelt"
    },
    {
      "id": 33,
      "frase": "Sua jornada começa com um passo. Dê esse passo com confiança.",
      "autor": "Autor       "desconhecido"
    },
    {
      "id": 34,
      "frase": "Grandes coisas nunca vêm de zonas de conforto.",
      "autor": "Autor desconhecido"
    },
    {
      "id": 35,
      "frase": "Você é mais forte do que pensa. Mais capaz do que imagina.",
      "autor": "Autor desconhecido"
    },
    {
      "id": 36,
      "frase": "Não espere por circunstâncias ideais. Tome decisões e faça o que puder com o que tiver.",
      "autor": "Arthur Ashe"
    }
  ]
}


*/

class Phrases {
        private val phrasesList = listOf<Phrase>(
            Phrase( 1, "Acredite em si mesmo. Você é mais forte do que pensa.", "Autor desconhecido"),
            Phrase( 2, "Todo dia é uma nova oportunidade para mudar sua vida.", "Autor desconhecido"),
            Phrase( 3, "O segredo para se dar bem na vida é começar a acreditar que você pode.", "Autor desconhecido"),
            Phrase( 4, "Você é capaz de coisas incríveis. Acredite em si mesmo.", "Autor desconhecido"),
            Phrase( 5, "Lembre-se: você é mais forte do que imagina.", "Autor desconhecido"),
            Phrase( 6, "O futuro pertence àqueles que acreditam na beleza de seus sonhos.", "Eleanor Roosevelt"),
            Phrase( 7, "Nunca é tarde demais para ser o que você poderia ter sido.", "George Eliot"),
            Phrase( 8, "Cada pequeno passo nos leva mais perto de nossos sonhos.", "Autor desconhecido"),
            Phrase( 9, "A vida é cheia de possibilidades esperando para serem descobertas.", "Autor desconhecido"),
            Phrase( 10, "Não importa quão devagar você vá, desde que você não pare.", "Confúcio"),
            Phrase( 11, "Seja corajoso o suficiente para seguir seu coração e sua intuição.", "Steve Jobs"),
            Phrase( 12, "O sucesso é a soma de pequenos esforços repetidos dia após dia.", "Robert Collier"),
        )

    fun getRandomPhrase():Phrase{
        val random = Random()
        val randomIndex = random.nextInt(this.phrasesList.size)
        val randomPhrase = phrasesList[randomIndex]

        return randomPhrase;
    }
}