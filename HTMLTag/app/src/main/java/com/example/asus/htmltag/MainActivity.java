package com.example.asus.htmltag;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    String mytext=" <body>  <h1> This is heading 1 </h1>\n"+
            "<h2> This is heading 2 </h2>\n"
            +"<h3> This is heading 3</h3>\n"+
            "<p> This is a paragraph </p>" +
            "<p> <u> This is a underline </u> </p>\n" +
            "<p> <b> This is a Bold </b> </p>\n"+
            "<p> <i> This is a italic </i> </p>\n"+
            "\nProgramming Language Orderlist\n"+
            "<o1>\n"+"<ul>"+

            "<li>  C </li>\n"+

            "<li>  Java </li>\n"+

            "<li>  Phyton </li>\n"+

            "<li>  HTML </li>\n"+

            "<li>  CSS </li>\n"+

            "</o1>\n\n"+

            "(a+b)<sup>2</sup> = a<sup>2</sup>+2ab+b<sup>2</sup>"
            +"<a href=\"https://www.youtube.com/watch?v=Jyst8oIHOAY\"><br>Mercy</a>\n"+

            "<a href=\"https://www.youtube.com/watch?v=oKdOPWtjQb4\"> <br> Tor Moner Pinjoray </a>" +

           "<button>Click me</button>"
         +"\n" +
            "<ol>\n" +
            "  <li>Coffee</li>\n" +
            "  <li>Tea</li>\n" +
            "  <li>Milk</li>\n" +
            "</ol>"+"<p style=\"color:red\">I am a paragraph.</p>"+"</body>";

    String mytext1="<h1> This is heading 1 </h1>\n"+
            "<h2> This is heading 2 </h2>\n"
            +"<h3> This is heading 3</h3>\n"+
            "<p> This is a paragraph " +
            " <u>\nThis is a underline </u> </p>\n" +
            "<p> <b> This is a Bold </b> </p>\n"+
            "<p> <i> This is a italic </i> </p>\n"+
            "\nProgramming Language Orderlist\n"+
            "<o1>\n"+

            "<li>  C </li>\n"+

            "<li>  C++ </li>\n"+

            "<li>  Phyton </li>\n"+

            "<li>  HTML </li>\n"+

            "<li>  CSS </li>\n"+

            "</o1>\n\n"+

            "(a+b)<sup>2</sup> = a<sup>2</sup>+2ab+b<sup>2</sup>";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webviewid);

        webView.loadDataWithBaseURL(null, mytext,"text/html","utf-8",null);

    }
}
