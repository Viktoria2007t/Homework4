package com.example.homework4;

public class Algorithm {

    /**
     * Поиск ближайшего счастливого билета
     * @param num номер не счастливого билета
     * @return счастливый билет
     */
    static int getLuckyTicket(int num) {

        while(true) {
            num++; // num += 1; // num = num + 1;
            if (checkTicket(num)) break;
        }

        return num;
    }

    /**
     * Проверка билета
     * @param num номер билета
     * @return Счастливый билет или нет
     */
    static boolean checkTicket(int num) {

        // Четные числа
        int evenNumbers = 0;

        // Нечетные числа
        int oddNumbers = 0;

        for (int i = 0; i < 6; i++) {

            if ((num % 10) % 2 > 0) oddNumbers += num % 10;
            else evenNumbers += num % 10;

            num = num / 10;
        }

        return evenNumbers == oddNumbers;
    }
}
