# Spring-Boot-Demo for creating API

# 1) Download Java 8 +

# 2) Setup Java Enviornment in windows

# 3) Download STS 4.3.0

# 4) Download Postman

# 5) Now setup project in STS

# 6) We use Maven instead of STS

# 7) Create Maven project

# 8) After Creating add bellow dependencies , parent & properties in pom.xml

  <parent>
  	<groupId>org.springframework.boot</groupId>
  	<artifactId>spring-boot-starter-parent</artifactId>
  	<version>2.1.4.RELEASE</version>
  </parent>
  
  <dependencies>
  	<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <version>2.1.4.RELEASE</version>
</dependency>
  </dependencies>

# 9) Update Maven Project wait until it download dependancy


# 10) create class in main java with package

	package com.example.springapi;
	import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.SpringBootApplication;
	@SpringBootApplication
	public class SpringApi {
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			SpringApplication.run(SpringApi.class,args);
		}
	}


# 11) create controller in main/java with package

	package com.example.springapi.controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	@RestController

	public class SpringApiController {
		@RequestMapping("/welcome")
		public String welcomeSpringApi() {
			return "Hello Spring ";
		}
		
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		}
	}


# 12) If u want to change port den add application.properties in src/main/resources

server.port=9090 

# 13) Run project by slecting main project which is spring.java

# 14) Done your Startup..........


# 15) we need to create services and interfaces

	- create first create package which is same as controller just change name to service
	- and under this service package create service class name e.g. SpringService
	- create interface name as employeeService into this service package and implement in SpringService
	- we used interface to call the CRUD methods only and this interface called in controller
	- under SpringService class define CRUD functions
	- also give anotation in SpringService class
		@Service
	- lets begin for CRUD e.g.

# 16) Steps Started here
	- 1st need to create main function e.g. springApi follow step 10
   	-2nd need to create controller package follow step 11
    	-3rd begin to step 15.

# 17) CRUD e.g. employee management

	-1st create package name any like detail or objects any
	-2nd under that create class employee under this class having variables and functions which we need in employee management
	e.g. 
	public class employee {
		private int emp_id;
		private String emp_name;
		private String emp_dprt;
	
		public employee(int emp_id, String emp_name, String emp_dprt) {
			super();
			this.emp_id = emp_id;
			this.emp_name = emp_name;
			this.emp_dprt = emp_dprt;
		}
		public int getEmp_id() {
			return emp_id;
		}
		public void setEmp_id(int emp_id) {
			this.emp_id = emp_id;
		}
		public String getEmp_name() {
			return emp_name;
		}
		public void setEmp_name(String emp_name) {
			this.emp_name = emp_name;
		}
		public String getEmp_dprt() {
			return emp_dprt;
		}
		public void setEmp_dprt(String emp_dprt) {
			this.emp_dprt = emp_dprt;
		}

	}

  -3rd create Autowired into controller class need to get all services from employee services to the controller
	e.g. 
		@Autowired
		employeeService empRef;


# 18) Get opertion

   -1) Add  mapping in controller class

	@RequestMapping("/employees")
	public List<employee> getAllEmployee(){
		return empRef.getAllEmployee();
	}

	create method into employeeService interface

   -2) under SpringServices add list first
   
		List<employee> empList =new ArrayList<> (Arrays.asList(
			new employee(1,"Bhushan","Computer Engineer"),
			new employee(2,"Amit","Aggreeculture Engineer"),
			new employee(3,"Pratik","Aggreeculture Engineer")));

   -3) and also add 
    
		@Override
	public List<employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return empList;
	}

# 19) Get by ID

   -1) Add mapping in controller class

	@RequestMapping("/employees/{emp_id}")
	public employee getEmployeeById(@PathVariable int emp_id) {
		return empRef.getEmployeeById(emp_id);
	}

     - @PathVariable is used to send value from employee list
	create method into employeeService interface

   -2) under Spring Services
   
	@Override
	public employee getEmployeeById(int emp_id) {
		// TODO Auto-generated method stub
		return empList.stream().filter(e->e.getEmp_id()== emp_id).findFirst().get();
		// This is lembda expression to find id from the table
	}

# 20) Update by ID

   -1) Add mapping in controller class

	@RequestMapping(method=RequestMethod.PUT, value="/employees/{emp_id}" )
	public void updateEmployee(@RequestBody employee emp, @PathVariable int emp_id) {
		empRef.updateEmployee(emp,emp_id);
	}

     - @PathVariable is used to check value from employee list
     - @RequestBody is used to get and change all the employee data by id
	create method into employeeService interface

   -2) under Spring Services
   
	@Override
	public void updateEmployee(employee emp, int emp_id) {
		int no = empList.size();
		for(int i=1;i<=no;i++) {
			employee e = empList.get(i);
			if(e.getEmp_id()==emp_id) {
				empList.set(i, emp);
				return;
			}
		}
	// To set and find id and data this formula is used
	}

# 21) Add Employyee

   -1) Add mapping in controller class

	@RequestMapping(method=RequestMethod.POST, value="/employees" )
	public void addEmployee(@RequestBody employee emp) {
		empRef.addEmployee(emp);
	}
	- @RequestBody is used to get and change all the employee data

   -2) under Spring Services
   
	@Override
	public void addEmployee(employee emp) {
		// TODO Auto-generated method stub
		empList.add(emp);
	}

# 22) Delete Employee By ID
    -1) Add mapping in controller class

	@RequestMapping(method=RequestMethod.DELETE, value="/employees/{emp_id}" )
	public void deleteEmployee(@PathVariable int emp_id){
		empRef.deleteEmployee(emp_id);
	}
	- @PathVariable is used to check value from employee list

   -2) under Spring Services
   
	@Override
	public void deleteEmployee(int emp_id) {
		// TODO Auto-generated method stub
		empList.removeIf(e -> e.getEmp_id() == emp_id);
	}
	
