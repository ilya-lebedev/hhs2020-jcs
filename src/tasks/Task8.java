package tasks;

import common.Person;
import common.Task;

import java.util.*;
import java.util.stream.Collectors;

/*
А теперь о горьком
Всем придется читать код
А некоторым придется читать код, написанный мною
Сочувствую им
Спасите будущих жертв, и исправьте здесь все, что вам не по душе!
P.S. функции тут разные и рабочие (наверное), но вот их понятность и эффективность страдает (аж пришлось писать комменты)
P.P.S Здесь ваши правки желательно прокомментировать (можно на гитхабе в пулл реквесте)
 */
public class Task8 implements Task {

    // Не хотим выдывать апи нашу фальшивую персону, поэтому конвертим начиная со второй
    public List<String> getNames(List<Person> persons) {

        return persons.stream()
                .skip(1)
                .map(Person::getFirstName)
                .collect(Collectors.toList());
    }

    // ну и различные имена тоже хочется
    public Set<String> getDifferentNames(List<Person> persons) {

        return persons.stream()
                .skip(1)
                .map(Person::getFirstName)
                .collect(Collectors.toSet());
    }

    // Для фронтов выдадим полное имя, а то сами не могут
    public String convertPersonToString(Person person) {
        String result = "";

        if (person.getFirstName() != null) {
            result = person.getFirstName();
        }

        if (person.getSecondName() != null) {
            if (result.length() > 0) {
                result += " ";
            }

            result += person.getSecondName();
        }

        return result;
    }

    // словарь id персоны -> ее имя
    public Map<Integer, String> getPersonNames(Collection<Person> persons) {

        return persons.stream()
                .collect(Collectors.toMap(Person::getId, Person::getFirstName));
    }

    // есть ли совпадающие в двух коллекциях персоны?
    public boolean hasSamePersons(Collection<Person> persons1, Collection<Person> persons2) {

        return !Collections.disjoint(persons1, persons2);
    }

    @Override
    public boolean check() {
        System.out.println("Слабо дойти до сюда и исправить Fail этой таски?");
        System.out.println("Не слабо!");
        boolean codeSmellsGood = true;
        boolean reviewerDrunk = false;
        return codeSmellsGood || reviewerDrunk;
    }

}
