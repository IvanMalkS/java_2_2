/*
* Задание 2.4
* Сотрудники и отделы.
* Создайте сущность Сотрудник, которая описывается именем (в строковой форме) и отделом, в котором сотрудник работает, причем у каждого отдела есть название и начальник, который также является Сотрудником. Сотрудник может быть приведен к текстовой форме вида: “Имя работает в отделе Название, начальник которого Имя”. В случае если сотрудник является руководителем отдела, то текстовая форма должна быть “Имя начальник отдела Название”. Необходимо выполнить следующие задачи:
* 1. Создать Сотрудников Петрова, Козлова, Сидорова работающих в отделе IT.
* 2. Сделать Козлова начальником IT отдела.
* 3. Вывести на экран текстовое представление всех трех Сотрудников (у всех троих должен оказаться один и тот же отдел и начальник)
* Задание 3.4
* Сотрудники и отделы.
* Измените решение, полученное в задаче 2.4 таким образом, чтобы имея ссылку на сотрудника, можно было бы узнать список всех сотрудников этого отдела
* */

package ru.ivan.employee;

import ru.ivan.department.Department;

public class Employee {
    private final String name;
    private final Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
        this.department.setEmployee(this);
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        if (department != null) {
            if (department.getBoss() == this) {
                return name + " начальник отдела " + department.getName();
            } else {
                return name + " работает в отделе " + department.getName() + ", начальник которого " + department.getBoss().getName();
            }

        } else {
            return "Не работает ни в одном отделе";
        }
    }
}