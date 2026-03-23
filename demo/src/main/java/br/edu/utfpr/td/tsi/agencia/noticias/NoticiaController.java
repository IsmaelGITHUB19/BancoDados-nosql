package br.edu.utfpr.td.tsi.agencia.noticias;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // <--- ESSENCIAL
public class NoticiaController {

    @GetMapping("/") // <--- Define o endereço http://localhost:8080/
    public String index() {
        return "Index"; // <--- Nome do arquivo HTML (sem o .html)
    }
}
