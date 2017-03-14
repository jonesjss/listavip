package br.com.alura.listavip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.alura.listavip.models.Convidado;
import br.com.alura.listavip.repositorys.ConvidadoRepository;

@Controller
public class ConvidadoController {
	
	@Autowired
	private ConvidadoRepository repository;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("listaconvidados")
	public String listaConvidados(Model model) {
		Iterable<Convidado> convidados = repository.findAll();
	    model.addAttribute("convidados", convidados);
	    
	    return "listaconvidados";
	}

	@RequestMapping(value="salvar", method=RequestMethod.POST)
	public ModelAndView salvar(Convidado convidado) {
		ModelAndView modelAndView = new ModelAndView("redirect:listaconvidados");
		
		repository.save(convidado);
		return modelAndView;
	}
}
