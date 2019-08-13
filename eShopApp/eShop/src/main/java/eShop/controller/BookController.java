package eShop.controller;


import eShop.email.EmailCfg;
import eShop.model.DeliveryRequest;
import eShop.repository.BookRepository;
import eShop.model.Book;
import eShop.service.AuthorService;
import eShop.service.BookService;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;


@Controller
public class BookController {



    @Autowired
    AuthorService authorService;

    @Autowired
    private BookService bookService;

    @Autowired
    private  DeliveryRequestController deliveryRequestController;


    @GetMapping(value = {"book/"})
    public String home() {
        return "book/index";
    }

    // SEARCH Use-Case
    @GetMapping(value = { "eshop/book/search" })
    public ModelAndView searchStudent(@RequestParam String search, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("books", bookService.getAllBooksQuickSearch(search));
        modelAndView.setViewName("book/list1");
        return modelAndView;
    }

    // Actually Register a Book
    @PostMapping(value = "/registerBook")
    public String registerNewBook(
            @Valid
            @ModelAttribute("book")
                    Book book,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "Book/new";
        }
        Book savedBook = bookService.saveBook(book);

       // EmailCfg emailCfg = new EmailCfg();
        DeliveryRequest deliveryRequest = new DeliveryRequest();
        deliveryRequest.setEmail("ouremail@email.com");
        deliveryRequest.setName("supplier");
        deliveryRequest.setRequestContent("The Book" + savedBook.getTitle() );




        deliveryRequestController.sendDeliveryRequest(deliveryRequest);
        return "redirect:/listBook";
    }

    @GetMapping(value = { "/listBook" })
    public ModelAndView showAllBooks( @Valid
                                          @ModelAttribute("book")
                                                  Book book,
                                      BindingResult bindingResult,
                                      Model model) {
        ModelAndView modelAndView = new ModelAndView();
        Iterable<Book> listOfBooks = bookService.getAllBooks();
        modelAndView.addObject("books", bookService.getAllBooks());
        modelAndView.setViewName("book/list1");
        return modelAndView;
    }

    // show Registration Form
    @GetMapping(value={"/showBookForm"})
    public String newCustomerForm(Model model) {
        model.addAttribute("book", new Book());
         model.addAttribute("authors", authorService.getAllAuthors() );
        model.addAttribute("now", LocalDate.now());
        return "book/new";
    }


}
