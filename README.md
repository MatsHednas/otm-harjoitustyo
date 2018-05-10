# Blackjack

Sovellus on klassinen blackjack peli. Pelaajalla on aloittaessaan pelin ensimmäistä kertaa 5000$ pelirahaa ja hän voi itse valita panosumman kuudesta eri valmiista panosmäärästä. Peli tallentaa myös pelaajan rahasumman joten se pysyy samana seuraavaan kertaan kun käyttäjä käynnistää pelin.

## Dokumentaatio
[Käyttöohje](https://github.com/MatsHednas/otm-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md)

[Vaatimusmäärittely](https://github.com/MatsHednas/otm-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Työaikakirjanpito](https://github.com/MatsHednas/otm-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

## Komentorivitoiminnot

### Jar-tiedosto

Komento

```
mvn package
```

generoi hakemistoon _target_ suoritettavan jar-tiedoston _Blackjack-1.0.jar_

### JavaDoc

JavaDoc voidaan generoida komennolla

```
mvn javadoc:javadoc
```

JavaDocia voi tarkastella avaamalla tiedosto _target/site/apidocs/index.html_
