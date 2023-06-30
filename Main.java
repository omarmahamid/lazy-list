package org.lazylist;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main{

    public static void main(String[] args) {

        LazyList<List<Integer>> lazyList = new LazyList<>();
        lazyList.add(() -> getPrimes(180));
        lazyList.add(() -> getPrimes(1009));
        lazyList.add(() -> getPrimes(123213));
        lazyList.add(() -> getPrimes(12));
        lazyList.add(() -> getPrimes(5));
    }

    private static List<Integer> getPrimes(int n){
        return IntStream
                .range(2, n)
                .filter(Main::isPrime)
                .boxed()
                .collect(Collectors.toList());
    }

    private static boolean isPrime(int candidatePrime){
        return IntStream
                .range(2, (int) Math.sqrt(candidatePrime) + 1)
                .noneMatch(factor -> meetModulo(candidatePrime, factor));
    }

    private static boolean meetModulo(int candidatePrime, int factor){
        return candidatePrime % factor == 0;
    }
}