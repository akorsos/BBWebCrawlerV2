package ak.bbwc2;

import java.io.*;
import java.net.URL;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.*;
import javax.swing.text.html.parser.*;

public class Main {
    public static void main(String[] args){
        Reader r;

        try   {
            URL u = new URL("https://bluebox.com");
            InputStream in = u.openStream();
            r = new InputStreamReader(in);
            ParserDelegator hp = new ParserDelegator();
            System.out.println("After Parse");

            hp.parse(r, new HTMLEditorKit.ParserCallback() {
                @Override
                public void handleStartTag(HTML.Tag t, MutableAttributeSet a, int pos) {
                    System.out.println(t);

                }
            }, true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}