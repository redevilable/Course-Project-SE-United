package com.example.demo.actions;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.ide.CopyPasteManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;

import org.jetbrains.annotations.NotNull;

import java.awt.datatransfer.Transferable;
import java.io.*;
import java.util.ArrayList;

import com.example.demo.linter.Constants;
import com.example.demo.Utils.Strfoo;

public class Gen extends AnAction {
    private Project currentProject;
    private ArrayList<JSONObject> jsonl;
    public Gen(){
        Constants c=new Constants();
        // init jsonl
        try{
            jsonl=c.getJsonl();
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
        currentProject = e.getProject();
        // e.getDataContext();
        // component=EditorComponent
        // file=file://C:/.....java

        // exit when no editor or no selection
        Editor editor = e.getData(CommonDataKeys.EDITOR);
        if (editor == null || !editor.getSelectionModel().hasSelection()) {
            Messages.showMessageDialog(currentProject, "No word selected", "Error", Messages.getInformationIcon());
            return;
        }
        int start = editor.getSelectionModel().getSelectionStart();
        int end = editor.getSelectionModel().getSelectionEnd();

        Document document = editor.getDocument();
        String selected=editor.getSelectionModel().getSelectedText();
        editor.getSelectionModel().removeSelection();

        ArrayList<JSONObject> result=search(selected,jsonl);

        Runnable runnable = () -> {
            String text="";

            // delete previous
            document.deleteString(start, end);
            String s_metadata=result.get(0).getString("metadata");
            JSONObject j_metadata=JSON.parseObject(s_metadata);
            String s_metadata_query_window=j_metadata.getString("query_window");
            JSONObject j_metadata_query_window=JSONObject.parseObject(s_metadata_query_window);
            String s_metadata_query_window_metadata=j_metadata_query_window.getString("metadata");
            JSONObject j_metadata_query_window_metadata=JSON.parseObject(s_metadata_query_window_metadata);
            String s_metadata_query_window_metadata_prediction=j_metadata_query_window_metadata.getString("prediction");

            text=s_metadata_query_window_metadata_prediction;
            // write new
            document.insertString(start, text);
        };
        WriteCommandAction.runWriteCommandAction(currentProject, runnable);
    }

// change the input and output, then test the result
    public ArrayList<JSONObject> search(String tar, @NotNull ArrayList<JSONObject> asset) {
        String cooked_tar= Strfoo.cook(tar);

        ArrayList<JSONObject> ret = new ArrayList<JSONObject>();
        for (JSONObject jo : asset) {
            if (match(cooked_tar, jo)) {
                ret.add(jo);
                break;
            }
        }
        return ret;
    }

    // check single json
    public boolean match(String tar, @NotNull JSONObject j) {
        boolean ret = false;

        String s_metadata = j.getString("metadata");
        JSONObject j_metadata = JSON.parseObject(s_metadata);
        String s_metadata_ground_truth = j_metadata.getString("ground_truth");

        if (Strfoo.cook(s_metadata_ground_truth).equals(tar)) {
            ret = true;
        }

        return ret;
    }


    public int write2Pis(AnActionEvent e, String text) {
        PsiFile pyfile = e.getData(CommonDataKeys.PSI_FILE);

        Editor editor = e.getData(CommonDataKeys.EDITOR);
//        editor.getSelectionModel()
        PsiElement piselement = e.getData(CommonDataKeys.PSI_ELEMENT);
//        PsiElementFactory psiElementFactory=PsiElementF

        Transferable transferable = CopyPasteManager.getInstance().getContents();

        if (pyfile == null || editor == null) {
            return -1;
        }
        return 0;
    }
}
































