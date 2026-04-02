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
   
     @GetMapping("/Aula/index")
     public String indexdois(){
        return "Aula/index";
     }
     @GetMapping("/Aula/Aula/painel")
     public String painel(){
        return "Aula/painel";
     }
     @GetMapping("/Aula/Aula/Under/underfile")
     public String under(){
        return "Aula/Under/underfile";
     }

}
