package pl.first.project.book.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.first.project.book.store.model.OrderPosition;
import pl.first.project.book.store.services.IAuthenticationService;
import pl.first.project.book.store.services.IBasketService;
import pl.first.project.book.store.session.SessionObject;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/basket")
public class BasketController {

    @Autowired
    IBasketService basketService;

    @Autowired
    IAuthenticationService authenticationService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
    public String addBookToBasket(@PathVariable int id) {
        if(!this.sessionObject.isLogged()) {
            return "redirect:/main";
        }
        this.basketService.addBookToBasket(id);
        return "redirect:/main";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String basket(Model model) {
        if(!this.sessionObject.isLogged()) {
            return "redirect:/main";
        }
        this.authenticationService.addCommonInfoToModel(model);
        model.addAttribute("basket", this.sessionObject.getBasket());
        model.addAttribute("basketSum", this.basketService.calculateBasketSum());
        return "basket";
    }

}
