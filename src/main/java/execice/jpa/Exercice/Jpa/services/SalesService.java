package execice.jpa.Exercice.Jpa.services;

import execice.jpa.Exercice.Jpa.controllers.payloads.StaffPayload;
import execice.jpa.Exercice.Jpa.controllers.payloads.StorePayload;
import execice.jpa.Exercice.Jpa.controllers.productionDTO.CategorySalesDTO;
import execice.jpa.Exercice.Jpa.controllers.productionDTO.ProductMapper;
import execice.jpa.Exercice.Jpa.controllers.productionDTO.ProductSalesDTO;
import execice.jpa.Exercice.Jpa.controllers.salesDTO.*;
import execice.jpa.Exercice.Jpa.repo.production.categories.Category;
import execice.jpa.Exercice.Jpa.repo.production.products.Product;
import execice.jpa.Exercice.Jpa.repo.sales.customers.Customer;
import execice.jpa.Exercice.Jpa.repo.sales.customers.CustomersRepo;
import execice.jpa.Exercice.Jpa.repo.sales.orderItems.OrderItemsRepo;
import execice.jpa.Exercice.Jpa.repo.sales.orders.Order;
import execice.jpa.Exercice.Jpa.repo.sales.orders.OrdersRepo;
import execice.jpa.Exercice.Jpa.repo.sales.staffs.Staff;
import execice.jpa.Exercice.Jpa.repo.sales.staffs.StaffRepo;
import execice.jpa.Exercice.Jpa.repo.sales.stores.Store;
import execice.jpa.Exercice.Jpa.repo.sales.stores.StoreRepo;
import execice.jpa.Exercice.Jpa.services.IServices.ICustomerService;
import execice.jpa.Exercice.Jpa.services.IServices.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class SalesService implements ICustomerService, IStaffService {

    @Autowired
    private CustomersRepo customersRepo;
    @Autowired
    private StaffRepo staffRepo;
    @Autowired
    private StoreRepo storeRepo;
    @Autowired
    private OrderItemsRepo orderItemsRepo;
    @Autowired
    private OrdersRepo orderRepo;

    private final CustomerMapper customerMapper = CustomerMapper.INSTANCE;
    private  final StaffMapper staffMapper = StaffMapper.INSTANCE;
    private  final StoreMapper storeMapper= StoreMapper.INSTANCE;
    private final ProductMapper productMapper = ProductMapper.INSTANCE;



    //Gestion des Customers
    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.toEntity(customerDTO);
        customer = customersRepo.save(customer);
        return customerMapper.toDTO(customer);
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        Customer customer = customersRepo.findByCustomerId(customerId);
        return customerMapper.toDTO(customer);
    }

    @Override
    public List<CustomerDTO> getAllCustomers(String city, String zipCode) {
        List<Customer> customers;
        if (city != null && zipCode != null) {
            customers = customersRepo.findByCityAndZipCode(city, zipCode);
        } else if (city != null) {
            customers = customersRepo.findByCity(city);
        } else if (zipCode != null) {
            customers = customersRepo.findByZipCode(zipCode);
        } else {
            customers = customersRepo.findAll();
        }

        return customers.stream()
                .map(customerMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO updateCustomer(int customerId, CustomerDTO customerDTO) {


        Customer customer = customersRepo.findByCustomerId(customerId);

        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        customer.setEmail(customerDTO.getEmail());
        customer.setStreet(customerDTO.getStreet());
        customer.setCity(customerDTO.getCity());
        customer.setState(customerDTO.getState());
        customer.setZipCode(customerDTO.getZipCode());

        customer = customersRepo.save(customer);

        return customerMapper.toDTO(customer);
    }

    @Override
    public void deleteCustomer(int customerId) {
        Customer customer = customersRepo.findByCustomerId(customerId);
        customersRepo.delete(customer);

    }

//Gestion des Staffs
    @Override
    public StaffDTO createStaff(StaffPayload payload) {
        Staff manager = staffRepo.findByStaffId(payload.getManagerId());
        Store store = storeRepo.findByStoreId(payload.getStoreId());
        Staff staff = staffMapper.toEntity(payload);
        staff.setStaff(manager);
        staff.setStore(store);
        staff = staffRepo.save(staff);
        return  staffMapper.toDTO(staff);
    }

    @Override
    public StaffDTO getStaffById(int customerId) {
        Staff staff = staffRepo.findByStaffId(customerId);
        return staffMapper.toDTO(staff);
    }

    @Override
    public List<StaffDTO> getAllStaff() {
        List<Staff> staffs = staffRepo.findAll();
                return staffs.stream()
                        .map(staffMapper::toDTO)
                        .collect(Collectors.toList());

    }

    @Override
    public StaffDTO updateStaff(int staffId, StaffDTO staffDTO) {

        Staff staff = staffRepo.findByStaffId(staffId);
        staff.setStaffId(staffDTO.getStaffId());
        staff.setFirstName(staffDTO.getFirstName());
        staff.setLastName(staffDTO.getLastName());
        staff.setEmail(staffDTO.getEmail());
        staff.setPhone(staffDTO.getPhone());
        staff.setActive(staffDTO.isActive());
        staff.setStore(staffDTO.getStore());
        staff.setStaff(staffDTO.getStaff());
        staff = staffRepo.save(staff);
        return  staffMapper.toDTO(staff);

    }

    @Override
    public void deleteStaff(int staffId) {

        Staff staff = staffRepo.findByStaffId(staffId);
        staffRepo.delete(staff);

    }

    @Override
    public StaffDTO assignManager(StaffPayload payload) {

        Staff manager = staffRepo.findByStaffId(payload.getManagerId());
        Staff staff = staffMapper.toEntity(payload);
        staff.setStaff(manager);
        staff = staffRepo.save(staff);
        return staffMapper.toDTO(staff);
    }

    //Gestion de Magasin
    public StoreDTO CreateStore(StorePayload payload){
        Store store = storeMapper.toEntity(payload);
        store = storeRepo.save(store);
        return storeMapper.toDTO(store);
    }

    public StoreDTO getStoreById(int id){
        Store store = storeRepo.findByStoreId(id);
        return  storeMapper.toDTO(store);
    }

    public List<StoreDTO> getAllStore(){
        List<Store> stores = storeRepo.findAll();
        return stores.stream()
                .map(storeMapper::toDTO)
                .collect(Collectors.toList());
    }


    public StoreDTO updateStore(int storeId, StorePayload payload) {

        Store store = storeRepo.findByStoreId(storeId);
        store.setStoreName(payload.getStoreName());
        store.setPhone(payload.getPhone());
        store.setEmail(payload.getEmail());
        store.setStreet(payload.getStreet());
        store.setCity(payload.getCity());
        store.setState(payload.getState());
        store.setZipCode(payload.getZipCode());
        store = storeRepo.save(store);
        return storeMapper.toDTO(store);
    }

    public void deleteStore(int storeId){
        Store store = storeRepo.findByStoreId(storeId);
        storeRepo.delete(store);
    }

    //Gestion de statistics

    public List<ProductSalesDTO> getTopSellingProducts() {
        List<Object[]> results = orderItemsRepo.findTopSellingProducts();
        return results.stream()
                .map(result -> new ProductSalesDTO(((Product) result[0]), (int) result[1]))
                .collect(Collectors.toList());
    }

    public List<CategorySalesDTO> getTopSellingCategories() {
        List<Object[]> results = orderItemsRepo.findTopSellingCategories();
        return results.stream()
                .map(result -> new CategorySalesDTO((Category) result[0], (int) result[1]))
                .collect(Collectors.toList());
    }

    //Gestion des Orders




}
