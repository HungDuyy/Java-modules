package com.bosch.view;

import com.bosch.control.VerifyExcelWithXml;

import java.nio.file.Paths;
import java.nio.file.Path;

public class Consonle {
	VerifyExcelWithXml sharedXLXMLCompareObject;
	
	static Path currentpath = Paths.get("");
	static String fullpath = currentpath.toAbsolutePath().toString();
	
	static Path path = (Paths.get(fullpath)).getParent();
	static String FCpath = path.toAbsolutePath().toString() + "\\";
	
	static Path fcnametemp = (Paths.get(FCpath));
	static String fcnamerevision = fcnametemp.getFileName().toString();
	static int i = 0;
	static String fcnameonly = null;	
	
	
	 static String pvstfile = null;
	 static String interfaceList = null;
	 static String arxmlFile =  null;
	 static String cFile =  null;
	 static VerifyExcelWithXml x = null;
	//static StatusBar status;
	static void runn()
	{	
		if (fcnamerevision.toLowerCase().indexOf("spsa") > 0){
			i = fcnamerevision.toLowerCase().indexOf("spsa");
			fcnameonly = fcnamerevision.substring(0,i+4);
		}
		else if (fcnamerevision.toLowerCase().indexOf("slyr") > 0){
			i = fcnamerevision.toLowerCase().indexOf("slyr");
			fcnameonly = fcnamerevision.substring(0,i+4);
		}
		else if (fcnamerevision.toLowerCase().indexOf("psa") > 0){
			i = fcnamerevision.toLowerCase().indexOf("psa");
			fcnameonly = fcnamerevision.substring(0,i+3);
		}
		
		pvstfile = FCpath + fcnameonly + "_pavast.xml";
		interfaceList = FCpath + fcnameonly.toLowerCase() +  ".xls";
		arxmlFile =  FCpath + fcnameonly + ".arxml";
		cFile =  FCpath + fcnameonly + ".c";
		 
		System.out.println("Q-Valid folder: " + fullpath);
		System.out.println("FC path: " + path);
		System.out.println("Folder name: " + fcnamerevision);
		System.out.println("FC name: " + fcnameonly);

		if (interfaceList == null) {
			// do nothing
		}
		else
		{

		if ((pvstfile != null) && (interfaceList != null) && (arxmlFile != null) && (cFile != null)) {
			if ((pvstfile.toLowerCase().endsWith("_pavast.xml"))) {
				try {
					x = new VerifyExcelWithXml(interfaceList, pvstfile, arxmlFile, cFile,FCpath);
					//status.setMessage("Log file path : C:/Temp");
				} catch (Exception e1) {
					System.out.println(e1);
				}
			} else {
				System.out.println("provide the arguments :VerifyExcelWithXml.bat <interfaceListpath> <pavastFilePath> <arxmlFilePath");
			}
		} else if ((pvstfile != null) && (interfaceList != null) && (cFile != null)) {
			if ((pvstfile.toLowerCase().endsWith("_pavast.xml"))) {
				try {
					x = new VerifyExcelWithXml(interfaceList, pvstfile, null, cFile,FCpath);
					//status.setMessage("Log file path : C:/Temp");
				} catch (Exception e1) {
					System.out.println(e1);
				}
			} else {
				System.out.println("provide the arguments :VerifyExcelWithXml.bat <interfaceListpath> <pavastFilePath>");
			}
		} else {
			System.out.println("Inputs are not enough.");
		}
	
	}
	}	
	 
	public static void main(String arg[]) {
	runn();
	}

}
