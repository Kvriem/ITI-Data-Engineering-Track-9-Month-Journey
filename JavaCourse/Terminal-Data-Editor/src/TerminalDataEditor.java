import java.io.*;

public class TerminalDataEditor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("1. Read file\n2. Write file\nEnter choice:");
        int choice = Integer.parseInt(br.readLine());

        System.out.println("Enter filename:");
        String filename = br.readLine();

        if (choice == 1) {
            try (DataInputStream dis = new DataInputStream(
                    new FileInputStream(filename))) {
                byte[] data = new byte[dis.available()];
                dis.readFully(data);
                System.out.println(new String(data));
            }
        } else {
            System.out.println("Enter text (end with empty line):");
            StringBuilder text = new StringBuilder();
            String line;
            while (!(line = br.readLine()).isEmpty()) {
                text.append(line).append("\n");
            }

            try (DataOutputStream dos = new DataOutputStream(
                    new FileOutputStream(filename))) {
                dos.write(text.toString().getBytes());
                System.out.println("File saved.");
            }
        }
    }
}