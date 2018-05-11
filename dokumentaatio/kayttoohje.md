# Käyttöohje

Lataa tiedostot _Blackjack-1.0.jar_ ja _Cards.rar_ [täältä](https://github.com/MatsHednas/otm-harjoitustyo/releases/tag/1.0).

## Asennus

Pura tiedosto _Cards.rar_ samaan hakemistoon missä tiedosto _Blackjack-1.0.jar_ sijaitsee. Selkeyden vuoksi on varmasti helpointa luoda uusi hakemisto ja siirtää _Blackjack-1.0.jar_ sinne ja purkaa _Cards.rar_ siellä.

Kun sovellus käynnistetään ensimmäisen kerran se luo "_data_" nimisen tiedoston johon peliraha tallennetaan. Tämä tiedosto luodaan samaan hakemistoon misää _Blackjack-1.0.jar_ sijaitsee. 

## Ohjelman käynnistäminen

Ohjelma käynnistetään suorittamaalla tiedosto _Blackjack-1.0.jar_. Tämän voi tehdä esim komennolla

```
java -jar Blackjack-1.0.jar
```
## Pelin aloittaminen

Peli avautuu seuraavaan näkymään:

<img src= "https://github.com/MatsHednas/otm-harjoitustyo/blob/master/dokumentaatio/kuvat/1.PNG" width="600">

Pelaaminen aloitetaan valitsemalla panos ja painamalla _PLAY_.

## Pelin pelaaminen

Kun pelaaja painaa play nappia peli alkaa:

<img src= "https://github.com/MatsHednas/otm-harjoitustyo/blob/master/dokumentaatio/kuvat/2.PNG" width="600">

Pelaaja voi kysyä lisää kortteja painamalla _HIT_ tai jos on tyytyväinen kortteihinsa voi antaa vuoron jakajalle painamalla _STAND_.

## Pelin loppuminen

Peli loppuu jos pelajaalla tai jakajalla on "Blackjack", jos pelaajan käsi ylittää arvon 21 tai kun pelaaja on painanut _STAND_ nappia ja jakaja on suorittanut vuoronsa:

<img src= "https://github.com/MatsHednas/otm-harjoitustyo/blob/master/dokumentaatio/kuvat/3.PNG" width="600">

Nyt pelaaja voi halutessaan jatkaa peliä samalla panoksella painamalla _PLAY_ nappia, tai vahitaa panossummaa ja sitten jatkaa peliä.

## Pelin lopullinen päättyminen

Jos pelaajan peliraha putoaa nollaan hän ei voi jatkaa peliä ja pöydälle ilmestyy teksti joka huomauttaa että peli on päättynyt ("GAME OVER")

<img src= "https://github.com/MatsHednas/otm-harjoitustyo/blob/master/dokumentaatio/kuvat/4.PNG" width="600">

Pelaaja voi nyt aloittaa koko pelin alusta painamalla nappia _RESET GAME_ jolloin peli alkaa alusta ja pelaajalle annetaan taas 5000$ pelirahaa.
