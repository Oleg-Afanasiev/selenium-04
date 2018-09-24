@LoginProfile
Feature: Тестируем страницу авторизации
  Бла-бла-бла

  Scenario Outline: Неудачная авторизация
    Given Я нахожусь на домашней странице
    Then Я нажимаю ссылку signIn
    When Ввожу логин '<логин>'
    And Ввожу пароль '<пароль>'
    And нажимаю отправить
    Then должен увидеть сообщение об ошибке '<сообщение>'

    Examples:
      | логин                 | пароль        | сообщение                   |
      | wizik88@gmail.com     |123            |Invalid password.            |
      | 123                   |Tomax1488      |Invalid email address.       |