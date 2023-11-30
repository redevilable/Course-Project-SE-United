package com.example.demo.linter;

import com.alibaba.fastjson.JSONObject;
import com.intellij.util.ui.PositionTracker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Constants {
    public String Author="BC";

    public ArrayList<JSONObject> getJsonl() throws IOException {
        ArrayList<JSONObject> ret = new ArrayList<JSONObject>();

        String resPath= "./Data/";
        String filePath= resPath+"api-sgsgsgsg-unixcoder-codegen-350M-mono-new-line-ws-20-ss-2.jsonl";

        System.out.println(filePath);

        File f = new File(filePath);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        String line;
        while ((line = br.readLine()) != null) {
            JSONObject j = JSONObject.parseObject(line);
            ret.add(j);
        }

        return ret;
    }

}
