public class Main {
    public static void main(String[] args) {

        //HashSet и проверки
        CustomHashSet<String> set = new CustomHashSet<>();

        // тест add
        System.out.println("Добавление:");
        set.add("Алексей");
        System.out.println("Добавлен Алексей. Массив: " + set);
        set.add("Борис");
        System.out.println("Добавлен Борис. Массив: " + set);
        set.add("Владимир");
        System.out.println("Добавлен Владимир. Массив: " + set);

        // тест contains
        System.out.println("\nПроверка наличия элементов:");
        System.out.println("Содержит Борис: " + set.contains("Борис")); // true
        System.out.println("Содержит Дмитрий: " + set.contains("Дмитрий")); // false
        System.out.println("Массив: " + set);

        // тест remove
        System.out.println("\nУдаление Борис:");
        set.remove("Борис");
        System.out.println("Содержит Борис после удаления: " + set.contains("Борис")); // false
        System.out.println("Массив: " + set);

        // Размер
        System.out.println("\nТекущий размер массива: " + set.size()); // 2
        System.out.println("Массив: " + set);

        // Повторная вставка
        System.out.println("\nПовторная вставка  Алексей:");
        set.add("Алексей");
        System.out.println("Содержит Алексей: " + set.contains("Алексей")); // true
        System.out.println("Массив: " + set);

        // Ресайз
        System.out.println("\nДобавление множества элементов для проверки resize:");
        String[] names = {"Дмитрий", "Евгений", "Фёдор", "Григорий", "Иван", "Кирилл", "Леонид", "Максим", "Никита", "Олег", "Павел", "Роман", "Сергей", "Тимур", "Устин", "Филипп", "Харитон", "Юрий", "Ярослав"};
        for (String name : names) {
            set.add(name);
        }
        System.out.println("Размер Массива после добавления элементов: " + set.size());
        System.out.println("Массив: " + set);



        //LinkedList и тесты

        CustomLinkedList<String> list = new CustomLinkedList<>();

        // тест add
        System.out.println("Тест add:");
        list.add("Кошка");
        list.add("Собака");
        list.add("Лев");
        list.printList();  //  [Кошка, собака, лев]

        // Тест get
        System.out.println("\nТест get:");
        System.out.println("Животное на индексе 0: " + list.get(0));  //  Кошка
        System.out.println("Животное на индексе 1: " + list.get(1));  //  собака
        System.out.println("Животное на индексе 2: " + list.get(2));  //  лев

        // Тест remove
        System.out.println("\nТест remove:");
        list.remove(1);  //  1 (собака)
        list.printList();  //  [Кошка, лев]
        list.remove(0);  //  0 (кошка)
        list.printList();  //  [лев]

        // Тест addAll
        System.out.println("\nТест addAll:");
        CustomLinkedList<String> anotherList = new CustomLinkedList<>();
        anotherList.add("Тигр");
        anotherList.add("Панда");
        list.addAll(anotherList);
        list.printList();  //  [лев, тигр, панда]

        // Тест size
        System.out.println("\nТест size:");
        System.out.println("Размер списка: " + list.size());  //  3
    }
}

