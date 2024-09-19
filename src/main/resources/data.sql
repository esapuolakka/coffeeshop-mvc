--Test data


INSERT INTO osasto (id, nimi, osastoid) VALUES (1, 'kahvilaitteet', 0);
INSERT INTO osasto (id, nimi, osastoid) VALUES (2, 'kulutustuotteet', 0);
INSERT INTO osasto (id, nimi, osastoid) VALUES (3, 'espressolaitteet', 1);
INSERT INTO osasto (id, nimi, osastoid) VALUES (4, 'suodatinkahvi', 1);
INSERT INTO osasto (id, nimi, osastoid) VALUES (5, 'kahvimyllyt', 1);
INSERT INTO osasto (id, nimi, osastoid) VALUES (6, 'suodattimet', 2);
INSERT INTO osasto (id, nimi, osastoid) VALUES (7, 'kahvi', 2);
INSERT INTO osasto (id, nimi, osastoid) VALUES (8, 'espressot', 7);
INSERT INTO osasto (id, nimi, osastoid) VALUES (9, 'suodatinkahvit', 7);



INSERT INTO valmistaja (id, nimi, url) VALUES
(1, 'Siemens', 'https://www.siemens.com'),
(2, 'De’Longhi', 'https://www.delonghi.com'),
(3, 'Breville', 'https://www.breville.com'),
(4, 'Nespresso', 'https://www.nespresso.com'),
(5, 'Moka Pot', 'https://www.mokapot.com'),
(6, 'Hario', 'https://www.hario.com'),
(7, 'Bodum', 'https://www.bodum.com'),
(8, 'Aerolatte', 'https://www.aerolatte.com'),
(9, 'Baratza', 'https://www.baratza.com'),
(10, 'Keurig', 'https://www.keurig.com'),
(11, 'Gaggia', 'https://www.gaggia.com'),
(12, 'Café du Monde', 'https://www.cafedumonde.com'),
(13, 'Lavazza', 'https://www.lavazza.com'),
(14, 'Peet’s Coffee', 'https://www.peets.com'),
(15, 'Illy', 'https://www.illy.com'),
(16, 'Stumptown', 'https://www.stumptowncoffee.com'),
(17, 'Blue Bottle Coffee', 'https://www.bluebottlecoffee.com'),
(18, 'Peugeot', 'https://www.peugeot.com'),
(19, 'Café Puro', 'https://www.cafepuro.com');



INSERT INTO toimittaja (id, nimi, yhteyshenkilo, yhteyshenkilon_email) VALUES
(1, 'Kahvi Co', 'Matti Meikäläinen', 'matti.meikalainen@kahvico.com'),
(2, 'Kahvilat Oy', 'Anna Anttila', 'anna.anttila@kahvilatoy.fi'),
(3, 'Kahviautomaatti Suomi', 'Pekka Peloton', 'pekka.peloton@kahviautomaatti.fi'),
(4, 'Kahvila Ekspertit', 'Tiina Taitava', 'tiina.taitava@kahvilaekspertit.fi'),
(5, 'Kahvituotteet Ab', 'Mika Maukka', 'mika.maukka@kahvituotteetab.com'),
(6, 'Kahvimaailma', 'Sari Sointu', 'sari.sointu@kahvimaailma.fi'),
(7, 'Kahvikuja', 'Veikko Vahva', 'veikko.vahva@kahvikuja.fi'),
(8, 'Kahvila & Leivonnaiset', 'Liisa Leipuri', 'liisa.leipuri@kahvila-leivonnaiset.fi'),
(9, 'Kahvitukku', 'Jukka Järjestelmä', 'jukka.jarjestelma@kahvitukku.fi'),
(10, 'Kahvitarvike', 'Sara Suunnittelija', 'sara.suunnittelija@kahvitarvike.fi');



