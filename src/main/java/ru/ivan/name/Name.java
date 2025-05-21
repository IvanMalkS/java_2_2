/*
 * Задание 1.3
 * Создайте сущность Имя, которая описывается тремя параметрами: Фамилия, Личное имя,
 * Отчество. Имя может быть приведено к строковому виду, включающему традиционное представление всех трех параметров: Фамилия Имя Отчество (например “Иванов Иван Иванович”). Необходимо предусмотреть возможность того, что какой-либо из параметров может быть не задан, и в этом случае он не учитывается при приведении к текстовому виду.
 * Необходимо создать следующие имена:
 * Клеопатра
 * Пушкин Александр Сергеевич
 * Маяковский Владимир
 * Обратите внимание, что при выводе на экран, не заданные параметры никак не участвуют в образовании строки.
 */

package ru.ivan.name;

public class Name {
    private final String firstName;
    private final String lastName;
    private final String patronymic;

    public Name(String firstName, String lastName, String patronymic) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (lastName != null && !lastName.isEmpty()) {
            sb.append(lastName);
        }
        if (firstName != null && !firstName.isEmpty()) {
            if (!sb.isEmpty()) {
                sb.append(" ");
            }
            sb.append(firstName);
        }
        if (patronymic != null && !patronymic.isEmpty()) {
            if (!sb.isEmpty()) {
                sb.append(" ");
            }
            sb.append(patronymic);
        }
        return sb.toString();
    }
}