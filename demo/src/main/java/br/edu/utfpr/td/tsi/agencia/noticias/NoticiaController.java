package br.edu.utfpr.td.tsi.agencia.noticias;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // <--- ESSENCIAL
public class NoticiaController {

    @GetMapping("/") // <--- Define o endereço http://localhost:8080/
    public String index() {
        return "Index"; // <--- Nome do arquivo HTML (sem o .html)
    }
    @GetMapping ("/noticias") // <--- Define o endereço http://localhost:8080/noticias
    public String noticias() {
        return "Noticias"; // <--- Nome do arquivo HTML (sem o .html)   
     }
     @GetMapping ("/Seg/index") // <--- Define o endereço http://localhost:8080/Seg/index
     public String SegIndex() {
        return "Seg/index"; // <--- Nome do arquivo HTML (sem o .html)  
         }
    @GetMapping("/Seg/ExeSeg/painel")
    public String ExeSegPainel() {
        return "Seg/ExeSeg/painel"; // <--- Nome do arquivo HTML (sem o .html)  
    }
}

