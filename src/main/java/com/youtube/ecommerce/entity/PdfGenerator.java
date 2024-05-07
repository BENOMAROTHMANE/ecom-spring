package com.youtube.ecommerce.entity;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import com.youtube.ecommerce.entity.OrderProductQuantity;
import com.youtube.ecommerce.entity.Product;

public class PdfGenerator {

    public static void generatePdf(List<OrderProductQuantity> orderProductQuantities, List<Product> products, String filename)
            throws DocumentException, FileNotFoundException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        document.open();

        for (int i = 0; i < orderProductQuantities.size(); i++) {
            OrderProductQuantity orderProductQuantity = orderProductQuantities.get(i);
            Product product = products.get(i);
            double totalPrice = orderProductQuantity.getQuantity() * product.getProductDiscountedPrice();

            String content = "Nom du produit : " + product.getProductName() + "\n" +
                    "Prix : " + product.getProductDiscountedPrice() + "\n" +
                    "Prix total : " + totalPrice + "\n\n";

            document.add(new Paragraph(content));
        }

        document.close();
    }
}
