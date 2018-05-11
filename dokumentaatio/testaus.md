## Testausdokumentti

Ohjelmaa on testattu sekä manuaalisesti että JUnit testien avulla.

## Yksikkötestit

### Sovelluslogiikka

Luokat [Card](https://github.com/MatsHednas/otm-harjoitustyo/blob/master/Blackjack/src/main/java/blackjack/Card.java), [Deck](https://github.com/MatsHednas/otm-harjoitustyo/blob/master/Blackjack/src/main/java/blackjack/Deck.java), ja [Hand](https://github.com/MatsHednas/otm-harjoitustyo/blob/master/Blackjack/src/main/java/blackjack/Hand.java) ovat testattu kattavasti automaattisten JUnit yksikkötestien avulla testiluokissa [CardTest](https://github.com/MatsHednas/otm-harjoitustyo/blob/master/Blackjack/src/test/java/blackjacktests/CardTest.java), [DeckTest](https://github.com/MatsHednas/otm-harjoitustyo/blob/master/Blackjack/src/test/java/blackjacktests/DeckTest.java) ja [HandTest](https://github.com/MatsHednas/otm-harjoitustyo/blob/master/Blackjack/src/test/java/blackjacktests/HandTest.java).

Pääluokkaa [Blackjack](https://github.com/MatsHednas/otm-harjoitustyo/blob/master/Blackjack/src/main/java/blackjack/Blackjack.java), ei ole testattu automaattisten testien avulla sillä se koostuu enimmäkseen JavaFX:ään perustuvaan käyttöliittymään.

### Testikattavuus

Käyttöliittymäluokkaa lukuunottamatta sovelluksen testien rivikattavuus on % ja haarautumakattavuus %

Kaikkia metodeja testataan mutta jostain syystä yhdne "if"-lauseen argumentit eivät lasketa läpikäydyiksi vaikka loput lauseesta kyllä toteutuu.

## Järjestelmätestaus

Järjestelmätestaus on suoritettu manuaalisesti.

### Asennus ja toiminnallisuudet

Sovellus on testattu sen [Käyttöohjeen](https://github.com/MatsHednas/otm-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md) mukaisesti sekä Windows- että linux ympäristöissä. Molemmissa tapauksissa kaikki [määrittelydokumentin](https://github.com/MatsHednas/otm-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md) listaama nykyisen version toiminnallisuus on käyty läpi jo tedettu toimivaksi.


