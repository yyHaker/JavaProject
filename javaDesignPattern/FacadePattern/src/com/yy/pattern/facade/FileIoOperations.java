package com.yy.pattern.facade;
import java.io.*;
import java.util.*;

public class FileIoOperations {

	  DataOutputStream dos;

	  public boolean writeToFile(String fileName, String dataLine,
		                                          boolean isAppendMode, boolean isNewLine) {
			if (isNewLine) {
			  dataLine = "\n" + dataLine;
			}
			try {
				   File outFile = new File(fileName);
				   if (isAppendMode) {
					   dos = new DataOutputStream(new FileOutputStream(fileName, true));
				   }
				   else {
					   dos = new DataOutputStream(new FileOutputStream(outFile));
				   }
				   dos.writeBytes(dataLine);
				   dos.close();
		    }
		    catch (FileNotFoundException ex) {
			       return (false);
			}
			catch (IOException ex) {
			      return (false);
			}
			return (true);
	  }

	  public String readFromFile(String fileName) {
			String DataLine = "";
			try {
			  File inFile = new File(fileName);
			  BufferedReader br = new BufferedReader(
									new InputStreamReader(
									  new FileInputStream(inFile)));

			  DataLine = br.readLine();
			  br.close();
			}
			catch (FileNotFoundException ex) {
			  return (null);
			}
			catch (IOException ex) {
			  return (null);
			}
			return (DataLine);
		  }
}

