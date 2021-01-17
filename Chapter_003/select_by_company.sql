select p.name as name, c.name as company
from person p join company c on p.company_id = c.id
where c.id != 5;

select c.name as company, count(*) as stuff
from person p join company c on p.company_id = c.id
group by c.name
order by stuff desc limit 1;