package com.javahash.spring.controller.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.javahash.spring.model.Employee;
import com.javahash.spring.service.IEmployeesService;
import com.javahash.spring.util.IterableUtils;
import com.javahash.spring.util.RestPreconditions;

@Controller
@Path("/employees")
public class EmployeesController {
	
	@Autowired
	public IEmployeesService employeeService;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create( Employee resource ){
		System.out.println(resource + " init");
		RestPreconditions.checkNotNull( resource );
		employeeService.create(resource);
		System.out.println(" resource created");
		return Response.status(200).entity(resource).build();		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll(@QueryParam("name") final String name){
		System.out.println("findAllEmployee init");
		Integer responseStatus = 200;
		Iterable<Employee> findAllResult = null;
		if(name == null){
			findAllResult = employeeService.findAll();
			System.out.println("findAllEmployee ended");
		}
		else{
			findAllResult = employeeService.findEmployeeByName(name);
		}
		
		if(findAllResult != null && IterableUtils.size(findAllResult) < 1){
			//no hay resultados en la busqueda
			responseStatus = 204;
		}
		
		return Response.status(responseStatus).entity(findAllResult).build();
	}
	
	@GET
	@Path("/{employeeId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployee(@PathParam("employeeId") final String employeeId) {
		Employee employee = (Employee) employeeService.findEmployeeById(employeeId);
		return Response.status(200).entity(employee).build();
	}
	
	@DELETE
	@Path("/{employeeId}")
	public Response deleteEmployee(@PathParam("employeeId") String employeeId) {
		employeeService.delete(employeeId);
		String output = "DELETE: " + employeeId;
		return Response.status(204).entity(output).build();
	}
	
}

