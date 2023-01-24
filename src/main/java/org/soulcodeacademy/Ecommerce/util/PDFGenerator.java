package org.soulcodeacademy.Ecommerce.util;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.soulcodeacademy.Ecommerce.domain.Pedido;


import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;
public class PDFGenerator {
    //Precisamos listar os chamados
    private List<Pedido> listaPedido;

    public PDFGenerator(List<Pedido> listaPedidos){
        this.listaPedido = listaPedidos;
    }

    private void writeTableHeader(PdfPTable table){
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.gray);
        cell.setPadding(4);


        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setColor(Color.WHITE);
        fontTitle.setSize(11);


        cell.setPhrase(new Phrase("Id", fontTitle));
        table.addCell(cell);

        cell.setPhrase(new Phrase("valorTotal", fontTitle));
        table.addCell(cell);

        cell.setPhrase(new Phrase("cliente", fontTitle));
        table.addCell(cell);

        cell.setPhrase(new Phrase("data Da Compra", fontTitle));
        table.addCell(cell);

        cell.setPhrase(new Phrase("status", fontTitle));
        table.addCell(cell);





    }
    private  void writeTableData(PdfPTable table){
        for (Pedido pedido : listaPedido){
            table.addCell(String.valueOf(pedido.getIdPedido()));
            table.addCell(String.valueOf(pedido.getValorTotal()));
            table.addCell(String.valueOf(pedido.getCliente().getNome()));
            table.addCell(String.valueOf(pedido.getDataDaCompra()));
            table.addCell(String.valueOf(pedido.getStatus()));



        }
    }

    public  void export(HttpServletResponse response)throws  DocumentException, IOException{
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document,response.getOutputStream());

        document.open();

        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(24);
        font.setColor(Color.BLACK);


        Paragraph p = new Paragraph("Relatório mensal de Pedido", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.3f, 4.5f, 4.5f, 4.5f, 4.5f});
        table.setSpacingBefore(3);


        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();
    }
}
