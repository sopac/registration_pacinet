/**
 * Created with IntelliJ IDEA.
 * User: sachin
 * Date: 5/21/12
 * Time: 11:07 AM
 * To change this template use File | Settings | File Templates.
 */

package org.sopac;


import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.hibernate.Session;
import org.sopac.domain.Registration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ExportServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

    }


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        try {
            File excel = new File("/tmp/ppdrm.prwsc.registration.xls");
            if (excel.exists()) excel.delete();

            Workbook wb = new HSSFWorkbook();
            FileOutputStream fileOut = new FileOutputStream(excel.getAbsolutePath());
            Sheet s = wb.createSheet("2012 PacINET PICISOC Conference");
            Cell cell = null;

            //headers
            Row row = s.createRow((short) 0);
            cell = row.createCell(0);
            cell.setCellValue("2012 PacINET PICISOC Conference");

            row = s.createRow((short) 1);
            cell = row.createCell(0);
            cell.setCellValue(new Date().toString());

            row = s.createRow((short) 2);
            String headers[] = {"Id", "DateRegistered", "Title", "FirstName", "Surname", "Email", "JobTitle", "Organisation", "Affiliation", "Country",
                    "MailingAddress", "Telephone", "Fax", "Nationality", "PassportNo", "DateOfIssue", "PlaceOfIssue", "ExpiryDate", "SpecialDietry",
                    "FirstAccomondationChoice", "SecondAccomodationChoice", "ThirdAccomodationChoice",
                    "Display Table Required", "Posters", "Display Board", "Brochures", "Other", "Other Materials", "Field Trip - First Preference", "Field Trip - Second Preference", "APNIC Workshop 1", "APNIC Workshop 2"};

            int count = 0;
            for (String h : headers) {
                cell = row.createCell(count);
                cell.setCellValue(h);
                count++;
            }

            Session sess = HibernateUtil.getSessionFactory().openSession();
            List res = sess.createQuery("from Registration as r order by r.dateRegistered desc").list();
            for (int i = 0; i < res.size(); i++) {
                Registration r = (Registration) res.get(i);

                row = s.createRow((short) i + 3);
                cell = row.createCell(0);
                cell.setCellValue(r.getId());
                cell = row.createCell(1);
                if (r.getDateRegistered() != null)
                    cell.setCellValue(r.getDateRegistered().toString());
                cell = row.createCell(2);
                cell.setCellValue(r.getTitle());
                cell = row.createCell(3);
                cell.setCellValue(r.getFirstName());
                cell = row.createCell(4);
                cell.setCellValue(r.getSurname());

                cell = row.createCell(5);
                cell.setCellValue(r.getEmail());

                cell = row.createCell(6);
                cell.setCellValue(r.getJobTitle());

                cell = row.createCell(7);
                cell.setCellValue(r.getOrganisationName());

                cell = row.createCell(8);
                cell.setCellValue("");

                cell = row.createCell(9);
                cell.setCellValue(r.getCountry());

                cell = row.createCell(10);
                cell.setCellValue(r.getMailingAddress());

                cell = row.createCell(11);
                cell.setCellValue(r.getTelephone());

                cell = row.createCell(12);
                cell.setCellValue(r.getFax());

                cell = row.createCell(13);
                cell.setCellValue(r.getNationality());

                cell = row.createCell(14);
                cell.setCellValue(r.getPassportNo());

                cell = row.createCell(15);
                if (r.getDateOfIssue() != null)
                    cell.setCellValue(r.getDateOfIssue().toString());

                cell = row.createCell(16);
                cell.setCellValue(r.getPlaceOfIssue());

                cell = row.createCell(17);
                if (r.getExpiryDate() != null)
                    cell.setCellValue(r.getExpiryDate().toString());

                cell = row.createCell(18);
                cell.setCellValue(r.getSpecialMealsRequired());

                cell = row.createCell(19);
                cell.setCellValue(r.getAccomodationFirstChoice());

                cell = row.createCell(20);
                cell.setCellValue("");

                cell = row.createCell(21);
                cell.setCellValue("");

                cell = row.createCell(22);
                cell.setCellValue("");

                cell = row.createCell(23);
                cell.setCellValue("");

                cell = row.createCell(24);
                cell.setCellValue("");

                cell = row.createCell(25);
                cell.setCellValue("");

                cell = row.createCell(26);
                cell.setCellValue("");

                cell = row.createCell(27);
                cell.setCellValue("");

                cell = row.createCell(28);
                String trip1 = "0";
                //if (r.getTripFirstPreference() != null) trip1 = String.valueOf(r.getTripFirstPreference());
                cell.setCellValue(trip1);

                cell = row.createCell(29);
                String trip2 = "0";
                //if (r.getTripSecondPreference() != null) trip2 = String.valueOf(r.getTripSecondPreference());
                cell.setCellValue(trip2);

                cell = row.createCell(30);
                cell.setCellValue(r.isApnicWorkshop1());

                cell = row.createCell(31);
                cell.setCellValue(r.isApnicWorkshop2());

            }
            sess.close();
            wb.write(fileOut);
            fileOut.close();

            //output excel
            byte[] content = IOUtils.toByteArray(new FileInputStream(excel));
            OutputStream out = response.getOutputStream();
            // Set headers
            //response.setContentType(bulletin.contentType)
            response.setContentLength(content.length);
            response.setHeader("Content-disposition", "attachment; filename=ppdrm.prwsc.registration.xls");
            /* By default, Tomcat will set headers on any SSL content to deny
     * caching. This will cause downloads to Internet Explorer to fail. So
     * we override Tomcat's default behavior here. */
            response.setHeader("Pragma", "");
            response.setHeader("Cache-Control", "private");
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.MINUTE, 5);
            response.setDateHeader("Expires", cal.getTimeInMillis());
            // Write the file content
            out.write(content);
            response.getOutputStream().flush();
            ;
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
