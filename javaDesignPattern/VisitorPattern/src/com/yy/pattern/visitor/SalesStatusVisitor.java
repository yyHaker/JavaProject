package com.yy.pattern.visitor;

import com.yy.pattern.parts.CDDrive;
import com.yy.pattern.parts.ComputerCase;
import com.yy.pattern.parts.DVDDevice;
import com.yy.pattern.parts.DriveController;
import com.yy.pattern.parts.Fan;
import com.yy.pattern.parts.HardDiskDrive;
import com.yy.pattern.parts.Keyboard;
import com.yy.pattern.parts.Memory;
import com.yy.pattern.parts.Microprocessor;
import com.yy.pattern.parts.Monitor;
import com.yy.pattern.parts.Motherboard;
import com.yy.pattern.parts.Mouse;
import com.yy.pattern.parts.PowerSupply;
import com.yy.pattern.parts.VideoCard;
/**
 * in which sale status are calculated, including part name, total number of 
 * pieces of each part sold and total amount of money for each sold-out part 
 * （统计每种部件的销售量，与销售总额）;
 * The sale status statistics will be shown on the top right part of the GUI. 
 * @title SalesStatusVisitor
 * @Description 
 * @author yyHaker
 * @date 2016年9月20日 下午3:04:19
 */
public class SalesStatusVisitor implements Visitor {
	private static int ComputerCaseCount=0;
	private static double ComputerCaseSale=0;
	private static int PowerSupplyCount=0;
	private static double PowerSupplySale=0;
	private static int MotherboardCount=0;
	private static double MotherboardSale=0;
	private static int MicroprocessorCount=0;
	private static double MicroprocessorSale=0;
	private static int MemoryCount=0;
	private static double MemorySale=0;
	private static int DriveControllerCount=0;
	private static double DriveControllerSale=0;
	private static int HardDiskDriveCount=0;
	private static double HardDiskDriveSale=0;
	private static int CDDriveCount=0;
	private static double CDDriveSale=0;
	private static int DvDDeviceCount=0;
	private static double DvDDeviceSale=0;
	private static int MonitorCount=0;
	private static double MonitorSale=0;
	private static int KeyboardCount=0;
	private static double KeyboardSale=0;
	private static int MouseCount=0;
	private static double MouseSale=0;
	private static int FanCount=0;
	private static double FanSale=0;
	private static int VideoCardCount=0;
	private static double VideoCardSale=0;
    private String allSaleInfor=" ";
	@Override
	public void visitComputerCase(ComputerCase e) {
       ComputerCaseCount++;
       ComputerCaseSale=ComputerCaseCount*e.getPrice();
       allSaleInfor=allSaleInfor+"\n"+e.getName()+" "+ComputerCaseCount+" "+ComputerCaseSale;
	}

	@Override
	public void visitPowerSupply(PowerSupply e) {
      PowerSupplyCount++;
      PowerSupplySale=PowerSupplyCount*e.getPrice();
      allSaleInfor=allSaleInfor+"\n"+e.getName()+" "+PowerSupplyCount+" "+PowerSupplySale;
	}

	@Override
	public void visitMotherboard(Motherboard e) {
      MotherboardCount++;
      MotherboardSale=MotherboardCount*e.getPrice();
      allSaleInfor=allSaleInfor+"\n"+e.getName()+" "+MotherboardCount+" "+MotherboardSale;
	}

	@Override
	public void visitMicroprocessor(Microprocessor e) {
    MicroprocessorCount++;
    MicroprocessorSale=MicroprocessorCount*e.getPrice();
    allSaleInfor=allSaleInfor+"\n"+e.getName()+" "+MicroprocessorCount+" "+MicroprocessorSale;
	}

	@Override
	public void visitMemory(Memory e) {
       MemoryCount++;
       MemorySale=MemoryCount*e.getPrice();
       allSaleInfor=allSaleInfor+"\n"+e.getName()+" "+MemoryCount+" "+MemorySale;
	}

	@Override
	public void visitDriveController(DriveController e) {
     DriveControllerCount++;
     DriveControllerSale=DriveControllerCount*e.getPrice();
     allSaleInfor=allSaleInfor+"\n"+e.getName()+" "+DriveControllerCount+" "+DriveControllerSale;
	}

	@Override
	public void visitHardDiskDrive(HardDiskDrive e) {
      HardDiskDriveCount++;
      HardDiskDriveSale=HardDiskDriveCount*e.getPrice();
      allSaleInfor=allSaleInfor+"\n"+e.getName()+" "+HardDiskDriveCount+" "+HardDiskDriveSale;
	}

	@Override
	public void visitCDDrive(CDDrive e) {
     CDDriveCount++;
     CDDriveSale=CDDriveCount*e.getPrice();
     allSaleInfor=allSaleInfor+"\n"+e.getName()+" "+CDDriveCount+" "+CDDriveSale;
	}

	@Override
	public void visitDVDDevice(DVDDevice e) {
        DvDDeviceCount++;
        DvDDeviceSale=DvDDeviceCount*e.getPrice();
        allSaleInfor=allSaleInfor+"\n"+e.getName()+" "+DvDDeviceCount+" "+DvDDeviceSale;
	}

	@Override
	public void visitMonitor(Monitor e) {
         MonitorCount++;
         MonitorSale=MonitorCount*e.getPrice();
         allSaleInfor=allSaleInfor+"\n"+e.getName()+" "+MonitorCount+" "+MonitorSale;
	}

	@Override
	public void visitKeyboard(Keyboard e) {
        KeyboardCount++;
        KeyboardSale=KeyboardCount*e.getPrice();
        allSaleInfor=allSaleInfor+"\n"+e.getName()+" "+KeyboardCount+" "+KeyboardSale;
	}

	@Override
	public void visitMouse(Mouse e) {
        MonitorCount++;
        MouseSale=MouseCount*e.getPrice();
        allSaleInfor=allSaleInfor+"\n"+e.getName()+" "+MonitorCount+" "+MouseSale;
	}

	@Override
	public void visitFan(Fan e) {
       FanCount++;
       FanSale=FanCount*e.getPrice();
       allSaleInfor=allSaleInfor+"\n"+e.getName()+" "+FanCount+" "+FanSale;
	}

	@Override
	public void visitVideoCard(VideoCard e) {
      VideoCardCount++;
      VideoCardSale=VideoCardCount*e.getPrice();
      allSaleInfor=allSaleInfor+"\n"+e.getName()+" "+VideoCardCount+" "+VideoCardSale;
	}
	
	public String printAllSaleInfor(){
		return allSaleInfor;
	}

}
