# Arkkitehtuurikuvaus

## Rakenne

Ohjelma on toteutetty yhdessä paketissa _blacckjack_ johon sisältyy kolme sovellusolgiikkaan liittyvää luokkaa _Cards_, _Deck_ ja _Hand_ sekä käyttöliittymäluokka _Blackjack_.

## Käyttöliittymä

Käyttyliittymään liitty yksi päänäkymä. Tämä kostoo pää-"Panesta" _root_ jonka sisään on lisätty kaksi vierekkäistä StackPanea _playmat_ ja _betmat_. Vasemmalla StackPanella eli _playmat_:illa näkyvät pelaajan sekä jakajan kortit ja oikealla olevalla StackPanella eli _betmat_:illa taas löytyvät kaikki pelin toiminnot johon pääsee käsiksi nappien avulla.

## Sovelluslogiikka

Sovellukseen logiikkaan liittyy kaikki neljä sovelluksen luokkaa:

(img)

Luokka _Blackjack_ vastaa käyttöliittymästa ja osasta sovellusloogiikkaa. Siihen liittyvistä metodeista keskisimmät logiikan suhteen ovat 
- Parent createGame()
- void newGame()
- voidendGame()

Metodi _createGame()_ luo itse pelikenttänäkymän ja saa paluuarvokseen pää-"Panen" _root_. Kun painetaan nappia _PLAY_ kutsutaan metodia _newGame()_ joka asettaa uudellen kaikki käsiin ja muuhun peliin liittyvät muuttujat. Kun peli on päässyt siihen vaiheesen että jokin loppumiseen johtavista vaatimuksista toteutuu kutsutaan metodia _endGame()_ jossa määritellään kuka voitti kyseisen pelikierroksen ja jos pelaajalla on tarpeeksi rahaa voidakseen jatkaa pelaamista.

## Tiedon pysyväistallennus

## Päätoiminnallisuudet

## Ohjelman rakenteeseen jääneet heikkoudet

### Käyttöliittymä

Käyttöliittymäluokka on toteutettu samaan pakettiin kun sovellusloogiikkaan liittyväät luokat. Tämän lisäksi käyttöliittymä ei ole toteutettu aivan erilliseksi sovelluslogiikasta sillä joitakin sovelluslogiikkaan liittyviä rakenteita löytyy käyttöliittymäluokasta.

### Testiluokat

Testiluokissa on jäänyt vähän ylimääräisiä metodeja mitä luodaan automaattisesti mutta ei käytetä.

