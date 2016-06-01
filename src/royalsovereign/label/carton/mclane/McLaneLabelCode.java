package royalsovereign.label.carton.mclane;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class McLaneLabelCode {
	boolean check, CA;
	String output;
	int cartonCount;
	
	public McLaneLabelCode() {
	}

	public String printCartonLabel(String soNum) {
		// TODO Auto-generated method stub
		check = false;
		output = "";
		CA = false;
		
		try {
			// Class. forName("net.sourceforge.jtds.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:jtds:sqlserver://10.0.0.12;instance=sqlexpress",
					"sa", "Royals100$");
			System.out.println("connected");

			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt
					.executeQuery("SELECT soh.SalesOrderNo, soh.ShipToName, soh.ShipToAddress1, " +
							"CASE WHEN soh.ShipToAddress2 is null THEN '' ELSE soh.ShipToAddress2 END as 'ShipToAddress2', " + 
							"soh.ShipToCity, soh.ShipToState, soh.ShipToZipCode, " +
							"soh.ShipVia, soh.CustomerPONo, sod.UDF_SKU, sod.ItemCodeDesc, sod.ItemCode, " + 
							"sod.QuantityOrdered, CASE WHEN cii.UDF_MASTER_CTN_QTY=0 THEN 1 ELSE cii.UDF_MASTER_CTN_QTY END as 'UDF_MASTER_CTN_QTY', " +
							"CASE WHEN cii.UDF_MASTER_CTN_QTY = 0 THEN sod.QuantityOrdered ELSE CASE WHEN sod.QuantityOrdered<cii.UDF_MASTER_CTN_QTY THEN sod.QuantityOrdered ELSE sod.QuantityOrdered/cii.UDF_MASTER_CTN_QTY END END as 'TotalCartonQty', " +
							"soh.WarehouseCode " +
							"FROM (RSI3...SO_SalesOrderHeader soh INNER JOIN RSI3...SO_SalesOrderDetail sod ON soh.SalesOrderNo = sod.SalesOrderNo)" + 
							"INNER JOIN RSI3...CI_Item cii ON sod.ItemCode = cii.ItemCode " +
							"Where soh.SalesOrderNo='" + soNum + "' AND sod.ItemCode NOT LIKE '/%'");			
			
			
			while (rs.next()) {
				if(!check){
					for (int i=1; i<=rs.getMetaData().getColumnCount(); i++){
						output += rs.getMetaData().getColumnName(i)+"|";
						if (rs.getString(16).equalsIgnoreCase("2CA"))
							CA = true;
					}
					output += "\n";
				}
				cartonCount=1;
				System.out.println(rs.getInt(15));
				while (cartonCount<=rs.getInt(15)){
					for (int i=1; i<=rs.getMetaData().getColumnCount(); i++){
						output += rs.getString(i)+"|";
					}
					output += cartonCount + "\n";
					cartonCount++;
				}
				System.out.println(output);
				if (CA)
					generateCSVCA(output);
				else
					generateCSV(output);
				check = true;
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (check)
			return "Label Printed";	
		else
			return "No Matching Sales Order Number";
		
	}
	
	public String printPalletLabel(String soNum) {
		// TODO Auto-generated method stub
		check = false;
		output = "";
		CA = false;
		
		try {
			// Class. forName("net.sourceforge.jtds.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:jtds:sqlserver://10.0.0.12;instance=sqlexpress",
					"sa", "Royals100$");
			System.out.println("connected");

			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt
					.executeQuery("SELECT soh.SalesOrderNo, soh.ShipToName, soh.ShipToAddress1, " +
							"CASE WHEN soh.ShipToAddress2 is null THEN '' ELSE soh.ShipToAddress2 END as 'ShipToAddress2', " + 
							"soh.ShipToCity, soh.ShipToState, soh.ShipToZipCode, " +
							"soh.ShipVia, soh.CustomerPONo, sod.UDF_SKU, sod.ItemCodeDesc, sod.ItemCode, " + 
							"sod.QuantityOrdered, CASE WHEN cii.UDF_MASTER_CTN_QTY=0 THEN 1 ELSE cii.UDF_MASTER_CTN_QTY END as 'UDF_MASTER_CTN_QTY', " +
							"CASE WHEN cii.UDF_MASTER_CTN_QTY = 0 THEN sod.QuantityOrdered ELSE CASE WHEN sod.QuantityOrdered<cii.UDF_MASTER_CTN_QTY THEN sod.QuantityOrdered ELSE sod.QuantityOrdered/cii.UDF_MASTER_CTN_QTY END END as 'TotalCartonQty', " +
							"soh.WarehouseCode " +
							"FROM (RSI3...SO_SalesOrderHeader soh INNER JOIN RSI3...SO_SalesOrderDetail sod ON soh.SalesOrderNo = sod.SalesOrderNo)" + 
							"INNER JOIN RSI3...CI_Item cii ON sod.ItemCode = cii.ItemCode " +
							"Where soh.SalesOrderNo='" + soNum + "' AND sod.ItemCode NOT LIKE '/%'");			
			
			
			while (rs.next()) {
				if(!check){
					for (int i=1; i<=rs.getMetaData().getColumnCount(); i++){
						output += rs.getMetaData().getColumnName(i)+"|";
						if (rs.getString(16).equalsIgnoreCase("2CA"))
							CA = true;
					}
					output += "\n";
				}
				for (int i=1; i<=rs.getMetaData().getColumnCount(); i++){
					output += rs.getString(i)+"|";
				}
				output += cartonCount + "\n";
				if (CA)
					generateCSVCA(output);
				else
					generateCSV(output);
				check = true;
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(output);
		if (check)
			return "Label Printed";	
		else
			return "No Matching Sales Order Number";
		
	}

	public String formatSO(String soNum) {
		// TODO Auto-generated method stub
		while (soNum.length() < 7)
			soNum = "0" + soNum;
		return soNum;
	}

	private void generateCSV(String output) {
		String fileLocation = "//10.0.0.10/Public/IT/Label_Printing/bartender_edi/McLaneCartonLabel.csv";
		try {
			FileWriter fw = new FileWriter(fileLocation);
			fw.append(output);
			fw.flush();
			fw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	private void generateCSVCA(String output) {
		String fileLocation = "//10.0.0.10/Public/IT/Label_Printing/bartender_edi/McLaneCartonLabelCA.csv";
		try {
			FileWriter fw = new FileWriter(fileLocation);
			fw.append(output);
			fw.flush();
			fw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
