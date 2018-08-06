package com.customerapi.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.customerapi.model.Customer;
import com.customerapi.service.CustomerService;

@Path("/customers")
public class CustomerEndpoint {
	
	@Autowired
	private CustomerService customerService;
	
	@GET
	@Produces("application/json")
	public Response getAllCustomers()
	{
		return Response.status(200).entity(customerService.getAllCustomers()).build();
	}
	
	@GET
	@Path("/{customerId}")
	@Produces("application/json")
	public Response getCustomerById(@PathParam("customerId") Integer customerId)
	{
		Customer customer = customerService.getCustomerById(customerId);
		
		if(customer == null)
		{
		  Response.status(404).build();
		}
		
		return Response.status(200).entity(customer).build();
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response createCustomer(Customer customer)
	{
		if(customer.getCustomerId() == null)
		{
			return Response.status(400).entity("Please provide valid input").build();
		}
		customerService.addCustomer(customer);
		
		return Response.status(201).build();
	}
	
	@PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateCustomer(Customer customer)
    {
       Customer temp = customerService.getCustomerById(customer.getCustomerId());
        if(temp == null) {
            return Response.status(404).build();
        }
        
        temp.setCustomerAge(customer.getCustomerAge());
        temp.setCustomerName(customer.getCustomerName());
        customerService.updateCustomer(temp);
        return Response.status(200).entity(temp).build();
    }
 
    @DELETE
    @Path("/{customerId}")
    public Response deleteUser(@PathParam("customerID") Integer customerId){
        Customer customer = customerService.getCustomerById(customerId);
        if(customer != null) {
            customerService.deleteCustomer(customerId);
            return Response.status(200).build();
        }
        return Response.status(404).build();
    }
	
	
	
	

}
