package org.example;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(" — Задание №1");
        List<String> words = new ArrayList<>(Arrays.asList("appl", "banana", "appl", "appl", "banana", "banana", "cherry", "cherry", "date", "date"));
        System.out.println(words.stream().collect(groupingBy(w -> w, counting()))
                .entrySet().stream().collect(groupingBy(Map.Entry::getValue, mapping(Map.Entry::getKey, toList())))
                .entrySet().stream().max(Comparator.comparingLong(Map.Entry::getKey)).map(Map.Entry::getValue)
                .orElse(Collections.emptyList()).stream().sorted(Comparator.reverseOrder())
                .collect(Collectors.joining(", ")));

        System.out.println("\n — Задание №2");
        Employee[] persons = new Employee[]{
                new Employee("примbhkvjknn", "Администратор", 200000000),
                new Employee("Егор", "Администратор", 10000),
                new Employee("Елена", "Администратор", 40000),
                new Employee("Дима", "Администратор", 21000),
                new Employee("Ма", "Администратор", 3000),
                new Employee("Марго2", "Кассир", 7000),
                new Employee("Настя", "Кассир", 19000),
                new Employee("Викаjhkbj", "Администратор", 120888800)
        };
        System.out.println(Arrays.stream(persons)
                .filter(employee -> "Администратор".equals(employee.getPost()))
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .limit(3)
                .sorted(Comparator.comparingInt(employee -> employee.getName().length()))
                .map(Employee::getName)
                .collect(Collectors.joining(", ","3 самых высокооплачиваемых сотрудника зовут: ","")));
    }
}