🚩 Технические средства на которых выполнялись задания:
	🔸 операционная система - windows 10
	🔸 среда разработки - eclipse (JAVA SE 17)
	🔸 дополнительные библиотеки - фреймворк Spring (для Rest API)
	🔸 сборка - maven
	🔸 база данных - MySQL

❗Для каждого задания произведена проверка работоспособности
написанных функций с помощью Postman. 
Скриншоты результатов представлены в папке results.
_____________________________________________________________________________

Пояснения к заданию 1:

Так как в Java нет usigned int (а в обычном int 32-ой бит выделен под знак
числа), было решено использовать long, чтобы 4 октета не вызывали переполнений
в ходе парсинга в число.

Непосредственно функции конвертации IP реализованы в [сервисе](task1/src/main/java/com/hil/task1/service/serviceGettingIP.java)
______________________________________________________________________________

Пояснения к заданию 2:

Преобразуем исходное выражение:
un = (1 / n!) * (1! + 2! + 3! + ... + n!) =
= (1! / n!) + (2! / n!) + (3! / n!) + ... + (n! / n!) =
= 1 + (1 / n) + (1 / (n * (n - 1))) + ... + (1 / n!)
Уже здесь можно заметить, что вопрос в задании составлен неверно.
Выражение стремится к 1.

Функция подсчета выражения находится [здесь](task2/src/main/java/com/hil/task2/service/ServiceCountingExpression.java)
______________________________________________________________________________

Пояснения к заданию 3:

Добавим описание logins.cvs (так как в задании не указано):
Application - приложение
AppAccountName - имя пользователя
isActive - состояние пользователя
JobTitle - работа
Department - департамент

Следующей стадией будет создание сервиса для чтения файлов.
[Путь](task3/src/main/java/com/hil/task3/service) к сервисам.

Применим ООП и создадим два класса для работы с поставками и пользователями.
[Классы](https://github.com/N1kman/A1.Tasks/tree/master/task3/src/main/java/com/hil/task3/entity)

Далее написан сервис для конвертации информации из файла в сущности.
С полем Amount LC возникли проблемы. Формат float пишется через точку, 
а в файле через запятую. Задача решается с применением replaceAll.

Создание таблиц осуществляется следующими запросами:
CREATE TABLE logins (
    application VARCHAR(255),
    appAccountName VARCHAR(255),
    isActive BOOLEAN,
    jobTitle VARCHAR(255),
    department VARCHAR(255)
);
CREATE TABLE posting (
    mat_doc BIGINT,
    item INT,
    doc_date VARCHAR(255),
    pstng_date VARCHAR(255),
    description VARCHAR(255),
    quantity INT,
    bun VARCHAR(255),
    amount_LC FLOAT,
    crcy VARCHAR(255),
    username VARCHAR(255),  
    authorized_delivery BOOLEAN
);

По запросу http://localhost:8080/api/saveToDBFromFile можно загрузить
данные из двух файлов в базу данных.
Этот и все необходимые Api можно увидеть в [контроллере](task3/src/main/java/com/hil/task3/controller).

Фильтр огранизован по дате поставки.

