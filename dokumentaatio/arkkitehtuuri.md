# Arkkitehtuurikuvaus

## Rakenne

Ohjelma on toteutetty yhdessä paketissa _blacckjack_ johon sisältyy kolme sovellusolgiikkaan liittyvää luokkaa _Cards_, _Deck_ ja _Hand_ sekä käyttöliittymäluokka _Blackjack_.

## Käyttöliittymä

Käyttyliittymään liitty yksi päänäkymä. Tämä kostoo pää-"Panesta" _root_ jonka sisään on lisätty kaksi vierekkäistä StackPanea _playmat_ ja _betmat_. Vasemmalla StackPanella eli _playmat_:illa näkyvät pelaajan sekä jakajan kortit ja vasemmalla StackPanella eli _betmat_:illa taas löytyvät kaikki pelin toiminnot johon pääsee käsiksi nappien avulla.

## Tiedon pysyväistallennus

## Päätoiminnallisuudet

## Ohjelman rakenteeseen jääneet heikkoudet

### Käyttöliittymä

Käyttöliittymäluokka on toteutettu samaan pakettiin kun sovellusloogiikkaan liittyväät luokat. Tämän lisäksi käyttöliittymä ei ole toteutettu aivan erilliseksi sovelluslogiikasta sillä joitakin sovelluslogiikkaan liittyviä rakenteita löytyy käyttöliittymäluokasta.

### Testiluokat

Testiluokissa on jäänyt vähän ylimääräisiä metodeja mitä luodaan automaattisesti mutta ei käytetä.

