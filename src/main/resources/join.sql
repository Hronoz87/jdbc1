select product_name
from customers
         join orders o on customers.ID = o.customer_id
where customers.name like :name;