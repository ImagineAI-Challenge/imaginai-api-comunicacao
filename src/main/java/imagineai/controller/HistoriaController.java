package imagineai.controller;

import imagineai.model.Historia;
import imagineai.service.HistoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/historias")
public class HistoriaController extends BaseController<Historia, String> {
    @Autowired
    public HistoriaController(HistoriaService historiaService) {
        super(historiaService);
    }
}
