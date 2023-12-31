package com.example.demo.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Strfoo {
    // simplify string
    public static String cook(String raw) {
        String ret = raw;

        // remove space
        ret = ret.replace(" ", "");

        // remove comment
        String from = "#.*?\n";
        String to = "";
        Pattern p = Pattern.compile(from);
        Matcher m = p.matcher(ret);
        ret = m.replaceAll(to);

        // remove \n
        ret = ret.replace("\n", "");

        return ret;
    }
}
