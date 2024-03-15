package jp.ac.ohara.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.micrometer.common.lang.NonNull;
import jp.ac.ohara.schedule.model.AllScheduleBook;
import jp.ac.ohara.schedule.model.UserBook;
import jp.ac.ohara.schedule.service.AllScheduleBookService;

@Controller
public class AllScheduleBookController {
	@Autowired
	private AllScheduleBookService allScheduleBookService;

	@GetMapping("/home/")
	public String index(Model model, @AuthenticationPrincipal UserBook userBook) {
		// TODO: model.addAttributeに一覧取得結果を追加
		model.addAttribute("list", this.allScheduleBookService.getAllScheduleList(userBook));
		return "top";
	}

	@GetMapping("/add/")
	public ModelAndView add(AllScheduleBook allScheduleBook, ModelAndView model) {
		model.addObject("allScheduleBook", allScheduleBook);
		model.setViewName("form");
		return model;
	}
 
	@PostMapping("/add/")
	public String add(@Validated @ModelAttribute @NonNull AllScheduleBook allScheduleBook, RedirectAttributes result, ModelAndView model,
			RedirectAttributes redirectAttributes) {
		try {
			this.allScheduleBookService.save(allScheduleBook);
			redirectAttributes.addFlashAttribute("exception", "");
 
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("exception", e.getMessage());
		}
		return "redirect:/home/";
	}

	@GetMapping("/detail/{id}")
	public ModelAndView detail(@PathVariable(name = "id") Long id, AllScheduleBook allScheduleBook, ModelAndView model) {
		model.addObject("detaillist", this.allScheduleBookService.get(id));
		model.setViewName("detail");
		return model;
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable(name = "id") Long id, AllScheduleBook allScheduleBook, ModelAndView model) {
		this.allScheduleBookService.delete(id);
		model.setViewName("delete");
		return model;
	}

}