INSERT INTO tuote (id, nimi, kuvaus, hinta, tuotekuva, osastoid, toimittajaid, valmistajaid, lisatty) VALUES 
(1, 'Siemens EQ.6 Plus S500 kahvikone', 'Siemens EQ.6 Plus S500 -kahvikoneessa on SensoFlow-teknologia sekä kätevä OneTouch-toiminto, joiden ansiosta keität erinomaista kahvia hetkessä.', 1299, NULL, 1, 1, 1, NOW()),
(2, 'De’Longhi Magnifica S ECAM 22.110', 'De’Longhi Magnifica S ECAM 22.110 -kahvikoneella valmistat herkullista espressoa ja suodatinkahvia yhdellä painalluksella.', 699, NULL, 1, 2, 2, NOW()),
(3, 'Breville Barista Express', 'Breville Barista Express -kahvikone yhdistää kahvimyllyn ja kahvinkeittimen, mikä takaa tuoreuden ja laadun.', 899, NULL, 1, 3, 1, NOW()),
(4, 'Rancilio Silvia', 'Rancilio Silvia on klassinen espresso-kone, joka tarjoaa ammattimaisen laadun kotikeittiössä.', 749, NULL, 1, 2, 3, NOW()),
(5, 'Nespresso VertuoPlus', 'Nespresso VertuoPlus -kahvikoneella voit valmistaa eri kokoisia kahvia helposti ja nopeasti.', 249, NULL, 1, 4, 4, NOW()),
(6, 'Moka Pot', 'Moka Pot on perinteinen kahvinkeittolaite, joka tuottaa voimakasta ja makuisaa kahvia.', 30, NULL, 1, 5, 5, NOW()),
(7, 'Hario V60', 'Hario V60 on suosittu suodatinlaite, joka takaa täydellisen suodatinkahvin valmistuksen.', 25, NULL, 1, 6, 6, NOW()),
(8, 'Bodum Chambord French Press', 'Bodum Chambord French Press on kaunis ja toimiva keitin, joka tuottaa täyteläistä kahvia.', 40, NULL, 1, 5, 7, NOW()),
(9, 'Aerolatte Milk Frother', 'Aerolatte Milk Frother on täydellinen väline maitovaahtojen valmistamiseen kahviin.', 20, NULL, 1, 4, 6, NOW()),
(10, 'Baratza Encore kahvimylly', 'Baratza Encore on huipputason kahvimylly, joka takaa tasaisen ja tarkan jauhamisen.', 199, NULL, 1, 2, 1, NOW()),
(11, 'Keurig K-Elite', 'Keurig K-Elite on kätevä kertakäyttökahvinkeitin, joka valmistaa kahvin nopeasti ja helposti.', 169, NULL, 1, 3, 4, NOW()),
(12, 'Gaggia Classic Pro', 'Gaggia Classic Pro on ammattilaistasoinen espresso-kone, joka on suunniteltu kotikäyttöön.', 599, NULL, 1, 2, 3, NOW()),
(13, 'Café du Monde Chicory Coffee', 'Café du Monde -kahvi on ranskalais-italialainen kahvi, joka on maustettu sikurilla.', 15, NULL, 1, 1, 4, NOW()),
(14, 'Lavazza Super Crema', 'Lavazza Super Crema on tasapainoinen kahvituote, jossa on voimakkaita makuja ja paksua vaahtoa.', 25, NULL, 1, 3, 2, NOW()),
(15, 'Peet’s Coffee Major Dickason’s Blend', 'Peet’s Coffee Major Dickason’s Blend on tumma paahtokahvi, joka on täynnä makua.', 20, NULL, 1, 2, 5, NOW()),
(16, 'Illy Classico Espresso', 'Illy Classico Espresso on laadukas espresso, joka tarjoaa erinomaisen maun ja aromin.', 12, NULL, 1, 1, 6, NOW()),
(17, 'Stumptown Coffee Roasters Hair Bender', 'Stumptown Coffee Roasters Hair Bender on monimuotoinen kahvi, jossa on hedelmäisiä ja mausteisia vivahteita.', 18, NULL, 1, 3, 1, NOW()),
(18, 'Blue Bottle Coffee Single Origin', 'Blue Bottle Coffee Single Origin -kahvi on huolellisesti valittu ja paahtoleivonnan huipputuote.', 22, NULL, 1, 4, 4, NOW()),
(19, 'Peugeot Bistro kahvimylly', 'Peugeot Bistro on klassinen kahvimylly, joka yhdistää muotoilun ja toimivuuden.', 45, NULL, 1, 5, 7, NOW()),
(20, 'Café Puro Organic Coffee', 'Café Puro Organic Coffee on luomutuote, joka on sekä herkullinen että kestävä valinta.', 16, NULL, 1, 1, 5, NOW()),
(21, 'Breville BES870XL Barista Express', 'Breville Barista Express yhdistää kahvimyllyn ja kahvinkeittimen, mahdollistaen tuoreiden kahvipapujen käytön.', 749, NULL, 1, 1, 1, NOW()),
(22, 'Jura E8', 'Jura E8 on automaattinen kahvikone, joka valmistaa erinomaisia espressoja ja muita kahvijuomia.', 1899, NULL, 1, 2, 2, NOW()),
(23, 'Krups XP4600', 'Krups XP4600 on kompakti espresso-kone, joka tarjoaa laadukasta kahvia kotona.', 399, NULL, 1, 3, 1, NOW()),
(24, 'Gaggia Anima Prestige', 'Gaggia Anima Prestige -kahvikoneessa on automaattinen maitovaahtosuutin, joka tekee latteista ja cappuccinoista vaivattomia.', 899, NULL, 1, 4, 3, NOW()),
(25, 'Rancilio Rocky', 'Rancilio Rocky on korkealaatuinen kahvimylly, joka on suunniteltu espresso-harrastajille.', 379, NULL, 1, 5, 4, NOW()),
(26, 'De’Longhi EC680M Dedica', 'De’Longhi EC680M Dedica on tyylikäs espresso-kone, joka vie vain vähän tilaa keittiössä.', 349, NULL, 1, 2, 5, NOW()),
(27, 'Saeco PicoBaristo', 'Saeco PicoBaristo on kompakti automaattinen kahvikone, joka valmistaa erinomaisia kahvijuomia yhdellä napin painalluksella.', 1099, NULL, 1, 3, 2, NOW()),
(28, 'Nespresso Lattissima Pro', 'Nespresso Lattissima Pro on innovatiivinen kahvikone, joka mahdollistaa maitokahvien valmistamisen helposti.', 499, NULL, 1, 4, 1, NOW()),
(29, 'Hamilton Beach FlexBrew', 'Hamilton Beach FlexBrew on monipuolinen kahvikone, joka valmistaa sekä kahvikapseleita että suodattimella keitettyä kahvia.', 99, NULL, 1, 5, 6, NOW()),
(30, 'Technivorm Cup-One', 'Technivorm Cup-One on kompakti kahvinkeitin, joka valmistaa yhden kupin täydellistä kahvia kerrallaan.', 99, NULL, 1, 1, 3, NOW()),
(31, 'Smeg ECF01', 'Smeg ECF01 on tyylikäs espresso-kone, joka yhdistää retrotyylin ja modernin teknologian.', 499, NULL, 1, 2, 2, NOW()),
(32, 'Café Barista', 'Café Barista on helppokäyttöinen espresso-kone, joka valmistaa maukkaita kahvijuomia yhdellä napin painalluksella.', 199, NULL, 1, 3, 4, NOW()),
(33, 'Breville BNV250BLK1BUC1 Vertuo', 'Breville Vertuo on innovatiivinen kahvikone, joka valmistaa erikokoisia kahveja kapselilla.', 249, NULL, 1, 4, 1, NOW()),
(34, 'La Pavoni Europiccola', 'La Pavoni Europiccola on klassinen kahvikone, joka tarjoaa perinteisen tavan valmistaa espressoa.', 799, NULL, 1, 2, 3, NOW()),
(35, 'Krups KM785D50', 'Krups KM785D50 on ohjelmoitava kahvinkeitin, joka mahdollistaa erikoiskahvien valmistamisen helposti.', 159, NULL, 1, 5, 4, NOW()),
(36, 'Cuisinart DCC-3200P1', 'Cuisinart DCC-3200P1 on ohjelmoitava kahvinkeitin, joka valmistaa jopa 14 kuppia kahvia kerrallaan.', 99, NULL, 1, 1, 5, NOW()),
(37, 'BUNN Speed Brew', 'BUNN Speed Brew -kahvinkeitin valmistaa kahvin nopeasti ja tehokkaasti, mikä on täydellinen kiireisiin aamuihin.', 129, NULL, 1, 2, 2, NOW()),
(38, 'Fellow Ode Brew Grinder', 'Fellow Ode Brew Grinder on huippuluokan kahvimylly, joka on suunniteltu erityisesti suodatinmenetelmiä varten.', 299, NULL, 1, 3, 1, NOW()),
(39, 'Breville BES990BSS Oracle Touch', 'Breville Oracle Touch on huipputason automaattinen kahvikone, joka tarjoaa täyden hallinnan kahvin valmistuksessa.', 2999, NULL, 1, 4, 3, NOW()),
(40, 'Melitta Caffeo CI', 'Melitta Caffeo CI on automaattinen kahvikone, joka mahdollistaa henkilökohtaisten kahvijuaiden tallentamisen.', 1199, NULL, 1, 5, 4, NOW());

