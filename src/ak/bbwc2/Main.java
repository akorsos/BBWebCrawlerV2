package ak.bbwc2;

import java.io.*;
import java.net.URL;
import java.util.Enumeration;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.*;
import javax.swing.text.html.parser.*;

public class Main {
    public static void main(String[] args) {
        Reader reader;

        try{

            URL u = new URL("http://www.google.com");

            //Create inputStream
            InputStream input = u.openStream();

            //Use stream to create streamReader
            reader = new InputStreamReader(input);

            //Create ParserDelegator
            ParserDelegator pd = new ParserDelegator();

            //Pass the streamReader and the ParserCallback class
            pd.parse(reader, new HTMLEditorKit.ParserCallback() {

                //Override the handleStartTag function in ParserCallback
                @Override
                public void handleStartTag(HTML.Tag t, MutableAttributeSet a, int pos) {

                    //An A tag defines a hyperlink
                    if(t == HTML.Tag.A)  {

                        //Create an enum to house elements
                        Enumeration attrNames = a.getAttributeNames();

                        //Iterate over elements to find actual links
                        while(attrNames.hasMoreElements()) {
                            Object key = attrNames.nextElement();

                            //Attribute href denotes a legitimate link
                            if("href".equals(key.toString())) {
                                System.out.println(a.getAttribute(key));
                            }
                        }
                    }
                }
            }, true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}