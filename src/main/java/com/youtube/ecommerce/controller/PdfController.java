package com.youtube.ecommerce.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.youtube.ecommerce.entity.Product;
import com.youtube.ecommerce.entity.ProductInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.io.ByteArrayOutputStream;

@RestController
public class PdfController {

    @PostMapping("/generate-pdf")
    //Error generating PDF: Some thing is wrong
    //i have probleme with methode generatePdf in front end
    //i have to fix it



    public byte[] generatePdf(@RequestBody ProductInfo productInfo) throws DocumentException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, outputStream);
        document.open();

        for (Product product : productInfo.getProducts()) {
            String content = "Product Name: " + product.getProductName() + "\n" +
                    "Price: " + product.getProductDescription() + "\n" +
                    "Total Price: " + product.getProductDiscountedPrice() + "\n" +

                    "Total Price: " + product.getProductDiscountedPrice();
            document.add(new Paragraph(content));
        }

        document.close();
        return outputStream.toByteArray();
    }
}
