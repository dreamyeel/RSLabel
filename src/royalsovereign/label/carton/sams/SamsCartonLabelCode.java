package royalsovereign.label.carton.sams;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class SamsCartonLabelCode {

	boolean check;
	String output;
	int cartonCount, wh;
	
	public SamsCartonLabelCode() {
	}

	public String printLabel(String soNum) {
		// TODO Auto-generated method stub
		check = false;
		output = "";
		
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
							"soh.CustomerPONo, CASE WHEN sod.UDF_SKU IS NULL THEN sod.CommentText ELSE sod.UDF_SKU END as 'CommentText', sod.ItemCodeDesc, sod.ItemCode, " + 
							"sod.QuantityOrdered, CASE WHEN cii.UDF_MASTER_CTN_QTY=0 THEN 1 ELSE cii.UDF_MASTER_CTN_QTY END as 'UDF_MASTER_CTN_QTY', " +
							"CASE WHEN cii.UDF_MASTER_CTN_QTY = 0 THEN sod.QuantityOrdered ELSE CASE WHEN sod.QuantityOrdered<cii.UDF_MASTER_CTN_QTY THEN sod.QuantityOrdered ELSE sod.QuantityOrdered/cii.UDF_MASTER_CTN_QTY END END as 'TotalCartonQty', " +
							"sod.WarehouseCode " + 
							"FROM (RSI3...SO_SalesOrderHeader soh INNER JOIN RSI3...SO_SalesOrderDetail sod ON soh.SalesOrderNo = sod.SalesOrderNo)" + 
							"INNER JOIN RSI3...CI_Item cii ON sod.ItemCode = cii.ItemCode " +
							"Where soh.SalesOrderNo='" + soNum + "' AND sod.ItemCode Not Like '/%'");
			while (rs.next()) {
				if(!check){
					for (int i=1; i<=rs.getMetaData().getColumnCount(); i++){
						output += rs.getMetaData().getColumnName(i)+"|";
					}
					output += "\n";
				}
				System.out.println(output);
				for (int i=1; i<=rs.getMetaData().getColumnCount(); i++){
					System.out.print(rs.getString(i) + "|");
				}
				if(rs.getString(9) == null){
					conn.close();
					return "Please enter customer item# in Comment";
				}
				cartonCount=1;
				System.out.println(rs.getInt(14));
				while (cartonCount<=rs.getInt(14)){
					for (int i=1; i<=rs.getMetaData().getColumnCount(); i++){
						output += rs.getString(i)+"|";
					}
					output += cartonCount + "\n";
					cartonCount++;
				}
				System.out.println(output);
				generateCSV(output, wh);
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

	public String formatSO(String soNum) {
		// TODO Auto-generated method stub
		while (soNum.length() < 7)
			soNum = "0" + soNum;
		return soNum;
	}

	private void generateCSV(String output, int warehousecode) {
		String fileLocation = "//10.0.0.10/Public/IT/Label_Printing/bartender_edi/SamsCartonLabel.csv";
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
