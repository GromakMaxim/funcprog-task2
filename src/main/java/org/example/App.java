package org.example;

import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    static int RECOMMENDED_PRICE = 25;

    public static void main(String[] args) {
        List<PieceOfLand> lands = createListOfLands();

        Function<List<PieceOfLand>, List<PieceOfLand>> getFairDeals = item -> lands.stream()
                .filter(land -> land.getPricePerSquareMeter() <= RECOMMENDED_PRICE)
                .collect(Collectors.toList());

        Function<List<PieceOfLand>, List<PieceOfLand>> getUnfairDeals = item -> lands.stream()
                .filter(land -> land.getPricePerSquareMeter() > RECOMMENDED_PRICE)
                .collect(Collectors.toList());

        System.out.println("Введите цену(отобразятся сделки <= этого ценового порога): ");
        int price = getUsersInput();
        System.out.println("Честные сделки: ");
        printDeals(getFairDeals.apply(filterLandByUserInput(price, lands)));
        System.out.println("--------------------");
        System.out.println("Нечестные сделки: ");
        printDeals(getUnfairDeals.apply(filterLandByUserInput(price, lands)));
    }

    public static List<PieceOfLand> createListOfLands() {
        return Stream.of(new PieceOfLand(100, 100, 15),
                new PieceOfLand(100, 100, 15),
                new PieceOfLand(123, 321, 25),
                new PieceOfLand(110, 50, 35),
                new PieceOfLand(500, 500, 45),
                new PieceOfLand(210, 300, 125),
                new PieceOfLand(110, 190, 75),
                new PieceOfLand(100, 100, 125),
                new PieceOfLand(100, 100, 225),
                new PieceOfLand(100, 100, 5),
                new PieceOfLand(1000, 1000, 200))
                .collect(Collectors.toList());
    }

    public static int getUsersInput() {
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    public static List<PieceOfLand> filterLandByUserInput(int input, List<PieceOfLand> lands) {
        return lands.stream()
                .filter(land -> land.getPricePerSquareMeter() <= input)
                .collect(Collectors.toList());
    }

    public static void printDeals(List<PieceOfLand> lands) {
        lands.forEach(System.out::print);
    }


}
