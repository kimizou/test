package kimi.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kimi.domain.Test;
import kimi.service.IndexService;

@Controller
public class IndexController {
	@Autowired
	private IndexService indexService;
	
	@RequestMapping(value = "/")
	public ModelAndView home() {
		List<Test> tests = indexService.findAll();
		return new ModelAndView("index", "tests", tests);
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody String handleFileUpload(@RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File("E:\\eclipse-jee-mars-R-win32-x86_64\\eclipse\\1.xlsx")));
				stream.write(bytes);
				stream.close();
				return "bbbb";
			} catch (Exception e) {
				return e.getMessage();
			}
		} else {
			return "aaaa";
		}
	}
	
}
