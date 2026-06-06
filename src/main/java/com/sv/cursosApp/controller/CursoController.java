package com.sv.cursosApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sv.cursosApp.model.Categoria;
import com.sv.cursosApp.model.Curso;
import com.sv.cursosApp.service.ICategoriaService;
import com.sv.cursosApp.service.ICursoService;

@Controller
public class CursoController {

    @Autowired
    private ICursoService cursoService;

    @Autowired
    private ICategoriaService categoriaService;

    // Listar todos los cursos
    @GetMapping("/cursos")
    public String mostrarTodos(Model model) {
        List<Curso> lista = cursoService.buscarTodos();
        model.addAttribute("cursos", lista);
        return "curso/list";
    }

    // Formulario para crear nuevo curso
    @GetMapping("/cursos/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        List<Categoria> categorias = categoriaService.buscarTodos();
        model.addAttribute("curso", new Curso());
        model.addAttribute("categorias", categorias);
        return "curso/form";
    }

    // Guardar curso
    @PostMapping("/cursos/guardar")
    public String guardar(@ModelAttribute Curso curso, RedirectAttributes flash) {
        cursoService.guardar(curso);
        flash.addFlashAttribute("msg", "Curso guardado correctamente");
        return "redirect:/cursos";
    }

    // Editar curso
    @GetMapping("/cursos/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Curso curso = cursoService.buscarPorId(id);
        List<Categoria> categorias = categoriaService.buscarTodos();
        model.addAttribute("curso", curso);
        model.addAttribute("categorias", categorias);
        return "curso/form";
    }

    // Eliminar curso
    @GetMapping("/cursos/eliminar/{id}")
    public String eliminar(@PathVariable Integer id, RedirectAttributes flash) {
        cursoService.eliminar(id);
        flash.addFlashAttribute("msg", "Curso eliminado correctamente");
        return "redirect:/cursos";
    }
}