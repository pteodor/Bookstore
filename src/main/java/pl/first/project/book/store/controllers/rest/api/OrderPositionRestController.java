package pl.first.project.book.store.controllers.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.first.project.book.store.database.IOrderPositionDAO;
import pl.first.project.book.store.model.OrderPosition;
import pl.first.project.book.store.model.dto.OrderPositionDTO;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/orderPosition")
public class OrderPositionRestController {

    @Autowired
    IOrderPositionDAO orderPositionDAO;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<OrderPositionDTO> getOrderPositionById(@PathVariable int id) {
        Optional<OrderPosition> orderPositionBox = this.orderPositionDAO.getOrderPositionById(id);
        if(orderPositionBox.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(new OrderPositionDTO(orderPositionBox.get()));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
