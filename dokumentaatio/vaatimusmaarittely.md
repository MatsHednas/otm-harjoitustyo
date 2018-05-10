# Vaatimusmäärittely
## Sovelluksen tarkoitus

Sovellus on klassinen Blackjack-peli. Pelaaja aloittaa pelin tietyllä rahamäärällä ja voit itse valita panoksens kunhan hänellä on
tarpeeksi rahaa kyseiseen panos-summaan. Jos pelaajalta loppuu raha peli on hävitty ja peli alkaa alusta.

## Nykyisen version tarjoama toiminnallisuus

  - Pelaaja voi valita panoksensa
  
  - Pelaaja voi pyytää lisää kortteja tai ilmoittaa olevansa valmis
  
  - Jakaja toimii ydinpelin suhteen toivotusti 
    - Pitää yhden korteistansa peitettynä pelaajan vuoron aikana 
    - Ottaa kortteja kunnes arvo on ainakin 16 (tai enemmän riippuen siitä mikä arvo pelaajalla on)
    - Ei ota lisää kortteja jos arvo on 17 tai enemmän
    
  - Rahan hallinta toimii toivotusti
    - Pelaajan rahasumma tallennetaan jotta hän voi seuraavalla kerralla jatkaa samalla summalla
  
## Jatkokehitysideoita

- Tuplaus(Double)
  - Pelaaja voi halutessaan tuplata panoksensa jos hänen kahden ensimmäisen saamansa kortin yhteisarvo on 9-11. Tällöin pelaaja saa
    saa yhden kortin lisää ja hänen vuoronsa päättyy.
    
- Antautuminen(Surrender)
  - Pelaaja voi halutessaan antautua saatuaan kaksi ensimmäistä korttiaan. Tällöin pelaaja häviää puolet pelipanoksestaan ja saa
    pitää toisen puolikkaan. 
    
- Vakuutus(Insurance)
  - Mikäli jakajan ensimmäinen kortti on ässä, pelaaja voi vakuuttaa kätensä. Vakuutus maksaa puolet panoksesta ja jos jakajan
    toinen kortti on arvoltaan 10 eli yhteensä blackjack, pelaaja pitää koko panoksensa. Jos jakajan toinen kortti ei ole arvolataan
    10, pelaaja häviää vakuutuspanoksensa ja peli jatkuu normaalisti.
    
- Jakaminen(Split)
  - Mikäli pelaajan kaksi ensimmäistä korttia ovat samat hän voi halutessaan jakaa kortit kahteen eri käteen. Tässä tapauksessa
    panos myös tuplataan ja jaetaan molempien käsien kesken.
    
- Tasaraha(Even money)
  - Jos jakajan ensimmäinen kortti on ässä ja pelaajalla on blackjack, pelaaja voi halutessaan pyytää tasarahan. Tässä tapauksena
    se lasketaan normaalina voittona (1:1) blackjackin sijaan (3:2).
