import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static String printList(List<Integer> list){
        String s ="";
        for (int i : list) {
            s = s + i + " ";
        }
        return  s;
    }
    //Создем список
    public static List<Integer> createList(int length, int max) {
        List<Integer> result = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < length; i++){
            result.add(random.nextInt(max));
    }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.println("Введите размер списка: ");
        int length = scanner.nextInt();
        logger.log("Размер списка: " + length);
        System.out.println("Введите верхнюю границу для значений:");
        int max = scanner.nextInt();
        logger.log("Верхнее значение в списке: " + max);
        logger.log("Создаём и наполняем список");
        List <Integer> listResult = createList(length,max);
        logger.log("Создан случайный список: " + printList(listResult));
        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.println("Введите порог для фильтра от 0 до " + max);
        int f = scanner.nextInt();
        logger.log("Порог фильтрации: " + f);
        Filter filter = new Filter(f);
        List <Integer> listFilter = filter.filterOut(listResult);
        logger.log(" Отфильтрованный список: " + printList(listFilter));
        logger.log(" Програма завершена");
    }
}
