select product_name, customers.name
from customers
         join orders o on customers.ID = o.customer_id
where ucase(customers.name) = ucase(customers.name);