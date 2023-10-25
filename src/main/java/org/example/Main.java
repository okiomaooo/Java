package org.example;

import java.util.*;

public class Main {
    static final int SIZE = 60_000_000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        firstMethod();
        System.out.println();
        secondtMethod();
        System.out.println();
        thirdMethod();

    }

    public static void firstMethod() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);
        long time = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время выполнения первого метода: " + (System.currentTimeMillis() - time));
        System.out.println("Значение первой ячейки массива: " + arr[0]);
        System.out.println("Значение последней ячейки массива: " + arr[arr.length-1]);
    }

    public static void secondtMethod() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);
        float[] firstHalf = new float[HALF];
        float[] secondHalf = new float[HALF];
        long time = System.currentTimeMillis();
        System.arraycopy(arr, 0, firstHalf, 0, HALF);
        System.arraycopy(arr, HALF, secondHalf, 0, HALF);

        Thread threadOne = new Thread(() -> {
            for (int i = 0; i < firstHalf.length; i++) {
                firstHalf[i] = (float) (firstHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(firstHalf, 0, arr, 0, firstHalf.length);
        });
        Thread threadTwo = new Thread(() -> {
            for (int i = 0; i < secondHalf.length; i++) {
                secondHalf[i] = (float) (secondHalf[i] * Math.sin(0.2f + (HALF + i) / 5) * Math.cos(0.2f + (HALF + i) / 5) * Math.cos(0.4f + (HALF + i) / 2));
            }
            System.arraycopy(secondHalf, 0, arr, HALF, secondHalf.length);
        });
        threadOne.start();
        threadTwo.start();
        try {
            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Время выполнения второго метода: " + (System.currentTimeMillis() - time));
        System.out.println("Значение первой ячейки массива: " + arr[0]);
        System.out.println("Значение последней ячейки массива: " + arr[arr.length-1]);

    }

    public static void thirdMethod() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);
        long time = System.currentTimeMillis();
        int countThreads = 12;
        Thread[] threads = new Thread[countThreads];
        int partSize = SIZE / countThreads; // размер одной из частей
        int foldedParts = 0; // для суммирования частей

        for (int i = 0; i < countThreads; i++)
        {
            if (i == 0){
                partSize += SIZE % countThreads;
            }
            else{
                partSize = SIZE / countThreads;
            }
            System.out.println(partSize);
            int finalPartSize = partSize; // размер одной из частей
            int finalFoldedParts = foldedParts; // для суммирования частей
            threads[i] = new Thread(() -> {
                float[] part = new float[finalPartSize];

                //(массив-источник, откуда начинаем брать данные из массива-источника, массив-назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем);

                System.arraycopy(arr, finalFoldedParts, part, 0, finalPartSize);

                for (int j = 0; j < part.length; j++) {
                    part[j] = (float) (part[j] * Math.sin(0.2f + (finalFoldedParts + j) / 5) * Math.cos(0.2f + (finalFoldedParts + j) / 5) * Math.cos(0.4f + (finalFoldedParts + j) / 2));
                }

                System.arraycopy(part, 0, arr, finalFoldedParts, finalPartSize);

            });

            foldedParts += partSize;
            threads[i].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Время выполнения третьего метода: " + (System.currentTimeMillis() - time));
        System.out.println("Значение первой ячейки массива: " + arr[0]);
        System.out.println("Значение последней ячейки массива: " + arr[arr.length-1]);
    }
}

