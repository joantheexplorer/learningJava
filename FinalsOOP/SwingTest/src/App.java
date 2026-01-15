import javax.swing.JFrame;

public class App {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setTitle("JFrame Example"); // title of frame
        frame.setResizable(false); // prevent frame resized
        frame.setSize(400, 300); // dimension of frame
        frame.setVisible(true);
    }
}
