# Blackjack
## Dokumentaatio
[Vaatimusmäärittely](https://github.com/MatsHednas/otm-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Tuntikirjanpito](https://github.com/MatsHednas/otm-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

## Komentorivitoiminnot

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti saadaan luotua komennolla

```
mvn jacoco:report
```

Raporttia voi lukea avaamalla tiedosto _target/site/jacoco/index.html_

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
