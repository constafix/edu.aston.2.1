public class CustomLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    // Внутренний класс для узла списка
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    public CustomLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Метод для добавления элемента в конец списка
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Метод для получения элемента по индексу
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // Метод для удаления элемента по индексу
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 0) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next != null ? current.next.next : null;
            if (current.next == null) {
                tail = current;
            }
        }
        size--;
    }

    // Метод для добавления элементов из другого списка
    public void addAll(CustomLinkedList<T> otherList) {
        Node<T> current = otherList.head;
        while (current != null) {
            add(current.data);
            current = current.next;
        }
    }

    // Метод для получения размера списка
    public int size() {
        return size;
    }

    // Метод для вывода всех элементов списка
    public void printList() {
        Node<T> current = head;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(", ");
            }
            current = current.next;
        }
        System.out.println("]");
    }

}
