/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CreatePdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import InputInfo.PersonalInfo;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Image;
import java.io.IOException;
/**
 *
 * @author Dhruv
 */
public class CreatePdf extends PersonalInfo {
    
    public void makePdf() {
        try {
            Document doc = new Document();
            try {
                try {
                    PdfWriter.getInstance(doc, new FileOutputStream(f_name+".pdf"));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(CreatePdf.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (DocumentException ex) {
                Logger.getLogger(CreatePdf.class.getName()).log(Level.SEVERE, null, ex);
            }
            doc.open();
            Image image = null;
            try {
                image = Image.getInstance(new URL("file:///" + picture.getPath()));
                System.out.println(picture);
            } catch (BadElementException ex) {
                Logger.getLogger(CreatePdf.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CreatePdf.class.getName()).log(Level.SEVERE, null, ex);
            }
            image.scalePercent(25);
            image.setAlignment(Image.ALIGN_RIGHT);
            doc.add(image);
            doc.add(new Paragraph(f_name + " " + l_name));
            doc.add(new Paragraph(addr));
            doc.add(new Paragraph(e_mail));
            doc.add(new Paragraph(birthday));
            doc.add(new Paragraph(Long.toString(contact)));
            doc.add(new Paragraph(obj));
            doc.close();
        } catch (DocumentException ex) {
            Logger.getLogger(CreatePdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
