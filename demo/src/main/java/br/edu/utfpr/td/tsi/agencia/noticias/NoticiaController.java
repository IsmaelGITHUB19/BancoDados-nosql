package br.edu.utfpr.td.tsi.agencia.noticias;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // <--- ESSENCIAL
public class NoticiaController {
    private List<Noticia> noticias = new ArrayList<>();

    @GetMapping("/cadastrar") // <--- ESSENCIAL
    public String cadastra(Model model) {
        model.addAttribute("noticia", new Noticia()); // <--- ESSENCIAL
        if (noticias.isEmpty()) {
            System.out.println("Nenhuma notícia cadastrada.");
        } else {
            System.out.println("Notícias cadastradas:");
            for (Noticia noticia : noticias) {
                System.out
                        .println("- " + noticia.getAutor() + " - " + noticia.getAssunto() + " - " + noticia.getEmail());
            }
        }
        return "Atv/index"; // nome do arquivo HTML (sem extensão)
    }

    @PostMapping("/salvar") // <--- ESSENCIAL
    public String salvar(Noticia noticia) {
        noticias.add(noticia);
        System.out.println("Notícia cadastrada: " + noticia.getAutor());
        return "redirect:/cadastrar"; // redireciona para a página de cadastro
    }

    @GetMapping("/limpar") // <--- ESSENCIAL
    public String limpar() {
        noticias.clear();
        System.out.println("Lista de notícias limpa.");
        return "redirect:/cadastrar"; // redireciona para a página de cadastro
    }

    @GetMapping("/imprimir")
    public String imprimir(Model model) {
        model.addAttribute("noticias", noticias);
        return "Atv/Result/painel";
    }

    @GetMapping("/Excluir")
    public String excluir(Noticia noticia) {
        // Procura na lista alguém com o mesmo autor e assunto e remove
        noticias.removeIf(n -> n.getId().equals(noticia.getId()) &&
                n.getAssunto().equals(noticia.getAssunto()));

        System.out.println("Notícia excluída: " + noticia.getId());
        return "redirect:/imprimir";
    }

    @GetMapping("/Editar")
public String editar(@RequestParam("id") String id, Model model) {
    // Busca a notícia e adiciona ao model se encontrar
    noticias.stream()
            .filter(n -> n.getId().equals(id))
            .findFirst()
            .ifPresent(n -> model.addAttribute("noticia", n));

    return "Atv/Result/editar";
}

    @PostMapping("/SalvarEdicao")
    public String salvarEdicao(Noticia noticiaEditada) {
        // Remove a antiga e adiciona a nova (jeito mais rápido de "editar" na memória)
        noticias.removeIf(n -> n.getId().equals(noticiaEditada.getId()));
        noticias.add(noticiaEditada);

        return "redirect:/imprimir";
    }   

}
