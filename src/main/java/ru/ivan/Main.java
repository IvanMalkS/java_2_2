/* Главный файл со всеми заданиями */

package ru.ivan;

import java.util.Arrays;
import java.util.List;

import ru.ivan.department.Department;
import ru.ivan.employee.Employee;
import ru.ivan.inputhandler.InputHandler;
import ru.ivan.inputhandler.config.DoubleInputConfig;
import ru.ivan.inputhandler.config.IntInputConfig;
import ru.ivan.inputhandler.config.StringInputConfig;
import ru.ivan.name.Name;
import ru.ivan.time.Time;

public class Main {
    public static void main(String[] args) {
        List<Double> tasks = Arrays.asList(1.3, 1.4, 2.4, 3.4, 4.4, 5.4);

        StringBuilder tasksPrompt = new StringBuilder("Available tasks:\n");
        for (Double task : tasks) {
            tasksPrompt.append(task).append("\n");
        }
        tasksPrompt.append("Enter task number (1-").append(tasks.size()).append("): ");

        DoubleInputConfig taskNumberConfig = new DoubleInputConfig.Builder()
                .setPrompt(tasksPrompt.toString())
                .setAllowedValues(tasks)
                .build();

        double selectedTask = InputHandler.getDouble(taskNumberConfig);

        switch (Double.toString(selectedTask)) {
            case "1.3":
                System.out.println("Выбрана задача 1.3");
                StringInputConfig nameConfig = new StringInputConfig.Builder()
                        .setPrompt("Enter your name: ")
                        .setMinLength(1)
                        .setMaxLength(100)
                        .allowOnlyLettersAndSpaces()
                        .requireUppercaseFirstLetter()
                        .build();

                StringInputConfig lastNameConfig = new StringInputConfig.Builder()
                        .setPrompt("Enter your last name: ")
                        .setMinLength(1)
                        .setMaxLength(100)
                        .allowOnlyLettersAndSpaces()
                        .requireUppercaseFirstLetter()
                        .build();

                StringInputConfig patronymicConfig = new StringInputConfig.Builder()
                        .setPrompt("Enter your patronymic: ")
                        .setMinLength(1)
                        .setMaxLength(100)
                        .allowOnlyLettersAndSpaces()
                        .requireUppercaseFirstLetter()
                        .build();

                String name = InputHandler.getString(nameConfig);
                String lastName = InputHandler.getString(lastNameConfig);
                String patronymic = InputHandler.getString(patronymicConfig);

                Name onlyName = new Name(name, null, null);
                System.out.println(onlyName);
                Name nameAndLastName = new Name(name, lastName, null);
                System.out.println(nameAndLastName);
                Name fio = new Name(name, lastName, patronymic);
                System.out.println(fio);

                break;
            case "1.4":
                System.out.println("Выбрана задача 1.4");
                IntInputConfig isoSecondsConfig = new IntInputConfig.Builder()
                        .setPrompt("Enter time in ISO format (only seconds): ")
                        .setMin(0)
                        .build();

                int isoTime = InputHandler.getInt(isoSecondsConfig);
                Time iso = new Time(isoTime);
                System.out.println(iso);
                break;
            case "2.4":
            case "3.4":
                StringInputConfig departmentNameConfig = new StringInputConfig.Builder()
                        .setPrompt("Enter department name: ")
                        .setMinLength(1)
                        .build();

                StringInputConfig employeeNameConfig = new StringInputConfig.Builder()
                        .setPrompt("Enter employee name: ")
                        .setMinLength(1)
                        .requireUppercaseFirstLetter()
                        .allowOnlyLettersAndSpaces()
                        .build();

                System.out.println("Выбрана задача " + selectedTask);
                String departmentName = InputHandler.getString(departmentNameConfig);
                Department department = new Department(departmentName);

                System.out.println("Добавьте босса");
                String bossName = InputHandler.getString(employeeNameConfig);
                Employee boss = new Employee(bossName, department);
                department.setBoss(boss);

                System.out.println(boss);

                System.out.println("Добавьте 3 работников");
                for (int i = 0; i < 3; ++i) {
                    String employeeName = InputHandler.getString(employeeNameConfig);
                    Employee employee = new Employee(employeeName, department);
                    System.out.println(employee);
                }

                if (selectedTask == 3.4) {
                    System.out.println("Работнички: ");
                    System.out.println(department.getEmployeesNames());
                }
                break;
            case "4.4":
                System.out.println("Выбрана задача 4.4");

                IntInputConfig secondsConfig = new IntInputConfig.Builder()
                        .setPrompt("Enter seconds: ")
                        .setMin(0)
                        .setMax(60)
                        .build();

                IntInputConfig minutesConfig = new IntInputConfig.Builder()
                        .setPrompt("Enter minutes: ")
                        .setMin(0)
                        .setMax(60)
                        .build();

                IntInputConfig hoursConfig = new IntInputConfig.Builder()
                        .setPrompt("Enter hours: ")
                        .setMin(0)
                        .setMax(24)
                        .build();

                int seconds = InputHandler.getInt(secondsConfig);
                int minutes = InputHandler.getInt(minutesConfig);
                int hours = InputHandler.getInt(hoursConfig);
                Time time = new Time(seconds, minutes, hours);
                System.out.println(time);
                break;
            case "5.4":
                System.out.println("Выбрана задача 5.4");
                IntInputConfig timeSecondsConfig = new IntInputConfig.Builder()
                        .setPrompt("Enter time in ISO format (only seconds): ")
                        .setMin(0)
                        .build();

                int timeSeconds = InputHandler.getInt(timeSecondsConfig);
                Time timeWithGetters = new Time(timeSeconds);
                System.out.println(timeWithGetters.getHours() + " часов");
                System.out.println(timeWithGetters.getMinutes() + " минут");
                System.out.println(timeWithGetters.getSeconds() + " секунд");
                break;
            default:
                System.out.println("Неизвестная задача: " + selectedTask);
        }
    }
}