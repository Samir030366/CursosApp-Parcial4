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
import com.sv.cursosApp.service.ICategoriaService;

@Controller
public class CategoriaController {

    @Autowired
    private ICategoriaService categoriaService;

    // Mostrar todas las categorías
    @GetMapping("/categorias")
    public String mostrarTodas(Model model) {
        List<Categoria> lista = categoriaService.buscarTodos();
        model.addAttribute("categorias", lista);
        return "categoria/list";
    }

    // Mostrar formulario para crear nueva categoría
    @GetMapping("/categorias/nueva")
    public String mostrarFormularioNueva(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categoria/form";
    }

    // Guardar categoría (Crear o Modificar)
    @PostMapping("/categorias/guardar")
    public String guardar(@ModelAttribute Categoria categoria, RedirectAttributes flash) {
        categoriaService.guardar(categoria);
        flash.addFlashAttribute("msg", "Categoría guardada correctamente");
        return "redirect:/categorias";
    }

    // Mostrar formulario para editar
    @GetMapping("/categorias/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Categoria categoria = categoriaService.buscarPorId(id);
        model.addAttribute("categoria", categoria);
        return "categoria/form";
    }

    // Eliminar categoría
    @GetMapping("/categorias/eliminar/{id}")
    public String eliminar(@PathVariable Integer id, RedirectAttributes flash) {
        categoriaService.eliminar(id);
        flash.addFlashAttribute("msg", "Categoría eliminada correctamente");
        return "redirect:/categorias";
    }
}