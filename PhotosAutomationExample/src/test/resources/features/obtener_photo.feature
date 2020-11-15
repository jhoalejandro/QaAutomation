@obtenerPhoto
Feature: obtener información de una foto

  Scenario: Verificar la información de una fotograf�a
    Given que tengo la fotografia con titulo "reprehenderit est deserunt velit ipsam"
    And con url "https://via.placeholder.com/600/771796"
    When consulto la fotografia
    Then el id de la fotografia es 2
    And el id del album es 1
