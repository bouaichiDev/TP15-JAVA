package ex17;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

public class Memoizer {
    public static void main(String[] args) {
        AtomicReference<Function<Integer, Long>> fibRef = new AtomicReference<>();

        // Version memoized
        Function<Integer, Long> fibonacciMemoized = memoize(n -> {
            if (n <= 1) return (long) n;
            System.out.println("Calcul de fibonacci(" + n + ")");
            return fibRef.get().apply(n - 1) + fibRef.get().apply(n - 2);
        });

        // Assign the reference AFTER defining the memoized version
        fibRef.set(fibonacciMemoized);

        // Test avec la version memoized
        System.out.println("\nVersion memoized:");
        long start = System.currentTimeMillis();
        System.out.println("fibonacci(10) = " + fibonacciMemoized.apply(10));
        System.out.println("Temps: " + (System.currentTimeMillis() - start) + "ms");

        // Deuxième appel (devrait être instantané car en cache)
        System.out.println("\nDeuxième appel memoized:");
        start = System.currentTimeMillis();
        System.out.println("fibonacci(10) = " + fibonacciMemoized.apply(10));
        System.out.println("Temps: " + (System.currentTimeMillis() - start) + "ms");
    }

    // Implémentation du memoizer générique
    public static <T, R> Function<T, R> memoize(Function<T, R> function) {
        Map<T, R> cache = new ConcurrentHashMap<>();
        return input -> cache.computeIfAbsent(input, function);
    }
}
