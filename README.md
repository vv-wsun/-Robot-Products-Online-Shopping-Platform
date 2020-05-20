# Robot-Online-Shopping-Platform
Project of 'Hand on Experience on Computer' in BUPT
## Brief Introduction
The platform is developed with Spring and Hibernate framework based on the MVC architecture and the JSP Technology. 
Functions including product display, ordering, purchasing, carting are achieved in the web site.

## Functions
- [x] Registration function
- [x] Login function
- [x] Product display function
- [x] Purchasing function
- [x] Generate a cart function           
- [x] Place an order function
- [x] “Forget your password” function (Extra)
- [x] Modify user information function(Extra)
- [x] Search function

### 1.1	Registration & Login function
In the Index-interface, the pop-up dialog window will remind unregistered visitors to log in and the page will jump to the Login-page automatically. User can choose either to log in or to register a new account in the Login-interface.  

### 1.2	Product display function
By DOM element rendering, the product list, showing basic information and linking to product detail page, is added to the Index-page. 
To provide data on the home page, welcome-file is placed in a Controller. After completing the data preprocessing stage, the data will be returned as a ModelAndView object, and then come into the Index-page for front-end rendering.

### 1.3	Purchasing function
User can choose to purchase any product in the homepage or the detail page.
Once the purchase is complete, the amount and information of the product will be sent back to Controller, and the Cart form will be persisted in Hibernate. 

### 1.4	Generate a cart function 
In the Cart-interface, user can choose whatever product they want, and also can delete whatever product they don’t want by clicking the “delete button” in the upper right corner of the product. 
During the delete process, the RESTful API call DAO to delete the product. Then , after making asynchronous request, the detail page will be re-rendered.

### 1.5	Place an order function
There will be three steps while placing an order:
1.	Delete all the products in the current cart
2.	Generate an unique order number and add the information of these products into the order list
3.	Determine whether the former steps are completed. If true, the order number will be returned to the front end to render and the Order information will be persisted

### 1.6	“Forget your password” function (Extra)
If the password is forgotten, user can find it back via verify identity information. 
The page use vue to render asynchronously, effective and useful.

### 1.7	Modify user information function(Extra)
It is similar to the registration function. In contrast, user need to re-enter personal information, and the data will be persisted.

### 1.8	Search function
In the Index-page, user can perform a fuzzy keyword search based on their demand. If successful, it will jump to the modal box. If not, it will be the dialogue window.


## Business Process
![image](https://github.com/vv-wsun/Robot-Online-Shopping-Platform/blob/master/Business%20Logic.jpg) 
## Change Log
### Version 1.0 (2017/7/20)
- complete Orderlist function 
- improve interface interaction
- complete plan designing

### Version 2.0(2017/8/20)
- introduce Hibernate，simplify the database connection and operation
- introduce spring mvc framework to simplify the business process

### Version 2.1（2017/8/29)
- reconstruct the project with Spring mvc & Spring & Hibernate
- use Vue & Vue-resource to render DOM elements asynchronously in the front-end part

### Version 2.2 (2017/9/16)
- design the RESTful interface specification
- fine tuning of the architecture

### Version 3.0 (2017/9/19)
- perfect order number generation rules
- minute adjunction of the project
