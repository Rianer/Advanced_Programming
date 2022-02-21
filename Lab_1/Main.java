package com.company;

public class Main {
    public static int generateNum() {
        return (int) (Math.random() * 1_000_000);
    }

    public static int modifyNum(int n) {
        n = n * 3;
        n = n + 21;
        n = n + 255;
        n = n * 6;
        return n;
    }

    public static int computeResult(int n) {
        int result = n;
        while (result / 10 != 0) {
            n = result;
            while (n / 10 != 0) {
                result = 0;
                result += n % 10;
                n = n / 10;
            }
        }
        return result;
    }

    public static void displayResult(String[] languages) {
        int n = computeResult(modifyNum(generateNum()));
        System.out.println("Willy-nilly, this semester I will learn " + languages[n]);
    }

    public static void main(String args[]) {
        System.out.println("Hello world!");

        String languages[] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        displayResult(languages);
    }
}
