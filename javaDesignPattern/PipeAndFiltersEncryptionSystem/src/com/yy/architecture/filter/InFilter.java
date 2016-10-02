package com.yy.architecture.filter;
import com.yy.architecture.pipe.*;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.*;


public class InFilter extends Filter
{
  private InputStream inStream;
  private JTextArea inputTxt;

  public InFilter(InputStream in, Pipe output,JTextArea orig)
  {
    super(null, output);
    inStream = in;     //��ͨ���Դ
    inputTxt = orig;
  }

/*-----------------------------------------------*/
/* This method reads and parses an input file.   */
/* The parsed data is written to the output pipe.*/
/*-----------------------------------------------*/
  protected void processData()
  {
    try{
      boolean isNewLine = false;
      boolean isNewWord = false;
      boolean isLineStarted = false;

      //read data from source file
      int c = inStream.read();

      while(c != -1){
        switch((byte) c){
        case '\n':
          isNewLine = true;
          break;
        case ' ':
          isNewWord = true;
          break;
        case '\t':
          isNewWord = true;
          break;
        case '\r':
          break;
        default:
          if(isNewLine)
          {
            outPipe.write('\n');
            isNewLine = false;
            isLineStarted = false;
          }
          if(isNewWord)
          {
            if(isLineStarted)
              outPipe.write(' ');
            isNewWord = false;
          }
          outPipe.write(c);     //д��"output"��

          isLineStarted = true;
          break;
        }
        c = inStream.read();
        inputTxt.append(""+(char)c);
      }

      outPipe.write('\n');
      outPipe.closePipedOutputStream();
    }catch(IOException exc){
      exc.printStackTrace();
      System.err.println("Error: Could not read the input file.");
      System.exit(1);
    }
  }
}
