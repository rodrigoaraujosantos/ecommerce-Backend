package org.soulcodeacademy.Ecommerce.controller;

import com.lowagie.text.DocumentException;
import org.soulcodeacademy.Ecommerce.domain.Pedido;
import org.soulcodeacademy.Ecommerce.domain.dto.PedidoDTO;
import org.soulcodeacademy.Ecommerce.services.PedidoService;
import org.soulcodeacademy.Ecommerce.util.PDFGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/pedidos/export/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());


        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<Pedido> chamadoList = pedidoService.listarTodos();

        PDFGenerator exporter = new PDFGenerator(chamadoList);
        exporter.export(response);
    }

    @GetMapping("/meus/pedidos/{email}")
    public List<Pedido>listarMeusPedidos(@PathVariable String email){
        return this.pedidoService.buscarMinhascompras(email);
    }
    @GetMapping("/pedidos")
    public List<Pedido>listarTodosOsPedidos(){
        return this.pedidoService.listarTodos();
    }

    @GetMapping("/pedidos/{id}")
    public Pedido getPedido(@PathVariable Integer id){
       return this.pedidoService.getPedido(id);
   }

   @PutMapping("/pedido/status/{id}")
   public Pedido atualizarStatus(@PathVariable Integer id, @RequestBody PedidoDTO dto){
        return this.pedidoService.atualizarStatus(id, dto);
   }
    @PostMapping("/pedido/newPedido")
    public Pedido novoPedido(@RequestBody PedidoDTO dto){
       return this.pedidoService.novoPedido(dto);
    }

   @DeleteMapping("/pedidos/{idPedidos}")
    public void deletar(@PathVariable Integer idPedidos){
       this.pedidoService.deletar(idPedidos);
   }
}
