package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.*;

public class Controller {
   /* @FXML private    TextArea codeArea;
    @FXML private  TextArea numArea;


    @FXML protected  void exit(ActionEvent event){
        System.exit(0);
    }

    @FXML protected  void  newFile(ActionEvent event){

    }
    @FXML protected  void  saveFile(ActionEvent event){
          System.out.print(getCodeAreaRow());

    }
    @FXML protected  void  openFile(ActionEvent event){
        FileChooser fileChooser=new FileChooser();
        //Set extension filter
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("C  source file (*.c)", "*.c");
        fileChooser.getExtensionFilters().add(extFilter);
        File file =fileChooser.showOpenDialog(new Stage());
        if (file!=null){
            codeArea.clear();
            writeToCodeArea(file);
            SynchronousRow();
        }


    }

    @FXML protected  void onKeyPressed(KeyEvent keyEvent){
        if (keyEvent.getCode()== KeyCode.ENTER ||keyEvent.getCode()==KeyCode.BACK_SPACE){
            SynchronousRow();
        }

    }

    public  Controller(){
        super();
        //numArea.appendText(1+"\n");
    }

    *//**
     * 获得codeAre的行数
     * @return
     *//*
    public   int  getCodeAreaRow(){
        int num=1;
      char []code=codeArea.getText().toCharArray();
        for (int i=0;i<code.length;i++){
            if(code[i]=='\n'){
                num++;
            }
        }
        return num;
    }

    *//**
     * 记录行号
     *//*
    public     void SynchronousRow(){
        numArea.clear();
       // numArea.appendText(1+"");
        for(int i=1;i<=getCodeAreaRow();i++){
            numArea.appendText(i+"\n");
        }
    }

    *//**
     * 将文件中的内容写到指定的文本域
     * @param file
     *//*
     public void writeToCodeArea(File file){
         try{
             FileInputStream inputStream=new FileInputStream(file);
             byte[] bytes=new byte[1024];
             int len=-1;
             StringBuffer buf=new StringBuffer();
             while((len=inputStream.read(bytes))!=-1){
                 buf.append(new String(bytes,0,len));
             }
             inputStream.close();
             codeArea.appendText(buf.toString());
         }catch (IOException e){
             e.printStackTrace();
         }
     }

    *//**
     * 将codeArea中的文本保存到文件中
     *
     */

}