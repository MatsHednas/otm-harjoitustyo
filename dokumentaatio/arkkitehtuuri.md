# Arkkitehtuurikuvaus

## Rakenne

Ohjelma on toteutetty yhdessä paketissa _blacckjack_ johon sisältyy kolme sovellusolgiikkaan liittyvää luokkaa _Cards_, _Deck_ ja _Hand_ sekä käyttöliittymäluokka _Blackjack_.

## Käyttöliittymä

Käyttyliittymään liitty yksi päänäkymä. Tämä kostoo pää-"Panesta" _root_ jonka sisään on lisätty kaksi vierekkäistä StackPanea _playmat_ ja _betmat_. Vasemmalla StackPanella eli _playmat_:illa näkyvät pelaajan sekä jakajan kortit ja oikealla olevalla StackPanella eli _betmat_:illa taas löytyvät kaikki pelin toiminnot johon pääsee käsiksi nappien avulla.

## Sovelluslogiikka

Sovellukseen logiikkaan liittyy kaikki neljä sovelluksen luokkaa:

<img src="https://github.com/MatsHednas/otm-harjoitustyo/blob/master/dokumentaatio/kuvat/rakenne.png" width="500">

Luokka _Blackjack_ vastaa käyttöliittymästa ja osasta sovellusloogiikkaa. Siihen liittyvistä metodeista keskisimmät logiikan suhteen ovat 
- Parent createGame()
- void newGame()
- void endGame()

Metodi _createGame()_ luo itse pelikenttänäkymän ja saa paluuarvokseen pää-"Panen" _root_. Kun painetaan nappia _PLAY_ kutsutaan metodia _newGame()_ joka asettaa uudellen kaikki käsiin ja muuhun peliin liittyvät muuttujat. Kun peli on päässyt siihen vaiheesen että jokin loppumiseen johtavista vaatimuksista toteutuu kutsutaan metodia _endGame()_ jossa määritellään kuka voitti kyseisen pelikierroksen ja jos pelaajalla on tarpeeksi rahaa voidakseen jatkaa pelaamista.

## Tiedon pysyväistallennus

Kun sovellus käynnistetään ensimmäisen kerran se luo automaattisesti tiedoston nimeltä "_data_" tämä on [SAV-tiedosto](https://whatis.techtarget.com/fileformat/SAV-Saved-date-file-for-SPSS-Statistical-Package-for-the-Social-Sciences) johon tallennetaan pelaajan rahasumma aina sen mukaan kun se muuttuu. Jos kyseinen tiedosto siirretään pois hakemistosta missä se luotiin, tai jos se poistetaan, ohjelma luo seuraavalla käynnistyskerralla uuden tallennustiedoston. 

## Päätoiminnallisuudet

Kun sovellus käynnistetään se luo pelinäkymän, korttipakan (_Deck_) ja kaksi kättä (_Hand_) joista yksi on pelaajan ja toinen on jakajan.

Pelinäkymässä voidaan nyt painaa eri panosarvonappeja jotka asettavat panossumman ja sitten aloittaa pelin painamalla _PLAY_ nappia joka kutsuu metodia _newGame()_, joka puolestaan aloittaa pelin lisäämällä pelaajan sekä jakajan käteen kaksi korttia metodilla _addCard()_. Nyt jos kumpikaan ei heti voita peliä, pelaaja voi halutessaan pyytää lisää kortteja painamalla _HIT_ nappia joka taas kutsuu käden  _addCard()_ metodia. Kun hän on tyytyväinen kortteihinsa pelaaja voi painaa _STAND_ nappia jolloin vuoro siirtyy jakajalle joka pelaa kätensä sääntöjen mukaisesti.

Kun jokin pelin päättymiseen johtavista vaatimuksista toteutuu kutsutaan metodia _endGame()_. Tämä metodi määrittelee voittajan ja tarkastaa jos pelaajalla vielä on tarpeeksi rahaa pelin jatkamiseen. Jos pelaajalla on tarpeeksi rahaa jatkaakseen hän voi valita uuden panossumman tai jatkaa samalla painamall taas _PLAY_ nappia. Jos pelaajalla ei ole tarpeeksi rahaa ruudulle ilmestyy teksti "GAME OVER" ja _RESET GAME_ nappi muuttu aktiiviseksi. Painamalla tätä nappia pelaaja voi aloittaa pelin alusta ja peli asettaa pelirahaksi summan 5000$.

Milloin napit avot aktiivisia eli painettavissa määritellään muutaman tietyn totuusarvomuuttujan avulla joihin napit ovat sidottuja.

## Ohjelman rakenteeseen jääneet heikkoudet

### Käyttöliittymä

Käyttöliittymäluokka on toteutettu samaan pakettiin kun sovellusloogiikkaan liittyväät luokat. Tämän lisäksi käyttöliittymä ei ole toteutettu aivan erilliseksi sovelluslogiikasta sillä joitakin sovelluslogiikkaan liittyviä rakenteita löytyy käyttöliittymäluokasta.

### Korttikuvat

Korttien kuvat olisi voitu jotenkin pakata jar tiedostoon mukaan jotta asennus olisi vielä helpompaa.

### Testiluokat

Testiluokissa on jäänyt vähän ylimääräisiä metodeja mitä luodaan automaattisesti mutta ei käytetä.

