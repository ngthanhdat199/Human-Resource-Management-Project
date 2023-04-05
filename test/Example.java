
import javax.swing.*;

public class Example {

    int value = 10;

    public Example() {
        add();
    }

    public void add() {
        value += 15;
    }

    public void getValue() {
        System.out.println(value);
    }

}
