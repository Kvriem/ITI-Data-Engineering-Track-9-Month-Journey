import java.io.*;

public class TerminalFileEditor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("1. Read file\n2. Write file\nEnter choice:");
        int choice = Integer.parseInt(br.readLine());

        System.out.println("Enter filename:");
        String filename = br.readLine();

        if (choice == 1) {
            try (FileInputStream fis = new FileInputStream(filename)) {
                byte[] data = new byte[fis.available()];
                fis.read(data);
                System.out.println(new String(data));
            }
        } else {
            System.out.println("Enter text (end with empty line):");
            StringBuilder text = new StringBuilder();
            String line;
            while (!(line = br.readLine()).isEmpty()) {
                text.append(line).append("\n");
            }

            try (FileOutputStream fos = new FileOutputStream(filename)) {
                fos.write(text.toString().getBytes());
                System.out.println("File saved.");
            }
        }
    }
}