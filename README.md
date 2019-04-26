# Arvauspeli

Sovelluksen avulla pystyy pelaamaan arvailupeliä. Yritä vastata mahdollisimman moneen kysymykseen oikein!

## Dokumentaatio

[Vaatimusmäärittely](https://github.com/hveikka/ot-harjoitustyo/blob/master/ArvausPeli/dokumentointi/vaatimusmaarittely.md)



[Tuntikirjanpito](https://github.com/hveikka/ot-harjoitustyo/blob/master/ArvausPeli/dokumentointi/tuntikirjanpito2.md)



[Arkkitehtuuri](https://github.com/hveikka/ot-harjoitustyo/blob/master/ArvausPeli/dokumentointi/arkkitehtuuri.md)



[Käyttöohje](https://github.com/hveikka/ot-harjoitustyo/blob/master/ArvausPeli/dokumentointi/kayttoohjeet.md)


## Releaset 


[Viikon 5 release](https://github.com/hveikka/ot-harjoitustyo/releases/tag/viikko5)


## Komentorivitoiminnot

### Testaus

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto _target/site/jacoco/index.html_

### Suoritettavan jarin generointi

Komento

```
mvn package
```

generoi hakemistoon _target_ suoritettavan jar-tiedoston _ArvausPeli-1.0-SNAPSHOT.jar_


### Checkstyle

Checkstylen voi suorittaa komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Jonka jälkeen tuloksia voidaan tarkastella selaimella avaamalla tiedosto target/site/checkstyle.html




