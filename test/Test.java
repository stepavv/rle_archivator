import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        byte[] input = {1, 1, 1, 2, 2, 3, 3, 3, 3};

        // Сжатие данных
        byte[] compressed = Compression.compress(input);
        System.out.println("Сжатые данные: " + Arrays.toString(compressed));

        // Разархивирование и сравнение с исходными данными
        byte[] decompressed = Compression.decompress(compressed);
        System.out.println("Исходные данные: " + Arrays.toString(decompressed));
        System.out.println("Совпадают ли исходные данные с исходным массивом? " + Arrays.equals(input, decompressed));
    }
}
