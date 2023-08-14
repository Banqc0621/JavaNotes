package com.example.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 班前程
 * @Company:北京万相信息
 * @Description:
 * @DateTime: 2023/8/10 11:08
 **/

/**
 * try-with-resources 是一个 Java 7 引入的语法，用于简化资源的管理和释放，以及避免显式地在代码中调用 close() 方法。
 * 这个语法可以在 try 语句块中声明资源，在代码块结束时自动关闭这些资源，无论代码块是正常执行完毕还是由于异常而退出。
 *
 * 语法结构如下：
 *
 * try (资源的声明) {
 *     // 使用资源的代码块
 * } catch (异常类型 e) {
 *     // 异常处理代码
 * }
 * 在这种语法下，你不需要显式地调用资源的 close() 方法来关闭资源，Java 会在 try 块结束时自动关闭这些资源。这种方式能够确保资源被适时地关闭，以防止资源泄漏。
 */
public class IOExample {
    public static void main(String[] args) {
        ByteStreamExample();//

        CharacterStreamExample();//

        BufferedStreamExample();//
    }

    /**
     * 01、字节流（Byte Streams）：
     *
     * 使用字节流可以进行二进制数据的读写，适用于处理图像、音频、视频等文件。
     */
    public static void ByteStreamExample() {
        try (InputStream inputStream = new FileInputStream("input.bin");
             OutputStream outputStream = new FileOutputStream("output.bin")) {
            int data;
            while ((data = inputStream.read()) != -1) {
                outputStream.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 02、字符流（Character Streams）：
     * 使用字符流可以处理文本数据，适用于处理文本文件等。
     *
     * java
     */
    public static void CharacterStreamExample() {
        try (Reader reader = new FileReader("input.txt");
             Writer writer = new FileWriter("output.txt")) {
            int data;
            while ((data = reader.read()) != -1) {
                writer.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 03、InputStreamReader 是字节流到字符流的桥梁，它将字节流（InputStream）转换为字符流（Reader），
     *
     * 并且可以指定字符编码进行解码。这对于在处理文本数据时非常有用，因为可以在读取字节数据的同时，将其按照指定的字符编码转换为字符数据。
     * InputStreamReader 提供了一个可以指定字符编码的构造函数，它可以将字节流按照指定的字符编码解码为字符流。
     * 这样，你就可以使用字符流的方式来读取和处理文本数据，而无需关心具体的字节表示。
     */
    public static void CharacterStreamExample02() {
        try (Reader reader = new InputStreamReader(new FileInputStream("input.txt"), "UTF-8");
             Writer writer = new OutputStreamWriter(new FileOutputStream("output.txt"), "UTF-8")) {
            int data;
            while ((data = reader.read()) != -1) {
                writer.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 04、缓冲流（Buffered Streams）：
     * 缓冲流可以在读写时提高效率，适用于大量数据的读写操作。
     */
    public static void BufferedStreamExample() {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // Add a new line after each line
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 05、缓冲流（Buffered Streams）：
     */
    public static void BufferedStreamExample02() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt"), "UTF-8"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt"), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 06、对象流（Object Streams）：
     */
    public static void ObjectStreamExample() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("objects.bin"));
             ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("objects.bin"))) {

            MyClass obj = new MyClass("Hello, Object Streams!");
            objectOutputStream.writeObject(obj);

            MyClass readObj = (MyClass) objectInputStream.readObject();
            System.out.println(readObj.getMessage());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 我们在 BufferedReader 的构造函数中指定了一个自定义的缓冲数组大小（bufferSize），
     * 然后按照指定的缓冲数组大小逐行读取数据，并将每行数据添加到 ArrayList 中。
     *
     * 请注意，选择缓冲数组大小需要平衡内存使用和读取效率。
     * 通常情况下，使用合适大小的缓冲数组可以在一定程度上提高读取效率，但过大的缓冲数组可能会占用过多的内存。根据实际情况进行调整。
     */
    public static void ReadLinesToListWithBufferSize() {
        List<String> lines = new ArrayList<>();
        int bufferSize = 8192; // Custom buffer size

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt"), "UTF-8"), bufferSize)) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print the lines from the ArrayList
        for (String line : lines) {
            System.out.println(line);
        }
    }

}

class MyClass implements Serializable {
    private String message;

    public MyClass(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}