Feature:  Crear transacciones de pago con nequi en Wompi

  @HappyPath_nequi
  Scenario: Crear fuente de pago con comercio Nequi
    Given que "wompi" es un cliente registrado con celular "3107654321"
    When obtiene los tokens de aceptacion prefirmados para wompi
    And genero un fuente de pago de tipo "NEQUI"
    Then el proceso de "crear la fuente de pago" del usuario es "creado"

  @UnHappyPath_incorrect
  Scenario: Crear fuente de pago con comercio incorrecto
    Given que "wompi" es un cliente registrado con celular "3107654321"
    When obtiene los tokens de aceptacion prefirmados para wompi
    And genero un fuente de pago de tipo "BBVA" no procesable
    Then el proceso de "crear la fuente de pago" del usuario es "improcesable"