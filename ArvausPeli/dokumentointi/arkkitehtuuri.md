# Arkkitehtuurikuvaus


## Rakenne

Tällä hetkellä ohjelma koostuu eri näkymistä jotka hyödyntävät kysymysluokkia ja käyttäjäluokkaa.

![alt text](https://github.com/hveikka/ot-harjoitustyo/blob/master/ArvausPeli/dokumentointi/pakettikaavio.jpg)


## Käyttöliittymä

Ohjelma rakennettiin useaan eri käyttöliittymään joiden välillä vaihdellaan.
Halutun näkymän komponentit haetaan ja sijoitetaan aina alkuperäisen stagen keskelle. Tämä 
helpottaa uusien ja vanhojen näkymien säätämistä. Tämä oli myös mielestäni helpoin konsti.
Eri näkymät ovat vastuussa eri toiminnoista:

* MainView
Pitää huolen alkunäkymästä ja sisältää nappulat joilla päästään takaisin alkuun tai aloittamaan peli. Tämä myös käynnistää sovelluksen.

* StartView
Sijoitetaan aluksi MainViewin eli päänäkymän keskelle. Tästä näkymästä pääsee pistetilastoihin, apu-osioon ja sen vastuulla on käyttäjän nimen tallennus.

* HelpView
Sisältää ohjeet.

* GameView
Tämä näkymä sisältää itse pelin ja siihen vaadittavat toimivuudet. Pelin yksinkertaisuuden takia yksi näkymä mielestäni riittää tähän. GameView hyödyntää kysymys-luokkaa ja kysymyslistaa antaessaan käyttäjälle uusia kysymyksiä.

* EndView
Loppunäkymä. Kun käyttäjä on hävinnyt pelin EndView näyttää lopulliset pisteet ja ohjeistaa käyttäjän takaisin alkuun.



## Sovelluslogiikka

Ohjelma sisältää hyvin vähän sovelluslogiikkaa sen rakenteen takia. Tässä kuitenkin jonkinlainen esimerkki rakenteesta.

![alt text](https://github.com/hveikka/ot-harjoitustyo/blob/master/ArvausPeli/dokumentointi/luokat.jpg)







*Sovelluksen arkkitehtuuria päivitetään tulevaisuudessa sen kasvaessa.
