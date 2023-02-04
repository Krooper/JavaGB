import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

/**
 * Реализуйте очередь с помощью LinkedList со следующими методами:
 * enqueue() - помещает элемент в конец очереди,
 * dequeue() - возвращает первый элемент из очереди и удаляет его,
 * first() - возвращает первый элемент из очереди, не удаляя.
 */

class Queue
{
    private final LinkedList<Integer> inQueue;
    public Queue(LinkedList<Integer> inpList)
    {
        inQueue=inpList;
    }

    LinkedList<Integer> getList()
    {
        return inQueue;
    }

    void enqueue(int value)
    {
        inQueue.addLast(value);
    }

    Integer dequeue()
    {
        int first = inQueue.getFirst();
        inQueue.removeFirst();
        return first;
    }

    Integer first()
    {
        return inQueue.getFirst();
    }
}


public class Main {
    public static void main(String[] args) {
        Integer[] ints = new Integer[10];

        Random rand = new Random();
        for (int i = 0; i < ints.length; i++) {
            ints[i] = rand.nextInt(100);
        }
        LinkedList<Integer> initList = new LinkedList<>(Arrays.asList(ints));

        System.out.println("Initial List:");
        System.out.println(initList);
        System.out.println("");

        Queue initQueue = new Queue(initList);
        System.out.println("Initial Queue:");
        System.out.println(initQueue.getList());
        System.out.println("");

        //Добавление элемента
        System.out.println("Adding new element to Queue...");
        initQueue.enqueue(100500);
        System.out.println("Updated Queue:");
        System.out.println(initQueue.getList());
        System.out.println("");

        //Первый элемент с удалением
        System.out.printf("First element in Queue: %d\n", initQueue.dequeue());
        System.out.println("Deleting...");
        System.out.println("Updated Queue:");
        System.out.println(initQueue.getList());
        System.out.println("");

        //Первый элемент без удаления
        System.out.printf("First element in Queue: %d\n", initQueue.first());
        System.out.println("The Queue didn't change:");
        System.out.println(initQueue.getList());
    }
}