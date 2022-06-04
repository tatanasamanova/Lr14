import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите x ");
        int x = scanner.nextInt();
        Formula did = new Formula(x);
        did.displayFormula();
        System.out.print("Введите слово ");
        String word = scanner.next();
        if (word.equals("save")) {
            try (ObjectOutputStream fww = new ObjectOutputStream(new FileOutputStream("src//output.txt"))) {
                fww.writeObject(did);
                fww.writeInt(x);
                System.out.println("Ok");

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            System.out.println("Error");
        }
        System.out.print("Введите слово 2 ");
        String word2 = scanner.next();
        if (word2.equals("upload")) {
            try (ObjectInputStream pt = new ObjectInputStream(new FileInputStream("src//input.txt"))) {
                Formula form = (Formula) pt.readObject();
                System.out.println(form.x);
                System.out.println("Ok2");
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        else {
            System.out.println("Error2");
        }
    }
}
class Formula implements Serializable {
    float x;

    public Formula(float x) {
        this.x = x;
    }

    public void displayFormula() {
        double vector = x - (Math.sin(x));
        System.out.println(vector);
    }
}
