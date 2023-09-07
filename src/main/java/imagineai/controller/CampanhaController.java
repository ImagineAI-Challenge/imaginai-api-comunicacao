package imagineai.controller;

import imagineai.model.Campanha;
import imagineai.service.CampanhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/campanhas")
public class CampanhaController extends BaseController<Campanha, String> {
    @Autowired
    public CampanhaController(CampanhaService campanhaService) {
        super(campanhaService);
    }
}
