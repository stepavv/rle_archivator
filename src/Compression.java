import org.apache.commons.io.output.ByteArrayOutputStream;

public class Compression {
    public static byte[] compress(byte[] input) {
        if (input.length == 0) {
            return new byte[0];
        }
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        int count = 1;
        byte lastValue = input[0];
        for (int i = 1; i < input.length; i++) {
            if (input[i] != lastValue || count == 255) {
                output.write((byte) count);
                output.write(lastValue);
                count = 1;
                lastValue = input[i];
            } else {
                count++;
            }
        }
        output.write((byte) count);
        output.write(lastValue);

        return output.toByteArray();
    }

    public static byte[] decompress(byte[] compressed) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        int i = 0;
        while (i < compressed.length) {
            if (i + 1 < compressed.length) {
                int count = compressed[i] & 0xFF; // чтобы избежать отрицательных значений
                byte value = compressed[i + 1];
                for (int j = 0; j < count; j++) {
                    output.write(value);
                }
                i += 2;
            } else {
                // обработка случая, когда остается только один байт в сжатом массиве
                // предположим, что этот байт представляет значение, которое повторяется один раз
                byte value = compressed[i];
                output.write(value);
                i++;
            }
        }
        return output.toByteArray();
    }
}
