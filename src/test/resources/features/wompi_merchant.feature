Feature: Consultar información de un comercio en Wompi

  @HappyPath_merchant
  Scenario:  Validar respuesta exitosa al consultar un comercio
    Given que "Wompi" es un usuario disponible
    When realiza una solicitud al endpoint de comercios
    Then valida el estado de la transacción con su respuesta