INSERT INTO tuote (id, nimi, kuvaus, hinta, tuotekuva, osastoid, toimittajaid, valmistajaid, lisatty) VALUES 
(41, 'Lavazza Qualità Rossa', 'Lavazza Qualità Rossa on tasapainoinen ja täyteläinen suodatinkahvi, joka tarjoaa maukasta kahvinautintoa.', 12.99, NULL, 2, 1, 1, NOW()),
(42, 'Illy Espresso Medium Roast', 'Illy Espresso Medium Roast on pehmeä ja aromaattinen espresso, joka on valmistettu korkealaatuisista kahvipavuista.', 14.99, NULL, 2, 2, 2, NOW()),
(43, 'Peet’s Coffee Major Dickason’s Blend', 'Peet’s Coffee Major Dickason’s Blend on tumma paahtokahvi, joka on täynnä makua ja aromia.', 15.49, NULL, 2, 3, 1, NOW()),
(44, 'Koppi Coffee Light Roast', 'Koppi Coffee Light Roast on kevyempi paahto, joka tuo esiin kahvipavun herkät aromit.', 12.99, NULL, 2, 4, 3, NOW()),
(45, 'Starbucks Pike Place Roast', 'Starbucks Pike Place Roast on tasapainoinen ja pehmeä suodatinkahvi, joka sopii päivittäiseen käyttöön.', 11.99, NULL, 2, 5, 4, NOW()),
(46, 'Nespresso Arpeggio', 'Nespresso Arpeggio on voimakkaampi kahvikapseli, joka tarjoaa syvän maun ja intensiivisen aromin.', 0.89, NULL, 2, 1, 2, NOW()),
(47, 'Tchibo Cafissimo Classico', 'Tchibo Cafissimo Classico on klassinen kahvikapseli, joka tarjoaa tasapainoisen maun ja pehmeän aromin.', 0.79, NULL, 2, 2, 1, NOW()),
(48, 'Doi Tung Coffee', 'Doi Tung Coffee on kestävästi tuotettu kahvi, joka tuo esiin kahvipavun luonnolliset aromit.', 9.99, NULL, 2, 3, 2, NOW()),
(49, 'Café du Monde Chicory Coffee', 'Café du Monde Chicory Coffee on ranskalais-italialainen kahvi, joka on maustettu sikurilla.', 11.49, NULL, 2, 4, 3, NOW()),
(50, 'Peet’s Coffee Espresso Forte', 'Peet’s Coffee Espresso Forte on intensiivinen espresso, joka sopii erinomaisesti maitokahveille.', 14.99, NULL, 2, 5, 4, NOW()),
(51, 'Dunkin’ Donuts Original Blend', 'Dunkin’ Donuts Original Blend on tasapainoinen ja maukas suodatinkahvi, joka sopii arkeen.', 10.99, NULL, 2, 1, 1, NOW()),
(52, 'Julius Meinl Wiener Mélange', 'Julius Meinl Wiener Mélange on perinteinen itävaltalainen kahvi, jossa on pehmeä maku.', 13.99, NULL, 2, 2, 2, NOW()),
(53, 'Café Puro Organic Coffee', 'Café Puro Organic Coffee on luomutuote, joka on herkullinen ja kestävä valinta.', 12.49, NULL, 2, 3, 1, NOW()),
(54, 'Lavazza Super Crema', 'Lavazza Super Crema on pehmeä ja kermaisa kahvi, joka tarjoaa herkullisen vaahdon.', 14.99, NULL, 2, 4, 3, NOW()),
(55, 'Gevalia House Blend', 'Gevalia House Blend on tasapainoinen ja maukas suodatinkahvi, joka on täydellinen valinta aamiaiselle.', 11.49, NULL, 2, 5, 4, NOW()),
(56, 'McCafé Premium Roast', 'McCafé Premium Roast on maku, joka yhdistää tasapainon ja laadun, sopien päivittäiseen käyttöön.', 10.49, NULL, 2, 1, 1, NOW()),
(57, 'Death Wish Coffee', 'Death Wish Coffee on voimakkaasti paahdettu kahvi, joka sisältää korkeaa kofeiinipitoisuutta.', 16.99, NULL, 2, 2, 2, NOW()),
(58, 'Kicking Horse Coffee', 'Kicking Horse Coffee on tumma paahtokahvi, joka on täynnä makua ja intensiivisiä aromeja.', 15.99, NULL, 2, 3, 1, NOW()),
(59, 'Eight O’Clock Coffee Original', 'Eight O’Clock Coffee Original on klassinen kahvi, joka on saanut suosiota vuosikymmenten ajan.', 10.99, NULL, 2, 4, 3, NOW()),
(60, 'Nespresso Intenso', 'Nespresso Intenso on intensiivinen kahvikapseli, joka tarjoaa syvän maun.', 0.89, NULL, 2, 5, 4, NOW()),
(61, 'Keurig Green Mountain Breakfast Blend', 'Keurig Green Mountain Breakfast Blend on kevyt ja raikas kahvi, joka sopii aamun aloitukseen.', 10.49, NULL, 2, 1, 1, NOW()),
(62, 'Blue Bottle Coffee Single Origin', 'Blue Bottle Coffee Single Origin on huolellisesti valittu ja paahtoleivonnan huipputuote.', 15.99, NULL, 2, 2, 2, NOW()),
(63, 'Stumptown Coffee Roasters Hair Bender', 'Stumptown Coffee Roasters Hair Bender on monimuotoinen kahvi, jossa on hedelmäisiä ja mausteisia vivahteita.', 18.99, NULL, 2, 3, 1, NOW()),
(64, 'Brewed Awakening Coffee', 'Brewed Awakening Coffee on tuore jauhettu kahvi, joka tarjoaa herkullisen maun.', 11.49, NULL, 2, 4, 3, NOW()),
(65, 'Chicory Blend Coffee', 'Chicory Blend Coffee on ainutlaatuinen kahvi, joka on maustettu chicorylla.', 9.99, NULL, 2, 5, 4, NOW()),
(66, 'Peet’s Coffee House Blend', 'Peet’s Coffee House Blend on suodatinkahvi, joka on täydellinen valinta kotiin.', 12.99, NULL, 2, 1, 1, NOW()),
(67, 'Java Coffee Company', 'Java Coffee Company on tuore paahtokahvi, joka tarjoaa rikkaan maun.', 13.99, NULL, 2, 2, 2, NOW()),
(68, 'Coffee Bean & Tea Leaf', 'Coffee Bean & Tea Leaf -kahvi on korkealaatuista ja erikoispaahtoa.', 14.49, NULL, 2, 3, 1, NOW()),
(69, 'Café Bustelo Espresso', 'Café Bustelo Espresso on intensiivinen ja maukas espanjalainen espresso.', 10.99, NULL, 2, 4, 3, NOW()),
(70, 'Barista Prima Coffeehouse', 'Barista Prima Coffeehouse -kahvi on tumma ja täyteläinen, täydellinen espressoille.', 14.99, NULL, 2, 5, 4, NOW()),
(71, 'Sumatra Mandheling', 'Sumatra Mandheling on voimakas ja maanläheinen kahvi, joka sopii kahviharrastajille.', 15.99, NULL, 2, 1, 1, NOW()),
(72, 'Ethiopian Yirgacheffe', 'Ethiopian Yirgacheffe on aromikas ja hedelmäinen kahvi, joka tuo esiin erityiset maut.', 16.49, NULL, 2, 2, 2, NOW()),
(73, 'Colombian Supremo', 'Colombian Supremo on tasapainoinen kahvi, jossa on pehmeät ja makeat maut.', 14.99, NULL, 2, 3, 1, NOW()),
(74, 'Kona Coffee', 'Kona Coffee on herkullinen ja aromikas kahvi, joka on tuotettu Havaijilla.', 24.99, NULL, 2, 4, 3, NOW()),
(75, 'Costa Rican Tarrazu', 'Costa Rican Tarrazu on vahva ja kirkas kahvi, joka on täydellinen aamiaiselle.', 18.99, NULL, 2, 5, 4, NOW()),
(76, 'French Roast', 'French Roast on voimakas kahvi, jossa on intensiivinen maku ja tummapaahto.', 11.49, NULL, 2, 1, 1, NOW()),
(77, 'Mild Blend Coffee', 'Mild Blend Coffee on pehmeä ja mieto kahvi, joka sopii herkemmille makuhermoille.', 9.99, NULL, 2, 2, 2, NOW()),
(78, 'Tuscany Blend Coffee', 'Tuscany Blend Coffee on italialainen kahvi, joka on täynnä makua.', 15.99, NULL, 2, 3, 1, NOW()),
(79, 'Vanilla Flavored Coffee', 'Vanilla Flavored Coffee on makukahvi, joka tuo vaniljan makeuden kahviin.', 12.99, NULL, 2, 4, 3, NOW()),
(80, 'Hazelnut Coffee', 'Hazelnut Coffee on herkullinen makukahvi, jossa on pähkinäinen aromi.', 13.99, NULL, 2, 5, 4, NOW());


INSERT INTO rooli (id, rooli) VALUES (1, 'ROLE_ADMIN');
INSERT INTO rooli (id, rooli) VALUES (2, 'ROLE_USER');
INSERT INTO rooli (id, rooli) VALUES (3, 'ROLE_VIP');



