package tasks;

import common.Person;
import common.Task;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

/*
Задача 3
Отсортировать коллекцию сначала по фамилии, по имени (при равной фамилии),
и по дате создания (при равных фамилии и имени)
 */
public class Task3 implements Task {

    private List<Person> sort(Collection<Person> persons) {

        return persons.stream() // создаем стрим
                .sorted(Comparator // сортируем
                        .comparing(Person::getSecondName) // сначала по фамилии
                        .thenComparing(Person::getFirstName) // затем по имени
                        .thenComparing(Person::getCreatedAt)) // затем по дате создания
                .collect(Collectors.toList()); // собираем в лист
    }

    @Override
    public boolean check() {
        Instant time = Instant.now();
        List<Person> persons = List.of(
                new Person(1, "Oleg", "Ivanov", time),
                new Person(2, "Vasya", "Petrov", time),
                new Person(3, "Oleg", "Petrov", time.plusSeconds(1)),
                new Person(4, "Oleg", "Ivanov", time.plusSeconds(1))
        );
        List<Person> sortedPersons = List.of(
                new Person(1, "Oleg", "Ivanov", time),
                new Person(4, "Oleg", "Ivanov", time.plusSeconds(1)),
                new Person(3, "Oleg", "Petrov", time.plusSeconds(1)),
                new Person(2, "Vasya", "Petrov", time)
        );
        return sortedPersons.equals(sort(persons));
    }

}
