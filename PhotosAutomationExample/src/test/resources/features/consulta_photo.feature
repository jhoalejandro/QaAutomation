@consultarfoto
Feature: Consultar información de una foto

  Scenario Outline: Consultar la información de una fotograf�a
    Given la foto con id 15
    And con url "https://via.placeholder.com/600/771796"
    When la consulta la fotografia
    Then la consulta de la fotografia es <titulo>

    Examples: 
      | titulo |
      | alejo  |
      | prueba |
