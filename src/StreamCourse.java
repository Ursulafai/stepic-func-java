import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCourse {
    public static void main(String[] args) {
    }

    public static boolean isPrime(final long number) {
        Stream<Integer> naturalNumbers = Stream.iterate(2, n -> n + 1).limit(number - 1);

        return naturalNumbers.noneMatch(item -> number % item == 0 && item < number);
    }

    public static Stream<String> createBadWordsDetectingStream(String text, List<String> badWords) {
        return Arrays.stream(text.split("\\s")).filter(badWords::contains).distinct().sorted();
    }

    public static IntStream createFilteringStream(IntStream evenStream, IntStream oddStream) {
        return IntStream.concat(evenStream, oddStream).filter(it -> it % 3 == 0 && it % 5 == 0)
                .distinct().sorted().skip(2);
    }

    public static long factorial(long n) {
        if (n == 0) {
            return 1L;
        }

        Stream<Long> numbers = Stream.iterate(1L, el -> el + 1).limit(n);
        return numbers.reduce(1L, (acc, el) -> acc * el);
    }

    public static long sumOfOddNumbersInRange(long start, long end) {
        Stream<Long> numbers = Stream.iterate(start, el -> el + 1).limit(end - start + 1);
        return numbers.filter(it -> it % 2 != 0)
                .reduce(0L, Long::sum);
    }

    public static long calcNumberOfEmployees(List<Department> departments, long threshold) {
        return departments.stream()
                .filter(dep -> dep.getCode().startsWith("111-"))
                .flatMap(dep -> dep.getEmployees().stream())
                .filter(employ -> employ.getSalary() >= threshold)
                .count();
    }

    public static long calcSumOfCanceledTransOnNonEmptyAccounts(List<Account> accounts) {
        return accounts.stream().filter(acc -> acc.getBalance() > 0)
                .flatMap(acc -> acc.getTransactions().stream())
                .filter(tr -> tr.getState() == State.CANCELED)
                .mapToLong(Transaction::getSum)
                .sum();
    }
}
