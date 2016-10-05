package com.yyHaker.lexical.view;

import com.yyHaker.lexical.model.Error;
import com.yyHaker.lexical.model.KeyInfor;
import com.yyHaker.lexical.property.ErrorProperty;
import com.yyHaker.lexical.property.TokenProperty;
import com.yyHaker.lexical.scanner.MyLexical;
import com.yyHaker.lexical.utils.FileUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * the controller of the lexical view
 *
 * @author yyHaker
 * @create 2016-10-04-22:08
 */
public class LexicalController {

     private  MyLexical myLexical;

    @FXML private TextArea codeArea;
    @FXML private  TextArea numArea;
    @FXML private TableView <TokenProperty> tokenTable;
    @FXML private  TableView<ErrorProperty>errorTable;

    @FXML private  TableColumn<TokenProperty,String> nameColumn;
    @FXML private  TableColumn<TokenProperty,Integer> codeColumn;
    @FXML private  TableColumn<TokenProperty,String> typeColumn;
    @FXML private  TableColumn<TokenProperty,Integer> rowColumn;

    @FXML private TableColumn<ErrorProperty,Integer> errorRowColumn;
    @FXML private  TableColumn<ErrorProperty,String>  strErrorColumn;
    @FXML private  TableColumn<ErrorProperty,String> errorKindColumn;



    @FXML protected  void exit(){
        System.exit(0);
    }

    @FXML protected  void  newFile(){
        codeArea.clear();
        mainApp.setTextFilePath(null);
    }
    @FXML protected  void  saveFile(){
        File textFile=mainApp.getTextFilePath();
        if (textFile!=null){
            saveToFile(codeArea.getText(),textFile);
        }else{
            saveFileAs();
        }
    }
     @FXML protected  void saveFileAs(){
         FileChooser fileChooser = new FileChooser();

         // Set extension filter
         FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                 "C  source file (*.c)", "*.c");
         fileChooser.getExtensionFilters().add(extFilter);

         // Show save file dialog
         File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());

         if (file != null) {
             // Make sure it has the correct extension
             if (!file.getPath().endsWith(".c")) {
                 file = new File(file.getPath() + ".c");
             }
             saveToFile(codeArea.getText(),file);
             mainApp.setTextFilePath(file);
         }
    }
    @FXML protected  void  openFile(){
        FileChooser fileChooser=new FileChooser();
        //Set extension filter
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("C  source file (*.c)", "*.c");
        fileChooser.getExtensionFilters().add(extFilter);
        File file =fileChooser.showOpenDialog(mainApp.getPrimaryStage());
        if (file!=null){
            codeArea.clear();
            writeToCodeArea(file);
            SynchronousRow();
            //保存当前打开的文件路径
            mainApp.setTextFilePath(file);
        }
    }

    /**
     * 词法编译
     */
    @FXML protected  void lexicalCompile(){
        myLexical=new MyLexical();
        myLexical.startLexical(codeArea.getText());
        System.out.println("----------------tokenList-------------------");
        myLexical.printTokenList();
        setTokenListToTable(myLexical.getTokenList());
        System.out.println("----------------errorList-------------------");
        myLexical.printErrorList();
        setErrorListToTable(myLexical.getErrorList());
     }


    @FXML protected  void onKeyPressed(KeyEvent keyEvent){
       SynchronousRow();
    }

    //Reference to the Main application
    private  MainApp mainApp;

 /*   public MainApp getMainApp() {
        return mainApp;
    }*/

    /**
     * Is called by the main application to give a reference back to itself.
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp){
        this.mainApp=mainApp;
    }

    public LexicalController(){
        super();
        //numArea.appendText(1+"\n");
    }

    /**
     * 获得codeAre的行数
     * @return
     */
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

    /**
     * 在numArea中显示行号
     */
      public    void SynchronousRow(){
        numArea.clear();
        // numArea.appendText(1+"");
        for(int i=1;i<=getCodeAreaRow();i++){
            numArea.appendText(i+"\n");
        }
    }


    /**
     * 将文件中的内容写到指定的文本域
     * @param file  文件路径或者名称
     */
    public void writeToCodeArea(File file){
        codeArea.clear();
        codeArea.appendText(FileUtils.readFromFile(file));
    }

    /**
     * 将文本保存到文件中
     */
    public void saveToFile(String text,File file){
        FileUtils.writeToFile(text,file);
    }

    /**
     * 将tokenList显示到表格
     * @param tokenList
     */
    public void setTokenListToTable(List<KeyInfor>  tokenList){
        if (tokenList!=null){
            ObservableList<TokenProperty> data= FXCollections.observableArrayList();
            nameColumn.setCellValueFactory(new PropertyValueFactory<TokenProperty,String>("name"));
            codeColumn.setCellValueFactory(new PropertyValueFactory<TokenProperty,Integer>("code"));
           typeColumn.setCellValueFactory(new PropertyValueFactory<TokenProperty,String>("type"));
            rowColumn.setCellValueFactory(new PropertyValueFactory<TokenProperty,Integer>("row"));

            for (KeyInfor keyInfor:tokenList){
                data.add(new TokenProperty(keyInfor.getKey().getName(),keyInfor.getKey().getCode(),
                        keyInfor.getKey().getType(),keyInfor.getRow()));
            }
            tokenTable.setItems(data);

        }
    }

    /**
     * 将errorList显示到表格
     * @param errorList
     */
    public void setErrorListToTable(List<Error> errorList){
         if(errorList!=null){
             ObservableList<ErrorProperty> errorData=FXCollections.observableArrayList();
             errorRowColumn.setCellValueFactory(new PropertyValueFactory<ErrorProperty,Integer>("row"));
             strErrorColumn.setCellValueFactory(new PropertyValueFactory<ErrorProperty,String>("strError"));
             errorKindColumn.setCellValueFactory(new PropertyValueFactory<ErrorProperty,String>("errorKind"));

             for (Error error: errorList){
                 errorData.add(new ErrorProperty(error.getRow(),error.getStrError(),error.getErrorKind()));
             }
             errorTable.setItems(errorData);
         }
    }



}
