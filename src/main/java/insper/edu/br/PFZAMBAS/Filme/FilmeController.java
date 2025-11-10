package insper.edu.br.PFZAMBAS.Filme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping
    public List<Filme> getFilmes() {
        return filmeService.getFilmes();
    }

    @PostMapping
    public Filme createFilme(@RequestBody Filme filme) {
        return filmeService.createFilme(filme);
    }

    @GetMapping("/{id}")
    public Filme getFilme(@PathVariable Integer id) {
        return filmeService.getFilme(id);
    }

    // Somente administradores podem excluir
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteFilme(@PathVariable Integer id) {
        filmeService.deleteFilme(id);
    }
}
