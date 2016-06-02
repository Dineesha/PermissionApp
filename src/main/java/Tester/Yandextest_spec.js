var frisby = require('/home/hsenid/Videos/SimpleFrisbyExample-master/node_modules/frisby/lib/frisby');
frisby.create('Ensure project is success')
    .post('http://localhost:8080/CompleteYandexApp/')
    .expectStatus(200)
    .inspectBody()
    .toss()

frisby.create('Verify working language list')
    .get('https://translate.yandex.net/api/v1.5/tr.json/getLangs?key=trnsl.1.1.20160311T110648Z.2843309257351b77.503eb0ab4fee6d8e09936972b4bc73810e4b12b4&ui=en')
    .expectStatus(200)
    .inspectBody()
    .expectHeaderContains('Content-Type', 'application/json')
    .toss()

frisby.create('verify translation is success')
    .get('https://translate.yandex.net/api/v1.5/tr.json/translate?key=trnsl.1.1.20160314T055210Z.609ee89149686a99.22e2a4c8f48279cba64fe814237ef790791fd2c5&text=tree&lang=en-fr')
    .inspectBody()
    .expectHeaderContains('Content-Type', 'application/json')
    .expectHeader('Content-Type', 'application/json; charset=utf-8')
    .expectJSON(
    {
        "code":200,
        "lang":"en-fr",
        "text":["arbre"]}
)
    .toss()
