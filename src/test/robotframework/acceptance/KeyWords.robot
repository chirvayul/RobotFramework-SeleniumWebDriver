*** Settings ***
Library     Keywords
Library     Selenium2Library


*** Keywords ***

Войти в личный кабинет
     [Arguments]               ${type}                ${login}        ${password}
     Sign In                   ${type}                ${login}        ${password}
     Sleep                     2s


Опубликовать объявление
    [Arguments]               ${title}  ${parentCategory}   ${childCategory}    ${state}    ${privateBusiness}  ${description}  ${address}  ${person}   ${mobile}
    New Ad                    ${title}  ${parentCategory}   ${childCategory}    ${state}    ${privateBusiness}  ${description}  ${address}  ${person}   ${mobile}
    Sleep                     2s
