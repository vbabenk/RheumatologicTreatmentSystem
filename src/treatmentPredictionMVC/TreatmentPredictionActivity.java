package diploma.treatmentPredictionMVC;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import diploma.classes.Patient;
import org.sqlite.JDBC;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.stream.Stream;

public class TreatmentPredictionActivity {
    public ArrayList<Double> calculateTreatment(Patient patient) throws SQLException {
        ArrayList<Double> resultList = new ArrayList<>();
        ArrayList<Double> tempResList = new ArrayList<>();
        double x101 = 0.0;
        double x102 = 0.0;
        double x103 = 0.0;
        double x107 = 0.0;
        double x108 = 0.0;
        double x109 = 0.0;
        double x110 = 0.0;
        double x112 = 0.0;
        double x113 = 0.0;
        double x115 = 0.0;
        double x116 = 0.0;
        double x117 = 0.0;
        double x118 = 0.0;
        double x119 = 0.0;
        double x120 = 0.0;
        double x122 = 0.0;
        double x123 = 0.0;
        double x124 = 0.0;
        double x125 = 0.0;
        double x126 = 0.0;
        double x127 = 0.0;
        double x128 = 0.0;
        double x129 = 0.0;
        double x130 = 0.0;
        double x131 = 0.0;
        double x132 = 0.0;
        double x133 = 0.0;
        double x301;
        double x302;
        DriverManager.registerDriver(new JDBC());
        Connection con = DriverManager.getConnection("jdbc:sqlite:Databases\\RheumatologyDB.db");
        String select = "SELECT * FROM Patients WHERE patientID = " + patient.getPatientID();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        while (rs.next()) {
            x101 = rs.getString(6).equals("Жіноча") ? 1.0 : 2.0;
            x102 = rs.getDouble(7);
            x103 = rs.getDouble(8);
            x107 = rs.getString(9).equals("Так") ? 1.0 : 2.0;
            x108 = rs.getString(10).equals("Так") ? 1.0 : 2.0;
            x109 = rs.getString(11).equals("Так") ? 1.0 : 2.0;
            x110 = rs.getString(12).equals("Так") ? 1.0 : 2.0;
            x112 = rs.getString(13).equals("Так") ? 1.0 : 2.0;
            x113 = rs.getString(14).equals("Так") ? 1.0 : 2.0;
            x115 = rs.getString(15).equals("Так") ? 1.0 : 2.0;
            x116 = rs.getString(16).equals("Так") ? 1.0 : 2.0;
            x117 = rs.getString(17).equals("Так") ? 1.0 : 2.0;
            x118 = rs.getString(18).equals("Так") ? 1.0 : 2.0;
            x119 = rs.getString(19).equals("Так") ? 1.0 : 2.0;
            x120 = rs.getDouble(20);
            x122 = rs.getString(21).equals("Так") ? 1.0 : 2.0;
            x123 = rs.getString(22).equals("Так") ? 1.0 : 2.0;
            x124 = rs.getString(23).equals("Так") ? 1.0 : 2.0;
            x125 = rs.getString(24).equals("Так") ? 1.0 : 2.0;
            x126 = rs.getDouble(25);
            x127 = rs.getDouble(26);
            x128 = rs.getDouble(27);
            x129 = rs.getDouble(28);
            x130 = rs.getDouble(29);
            x131 = rs.getDouble(30);
            x132 = rs.getDouble(31);
            x133 = rs.getDouble(32);
        }
        con.close();
        switch (patient.getUraGroup()) {
            case "Поліартичний":
                outerloop:
                for (double x202 = 0; x202 <= 480; x202 += 0.1) {
                    for (double x210 = 0; x210 <= 1; x210++) {
                        for (double x214 = 0; x214 <= 30; x214 += 0.1) {
                            x301 = -25.0271 + x103 * 0.00877674 + x131 * 2.29592 + x132 * 0.0720283 + x133 * (-13.1271) +
                                    Math.pow(x124, 1.0 / 3) * 1.2204 + Math.pow(x125, 1.0 / 3) * (-0.920074) +
                                    Math.pow(x131, 1.0 / 3) * (-22.0096) + Math.pow(x132, 1.0 / 3) * (-1.78029) +
                                    Math.pow(x133, 1.0 / 3) * 63.9986 + Math.pow(x202, 1.0 / 3) * 0.0868669;
                            x302 = -57.4969 + x109 * 8.80073 + x113 * 7.52937 + x129 * 0.0348303 + x130 * (-1.03771) +
                                    x132 * 0.168166 + x133 * (-25.3338) + x210 * (-0.0431087) +
                                    Math.pow(x103, 1.0 / 3) * 0.221605 + Math.pow(x109, 1.0 / 3) * (-34.7676) +
                                    Math.pow(x113, 1.0 / 3) * (-31.2664) + Math.pow(x130, 1.0 / 3) * 9.09474 +
                                    Math.pow(x132, 1.0 / 3) * (-4.15418) + Math.pow(x133, 1.0 / 3) * 123.791 +
                                    Math.pow(x214, 1.0 / 3) * (-0.0673063);
                            if ((Math.round(x301) == 0 || Math.round(x302) == 0) && tempResList.size() == 0) {
                                tempResList.add(x202);
                                tempResList.add(x210);
                                tempResList.add(x214);
                                tempResList.add(x301);
                                tempResList.add(x302);
                            }
                            if (Math.round(x301) == 0 && Math.round(x302) == 0) {
                                resultList.add(x202);
                                resultList.add(x210);
                                resultList.add(x214);
                                resultList.add(x301);
                                resultList.add(x302);
                                break outerloop;
                            }
                        }
                    }
                }
                break;
            case "Олігоартичний":
                outerloop:
                for (double x201 = 0; x201 <= 20; x201 += 0.5) {
                    for (double x202 = 0; x202 <= 480; x202 += 0.1) {
                        for (double x205 = 1; x205 <= 2; x205++) {
                            for (double x211 = 0; x211 <= 1; x211++) {
                                for (double x214 = 0; x214 <= 30; x214 += 0.1) {
                                    x301 = 0.976951 + x214 * 0.0227064 + x125 * (-0.274938) + x119 * (-0.200273) +
                                            x117 * (-0.619072) + x122 * 0.436352 + x110 * 0.436144 + x211 * 0.67477 +
                                            x116 * 0.208239 + x113 * (-0.171558) + x205 * 0.328986 + x201 * (-0.010248) +
                                            x126 * (-0.004831) + x131 * (-0.173411) + x108 * 0.0855411 + x123 * (-0.205769);
                                    x302 = 0.223766 + x116 * (-0.68748) + x211 * 0.402412 + x112 * 0.322123 +
                                            x127 * (-0.00472275) + x102 * 0.0188978 + x110 * 0.358568 + x214 * 0.0272951 +
                                            x120 * 0.0165705 + x101 * (-0.154003) + x108 * (-0.294363) + x133 * 0.24687 +
                                            x107 * 0.245404 + x125 * (-0.107137) + x128 * (-0.00339796) + x202 * 0.00269242;
                                    if ((Math.round(x301) == 0 || Math.round(x302) == 0) && tempResList.size() == 0) {
                                        tempResList.add(x201);
                                        tempResList.add(x202);
                                        tempResList.add(x205);
                                        tempResList.add(x211);
                                        tempResList.add(x214);
                                        tempResList.add(x301);
                                        tempResList.add(x302);
                                    }
                                    if (Math.round(x301) == 0 && Math.round(x302) == 0) {
                                        resultList.add(x201);
                                        resultList.add(x202);
                                        resultList.add(x205);
                                        resultList.add(x211);
                                        resultList.add(x214);
                                        resultList.add(x301);
                                        resultList.add(x302);
                                        break outerloop;
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            default:
                outerloop:
                for (double x204 = 0; x204 <= 314000; x204++) {
                    for (double x205 = 1; x205 <= 2; x205++) {
                        for (double x206 = 1; x206 <= 2; x206++) {
                            for (double x208 = 0; x208 <= 1; x208++) {
                                for (double x209 = 0; x209 <= 1; x209++) {
                                    for (double x212 = 0; x212 <= 1; x212++) {
                                        for (double x213 = 0; x213 <= 1; x213++) {
                                            x301 = 0.60339 + x103 * 0.00576812 + x110 * 0.593232 + x115 * 0.560398 +
                                                    x118 * (-0.9414) + x122 * 0.606188 + x123 * (-0.0895513) +
                                                    x127 * 0.0106821 + x129 * (-0.049461) + x204 * 4.85624e-05 +
                                                    x205 * (-0.49675) + x206 * (-0.149593) + x208 * (-0.23807) +
                                                    x212 * (-0.635232) + x213 * (-0.4027);
                                            x302 = 3.1043 + x102 * (-0.046695) + x103 * 0.00542804 + x107 * (-0.143061) +
                                                    x109 * (-0.217819) + x112 * 0.177746 + x116 * 0.253273 +
                                                    x122 * (-0.801119) + x127 * 0.000932035 + x129 * (-0.0358066) +
                                                    x206 * (-0.461582) + x209 * 0.330299;
                                            if ((Math.round(x301) == 0 || Math.round(x302) == 0) && tempResList.size() == 0) {
                                                tempResList.add(x204);
                                                tempResList.add(x205);
                                                tempResList.add(x206);
                                                tempResList.add(x208);
                                                tempResList.add(x209);
                                                tempResList.add(x212);
                                                tempResList.add(x213);
                                                tempResList.add(x301);
                                                tempResList.add(x302);
                                            }
                                            if (Math.round(x301) == 0 && Math.round(x302) == 0) {
                                                resultList.add(x204);
                                                resultList.add(x205);
                                                resultList.add(x206);
                                                resultList.add(x208);
                                                resultList.add(x209);
                                                resultList.add(x212);
                                                resultList.add(x213);
                                                resultList.add(x301);
                                                resultList.add(x302);
                                                break outerloop;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                break;
        }
        if (resultList.size() == 0) {
            return tempResList;
        } else {
            return resultList;
        }
    }

    public void createPdfFile(ArrayList<String> resultList, File file) throws DocumentException, IOException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(file.toString()));
        document.open();
        PdfPTable table = new PdfPTable(2);
        addTableHeader(table);
        addRows(table, resultList);
        document.add(table);
        document.close();
    }

    private void addTableHeader(PdfPTable table) {
        Stream.of("Атрибут", "Значення")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });
    }

    private void addRows(PdfPTable table, ArrayList<String> resultList) {
        table.addCell("Прізвище");
        table.addCell(resultList.get(0));
        table.addCell("Ім'я");
        table.addCell(resultList.get(1));
        table.addCell("По-батькові");
        table.addCell(resultList.get(2));
        table.addCell("Варіант ЮРА");
        table.addCell(resultList.get(3));
        table.addCell("Стать");
        table.addCell(resultList.get(4));
        switch(resultList.size()) {
            case 10:
                table.addCell("Приймання ГК");
                table.addCell(resultList.get(5));
                table.addCell("3DMARD");
                table.addCell(resultList.get(6));
                table.addCell("Кумулятивна доза DMARDS");
                table.addCell(resultList.get(7));
                break;
            case 12:
                table.addCell("Постійна доза преднізолону");
                table.addCell(resultList.get(5));
                table.addCell("Приймання ГК");
                table.addCell(resultList.get(6));
                table.addCell("ІБТ");
                table.addCell(resultList.get(7));
                table.addCell("1DMARD + ІБТ");
                table.addCell(resultList.get(8));
                table.addCell("Кумулятивна доза DMARDS");
                table.addCell(resultList.get(9));
                break;
            default:
                table.addCell("Кумулятивна доза ГК");
                table.addCell(resultList.get(0));
                table.addCell("ІБТ");
                table.addCell(resultList.get(1));
                table.addCell("Інтенсифік терап");
                table.addCell(resultList.get(2));
                table.addCell("1DMARD + НПЗП");
                table.addCell(resultList.get(3));
                table.addCell("2DMARD");
                table.addCell(resultList.get(4));
                table.addCell("2DMARD + ІБТ");
                table.addCell(resultList.get(3));
                table.addCell(">3DMARD/>2ІБТ");
                table.addCell(resultList.get(4));
                break;
        }
        table.addCell("JADI-A");
        table.addCell(resultList.get(resultList.size()-2));
        table.addCell("JADI-E");
        table.addCell(resultList.get(resultList.size()-1));
    }
}
