# Автоматизация тестовых сценариев для API сайта [Reqres.in](https://reqres.in/)
<img  src="images/screens/reqresin.jpg">


## Содержание
- [Технологический стек](#-технологический-стек)
- [API-тесты](#-api-тесты)
- [Запуск тестов в Jenkins](#-запуск-тестов-в-jenkins)
- [Allure-отчет](#-allure-отчет)
- [Уведомления в Telegram](#-уведомления-в-telegram)

## 💻 Технологический стек

<div align="center">
  <table>
    <tr>
      <!-- Первая строка -->
      <td align="center" width="110">
        <a href="https://www.jetbrains.com/idea/" target="_blank">
          <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/intellij/intellij-original.svg" width="48" height="48" alt="IntelliJ IDEA" />
        </a>
        <br>IDEA
      </td>
      <td align="center" width="110">
        <a href="https://www.java.com" target="_blank">
          <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="48" height="48" alt="Java" />
        </a>
        <br>Java
      </td>
      <td align="center" width="110">
        <a href="https://junit.org/junit5/" target="_blank">
          <img src="https://junit.org/junit5/assets/img/junit5-logo.png" width="48" height="48" alt="JUnit 5" />
        </a>
        <br>JUnit 5
      </td>
      <td align="center" width="110">
        <a href="https://gradle.org/" target="_blank">
          <img src="https://cdn.simpleicons.org/gradle/02303A" width="48" height="48" alt="Gradle" />
        </a>
        <br>Gradle
      </td>
    </tr>
    <tr>
      <!-- Вторая строка -->
      <td align="center" width="110">
        <a href="https://docs.qameta.io/allure/" target="_blank">
          <img src="https://avatars.githubusercontent.com/u/5879127?s=200&v=4" width="48" height="48" alt="Allure" />
        </a>
        <br>Allure
      </td>
      <td align="center" width="110">
        <a href="https://www.jenkins.io/" target="_blank">
          <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/jenkins/jenkins-original.svg" width="48" height="48" alt="Jenkins" />
        </a>
        <br>Jenkins
      </td>
      <td align="center" width="110">
        <a href="https://github.com/" target="_blank">
          <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/github/github-original.svg" width="48" height="48" alt="GitHub" />
        </a>
        <br>GitHub
      </td>
      <td align="center" width="110">
        <a href="https://rest-assured.io/" target="_blank">
          <img src="https://rest-assured.io/img/logo-transparent.png" width="48" height="48" alt="Rest-Assured" />
        </a>
        <br>Rest-Assured
      </td>
    </tr>
  </table>
</div>

- Тесты написаны на **Java** с использованием фреймворка **Selenide** в **IntelliJ IDEA**
- Сборка проекта осуществляется через **Gradle**
- Запуск тестов в контейнерах **Selenoid**
- Интеграция с **Jenkins** + автоматическая отправка отчетов в **Telegram**

---

## 🌐 API-тесты

### Основные проверки
- ✅ Получение списка пользователей
- ✅ Получение данных конкретного пользователя
- ✅ Создание нового пользователя
- ✅ Частичное обновление пользователя
- ✅ Полное обновление пользователя
- ✅ Удаление пользователя
---

## [<img src="images/logo/Jenkins.svg" width="40" height="40" alt="Jenkins"> Запуск тестов в Jenkins](https://jenkins.autotests.cloud/job/api-test/9/)
<img src="images/screens/Jenkins.png" width="800" alt="Allure">

### Локальный запуск
```bash
gradle clean all_api_test 
```


### Удаленный запуск (Jenkins)

```bash
clean ${TASK}
```



## [<img src="images/logo/Allure.svg" width="40" height="40" alt="Allure"> Allure-отчет](https://jenkins.autotests.cloud/job/api-test/9/allure/)

### Главная страница Allure-отчета
<img src="images/screens/AllureReport.png" width="800" alt="Allure">

### Пример отчета о выполнении тестов
<img src="images/screens/AllureTests.png" width="800" alt="Allure">

### График
<img src="images/screens/AllureGraphics.png" width="800" alt="Allure">


## <img src="images/logo/Telegram.svg" width="40" height="40" alt="Telegram"> Уведомления в Telegram

### После завершения сборки, бот, созданный в Telegram, автоматически обрабатывает и отправляет сообщение с результатом

<p align="center">
<img src="images/screens/TelegramReport.png" width="600" alt="Allure">
</p>
