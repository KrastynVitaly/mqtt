
import arduino.Arduino;
import java.util.Scanner;

public class AppMain {

    public static void main(String[] args) throws InterruptedException {

        try (Scanner scanner = new Scanner(System.in)) {
            Arduino arduino = new Arduino("COM5", 9600);

            boolean connected = arduino.openConnection();
            System.out.println("Соединение установлено: " + connected);
            Thread.sleep(2000);

            label_1:
            while (scanner.hasNext()) {

                String s = scanner.nextLine();

                switch (s) {
                    case "blue on":
                        arduino.serialWrite('1');
                        break;
                    case "blue off":
                        arduino.serialWrite('0');
                        break;
                    case "green on":
                        arduino.serialWrite('3');
                        break;
                    case "green off":
                        arduino.serialWrite('2');
                        break;
                    case "red on":
                        arduino.serialWrite('5');
                        break;
                    case "red off":
                        arduino.serialWrite('4');
                        break;
                    case "all off":
                        arduino.serialWrite('6');
                        break;
                    case "all on":
                        arduino.serialWrite('7');
                        break;

                    case "exit":
                        arduino.serialWrite('0');
                        arduino.closeConnection();
                        break label_1;
                    default:
                        System.out.println(s + " - не является командой");
                        break;
                }
            }
        }
    }
}