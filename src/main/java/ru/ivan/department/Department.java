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

package ru.ivan.department;

import ru.ivan.employee.Employee;

import java.util.ArrayList;

public class Department {
    private final String name;
    private Employee boss;
    private final ArrayList<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.boss = null;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Employee getBoss() {
        return boss;
    }

    public void setBoss(Employee boss) {
        this.boss = boss;
    }

    public void setEmployee(Employee mewEmployee) {
        this.employees.add(mewEmployee);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public String getEmployeesNames() {
        StringBuilder result = new StringBuilder();
        for (Employee employee : employees) {
            if (employee != null) {
                result.append(employee.getName()).append("\n");
            }
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return "Department name: " + name + "with boss: " + boss + ".";
    }
}
