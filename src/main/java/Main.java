import model.*;
import repository.*;
import service.impl.*;

import java.time.Month;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CompanyServiceImpl companyService = new CompanyServiceImpl(new CompanyRepository());
        Company mediamarkt = companyService.create("Mediamarkt", Sector.TECHNOLOGY);
        Company carrefoursa = companyService.create("CarrefourSA", Sector.FOOD);
        Company boyner = companyService.create("Boyner", Sector.CLOTHING);

        BrandServiceImpl brandService = new BrandServiceImpl(new BrandRepository());
        Brand apple = brandService.create("Apple", mediamarkt);
        Brand samsung = brandService.create("Samsung", mediamarkt);
        Brand ulker = brandService.create("Ülker", carrefoursa);
        Brand nestle = brandService.create("Nestle", carrefoursa);
        Brand mavi = brandService.create("Mavi", boyner);

        CustomerServiceImpl customerService = new CustomerServiceImpl(new CustomerRepository());
        Customer burak = customerService.create("Burak", "YAPICI", "burakyapici747@gmail.com", "05423224232");
        Customer ayse = customerService.create("Ayşe", "YILMAZ", "ayseyilmaz@gmail.com", "05456454232");
        Customer cem = customerService.create("Cem", "ŞENTÜRK", "cem@gmail.com", "05644544312");

        ProductServiceImpl productService = new ProductServiceImpl(new ProductRepository());
        Product macbook = productService.create("Macbook air m1", 17999.0, apple);
        Product iphone12 = productService.create("Iphone12", 15999.0, apple);
        Product galaxyS9 = productService.create("GalaxyS9", 13000.0, samsung);
        Product galaxys8 = productService.create("Galaxys8", 12000.0, samsung);
        Product chocolata = productService.create("Sütlü Çikolata", 7.0, ulker);
        Product nestleDamakChocolata = productService.create("Damak Sütlü Çikolata", 12.0, nestle);
        Product trouser = productService.create("Pantolon", 399.0, mavi);

        OrderServiceImpl orderService = new OrderServiceImpl(new OrderRepository());
        Order appleOrder = orderService.create("Apple order", List.of(macbook, iphone12), burak);
        Order samsungOrder = orderService.create("Samsung order", List.of(galaxyS9, galaxys8), ayse);
        Order maviOrder = orderService.create("Mavi order", List.of(trouser), cem);

        BillServiceImpl billService = new BillServiceImpl(new BillRepository());
        billService.create("Apple bill", appleOrder);
        billService.create("Samsung bill", samsungOrder);
        billService.create("Mavi bill", maviOrder);

        System.out.println("__________________________________________________________________");

        System.out.println("ALL OF CUSTOMERS");
        customerService.getAll().forEach(System.out::println);

        System.out.println("__________________________________________________________________");

        System.out.println("Customers that are containing 'C' letter in their name.");
        customerService.getCustomersWithCharacter('C').forEach(System.out::println);

        System.out.println("__________________________________________________________________");

        System.out.println("The total price of bills for customers who registered in June.");
        System.out.println(customerService.getAllByMonthCustomers(Month.JUNE.getValue()).stream()
                .mapToDouble(billService::getTotalPriceByCustomer)
                .sum());

        System.out.println("__________________________________________________________________");

        System.out.println("ALL OF BILLS");
        billService.getAll().forEach(System.out::println);

        System.out.println("__________________________________________________________________");

        System.out.println("Bills of Bigger than 1500 TL");
        billService.getAllBiggerThanByValue(1500.0)
                .forEach(System.out::println);

        System.out.println("__________________________________________________________________");

        System.out.println("Total average of bill which is bigger than 1500 TL");
        System.out.println(billService.calculateAverageOfBiggerThanByValue(1500.0));

        System.out.println("__________________________________________________________________");

        System.out.println("Customer names of that have bill which is smaller than 500 TL");
        billService.getAllSmallerThanByValue(500.0).stream()
                .map(bill -> bill.getOrder().getCustomer().getName())
                .forEach(System.out::println);

        System.out.println("__________________________________________________________________");

        System.out.println("Company sectors that have average price smaller than 750 TL in June");
        companyService.getAll().stream()
                .filter(company ->
                        billService.checkIfCompanyBillsAverageSmallerThanValueInGivenMonth(company, 750, Month.JUNE.getValue()))
                .map(company -> company.getSector())
                .distinct()
                .forEach(System.out::println);
        System.out.println("__________________________________________________________________");


    }
}
