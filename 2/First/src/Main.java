import java.util.Arrays;
import java.io.FileWriter;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        int [] intsArr = {25, 1123, 15, 2, 6, 990, 236, 863, 9, 58};

        boolean isSorted = false;
        int temp;

        try (FileWriter ignored = new FileWriter("BubbleLog.txt")){
            FileHandler fh = new FileHandler("BubbleLog.txt");
            Logger logger = Logger.getLogger(Main.class.getName());
            logger.addHandler(fh);
            while(!isSorted) {
                isSorted = true;
                for (int i = 0; i < intsArr.length - 1; i++) {
                    if (intsArr[i] > intsArr[i + 1]) {
                        isSorted = false;
                        temp = intsArr[i];
                        intsArr[i] = intsArr[i + 1];
                        intsArr[i + 1] = temp;
                    }
                }
                logger.info(Arrays.toString(intsArr));
            }
            logger.log(Level.INFO,"sorted");
        } catch (Exception exception) {
            System.out.println("Some error");
        }
        System.out.println(Arrays.toString(intsArr));
    }
}