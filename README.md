# ClientBase
## Zadání
Vytvoriť BE s restovým API, ktorý slúži na správu klientov e-shopu a ich adries:
Klient ma jméno, příjmení a adresu (ulice, číslo, PSČ, město). Adresa může byť trvalá a poštová.
Ak má klient vyplnenú poštovú adresu, vždy musí mať i trvalú. Ak má trvalú adresu, poštovú mať nemusí, použije sa trvalá adresa

API poskytuje správu (vytváranie, zmenu a vymazanie) klientov i adries

## Spuštění
`gradle bootRun`
Aplikace poslouchá na portu 8080, je-li volný.

## Endpointy
* /clients
* /clients/{id}
* /addresses
* /addresses/{id}

## Omezení
* chybí testy

## Možná rozšíření
* popis rozhraní pomocí např: OpenAPI/Swagger
* RESTful podpora skrze Spring HATEOAS
* Spring Security dle nastavené politiky
* kontejnerizace
* NoSQL databáze
* apod.
