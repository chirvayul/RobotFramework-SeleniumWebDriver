*** Settings ***
Resource            KeyWords.robot

Library     Keywords
Library     Selenium2Library

*** Testcases ***
End-to-end test case

    Войти в личный кабинет                               email       test@gmail.com           123456
    Опубликовать объявление                     Новое объявление    Детский мир     Детская обувь   Новый   Частное лицо      Описание объявления 20 символов     Киев        Автор объявления    1234567
