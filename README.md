# jv-spring-boot-docker

#### Технології: 
Spring Boot, Spring Security (inMemoryAuthentication), JpaRepository, H2, REST

#### Опис проекту: 
Проект відображає роботу основних методів: GET, POST, PUT, DELETE на прикладі моделі User. 

При старті відпрацьовує `PostConstruct` і база заповнюється тестовими даними. 

Використовується `inMemoryAuthentication`, тому доступними є два користувача:

| login      | password | 
| ---------- | -------- | 
| user       | 123      | 
| vip_user   | 123      | 

Для user недоступна функція оновлення користувача.
Для vip_user доступні всі функції. 

Щоб протестувати роботу рекомендую використовувати `Postman`.
Для авторизації: Authorization -> Type (Basic Auth) -> вводимо логін та пароль.
__GET__: `localhost:8080/users` - поверне 3 користувачів, але якщо: `localhost:8080/users?name=name` - то поверне знайдених за ім'ям користувачів.

__DELETE__: `localhost:8080/users/<id>` - видалить користувача за id.

__POST__: `localhost:8080/users` - створить нового користувача.

Body -> raw -> Text (JSON):
```json
{
    "firstName": "David", 
    "secondName": "Davidson", 
    "dateOfBirth": "11.09.1975", 
    "isMarried": true, 
    "typeOfEducation": "bachelors degree"
}
```

__PUT__: `localhost:8080/users/<id>` - оновить існуючого користувача за id.
```json
{
    "firstName": "Ivan", 
        "secondName": "Ivanov", 
        "dateOfBirth": "22.03.1980", 
        "isMarried": true, 
        "typeOfEducation": "specialist degree"
}
```

#### Автор.
[Kostiantyn Vorobiov](https://github.com/KostiantynVorobiov)
