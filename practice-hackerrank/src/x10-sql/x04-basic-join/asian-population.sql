select sum(city.population)
from city
inner join country
    on city.CountryCode = Country.Code
where Country.Continent = 'Asia'