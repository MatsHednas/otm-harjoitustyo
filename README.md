# Blackjack

Sovellus on klassinen blackjack peli. Pelaajalla on aloittaessaan pelin ensimmäistä kertaa 5000$ pelirahaa ja hän voi itse valita panosumman kuudesta eri valmiista panosmäärästä. Peli tallentaa myös pelaajan rahasumman joten se pysyy samana seuraavaan kertaan kun käyttäjä käynnistää pelin.

## Dokumentaatio
[Käyttöohje](https://github.com/MatsHednas/otm-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md)

[Vaatimusmäärittely](https://github.com/MatsHednas/otm-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](https://github.com/MatsHednas/otm-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Testausdokumentti](https://github.com/MatsHednas/otm-harjoitustyo/blob/master/dokumentaatio/testaus.md)

[Työaikakirjanpito](https://github.com/MatsHednas/otm-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

## Komentorivitoiminnot

### Testaus

Testit voidaan suorittaa komennolla

```
mvn test
```

Testikattavuusraportin voi luoda komennolla
```
mvn jacoco:report
```

Kattavuusraporttia voi tarkastella avaamalla tiedosto _target/site/jacoco/index.html_ selaimella


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

### Checkstyle

Tiedostoon [checkstyle.xml](https://github.com/MatsHednas/otm-harjoitustyo/blob/master/Blackjack/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheet löytyvät avaamalla tiedosto _target/site/checkstyle.html_ selaimella
