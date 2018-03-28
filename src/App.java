import javax.swing.*;

public class App {

    public static  void main(String []args){
        //create new thread for app, only necessary if using multi-threaded app
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
    }
}
